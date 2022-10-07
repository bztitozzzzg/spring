package mrs.domain.service.room;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mrs.domain.model.MeetingRoom;
import mrs.domain.model.ReservableRoom;
import mrs.domain.repository.room.MeetingRoomRepository;
import mrs.domain.repository.room.ReservableRoomRepository;

@Service
@Transactional
public class RoomService {

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    @Autowired
    ReservableRoomRepository reservableRoomRepository;

    /**
     * 会議室検索
     * @param roomId 部屋ID
     * @return 検索結果
     */
    public MeetingRoom findMeetingRoom(Integer roomId) {
        return meetingRoomRepository.findById(roomId).get();
    }

    /**
     * 予約可能部屋検索
     * @param date 日付
     * @return 検索結果
     */
    public List<ReservableRoom> findReservableRooms(LocalDate date) {
        return reservableRoomRepository
                .findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(
                        date);
    }
}
