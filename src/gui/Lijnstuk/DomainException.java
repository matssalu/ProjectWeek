package gui.Lijnstuk;
import static java.lang.System.exit;

public class DomainException extends Exception {

    public DomainException(String ErrorMessage){
        super(ErrorMessage);
        exit(0);
    }
}