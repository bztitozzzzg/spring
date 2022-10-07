package mrs.domain.exception;

public class UnavailableReservationException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3060635983445886595L;

    public UnavailableReservationException(String message) {
        super(message);
    }
}
