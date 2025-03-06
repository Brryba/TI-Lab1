package lab1.ciphers;

public class EmptyKeyException extends Exception {
    public EmptyKeyException() {
        super("Ключ не содержит корректных символов!");
    }
}
