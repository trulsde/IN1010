import java.util.NoSuchElementException;

public class CustomException extends Exception {
    
    public CustomException(String message) {
        super(message);
    }
}
class OtherCustomException extends NoSuchElementException { // Eller hvilkensomhelst annen exception
    public OtherCustomException(int tall) {
        super("Denne meldinga og "+tall+" skrives ut");
    }
}