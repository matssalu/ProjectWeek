package domain.Vorm;

public class UiException extends RuntimeException {
    public UiException(){

    }

    public UiException(String message){
        super(message);
    }
}