package domain.db;

public class DbException extends RuntimeException{

    public DbException(String message) {
        super(message);
    }

    public DbException() {
        super();
    }
}