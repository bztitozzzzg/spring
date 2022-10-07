package mrs.app.reservation.form;

import java.io.Serializable;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ReservationForm implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8794109836203625743L;

    @NotNull(message = "必須です")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @NotNull(message = "必須です")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime endTime;

}
