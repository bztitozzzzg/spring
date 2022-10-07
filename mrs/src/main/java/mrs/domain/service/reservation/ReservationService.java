package mrs.domain.service.reservation;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mrs.domain.exception.AlreadyReservedException;
import mrs.domain.exception.UnavailableReservationException;
import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;
import mrs.domain.model.Reservation;
import mrs.domain.model.RoleName;
import mrs.domain.model.User;
import mrs.domain.repository.reservation.ReservationRepository;
import mrs.domain.repository.room.ReservableRoomRepository;

@Service
@Transactional
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservableRoomRepository reservableRoomRepository;

    /**
     * 予約
     * @param reservation 予約情報
     * @return 実行結果
     */
    public Reservation reserve(Reservation reservation) {
        ReservableRoomId reservableRoomId = reservation.getReservableRoom()
                .getReservableRoomId();
        // 対象の部屋が予約可能かどうかチェック
        ReservableRoom reservable = reservableRoomRepository.findAll().get(0);
        if (reservable == null) {
            // 例外をスローする
            throw new UnavailableReservationException("入力の日付・部屋の組み合わせは予約できません。");
        }
        // 重複チェック
        boolean overlap = reservationRepository
                .findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(
                        reservableRoomId).stream().anyMatch(x -> x.overlap(
                                reservation));
        if (overlap) {
            // 例外をスローする
            throw new AlreadyReservedException("入力の時間帯はすでに予約済です。");
        }
        reservationRepository.save(reservation);
        return reservation;
    }

    /**
     * キャンセル
     * @param reservationId 予約ID
     * @param requestUser 要求ユーザ
     */
    public void cancel(Integer reservationId, User requestUser) {
        Reservation reservation = reservationRepository.findAll().get(0);
        if (RoleName.ADMIN != requestUser.getRoleName() && !Objects.equals(
                reservation.getUser().getUserId(), requestUser.getUserId())) {
            throw new IllegalStateException("要求されたキャンセルは許可できません。");
        }
        reservationRepository.delete(reservation);
    }

    /**
     * 予約情報検索
     * @param reservableRoomId 予約可能部屋ID
     * @return 検索結果
     */
    public List<Reservation> findReservations(
            ReservableRoomId reservableRoomId) {
        return reservationRepository
                .findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(
                        reservableRoomId);
    }
}
