package mrs.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class MeetingRoom implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6242515323396386134L;

    /**
     * ルームID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;

    /**
     * ルーム名
     */
    private String roomName;

}
