package section15.customexception.model.exceptions;

public class DomainException extends RuntimeException {

    public DomainException(String msg) {
        super(msg);
    }
}
