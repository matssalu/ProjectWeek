package domain.Lijnstuk;

public class DomainException extends RuntimeException {

    public DomainException(String ErrorMessage){
        super(ErrorMessage);
    }
}