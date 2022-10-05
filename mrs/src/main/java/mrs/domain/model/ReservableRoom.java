package mrs.domain.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Data;

@Data
@Entity
public class ReservableRoom implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -4375167871276853186L;

    /**
     * 予約可能ルームID
     */
    @EmbeddedId
    private ReservableRoomId reservableRoomId;

    /**
     * 会議室
     */
    @ManyToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    @MapsId("roomId")
    private MeetingRoom meetingRoom;

}
