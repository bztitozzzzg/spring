package mrs.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservableRoomId implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1992666431015096742L;

    /**
     * ルームID
     */
    private Integer roomId;

    /**
     * 予約日
     */
    @Column(name = "reserved_date", columnDefinition = "DATE")
    private LocalDate reservedDate;

}
