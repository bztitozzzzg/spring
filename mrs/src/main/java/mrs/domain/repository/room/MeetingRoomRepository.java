package mrs.domain.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;

import mrs.domain.model.MeetingRoom;

/**
 * 会議室リポジトリ
 * @author T_ITO
 */
public interface MeetingRoomRepository extends
                                       JpaRepository<MeetingRoom, Integer> {

}
