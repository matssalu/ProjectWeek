package domain.Rechthoek;

public class DomainException extends RuntimeException{
    public DomainException(String ErrorMessage){
        super(ErrorMessage);
    }
}
