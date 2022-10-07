package mrs.domain.exception;

public class AlreadyReservedException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -4919847994994705759L;

    public AlreadyReservedException(String message) {
        super(message);
    }
}
