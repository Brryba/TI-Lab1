package lab1.ciphers;

import lab1.services.ErrorViewer;
import lab1.services.StringParser;

import java.security.InvalidParameterException;

public abstract class Cipher {
    protected String input;
    protected String key;

    protected void setFields(String input, String key) throws EmptyKeyException {
        this.input = input;
        this.key = key;
        if (this.key.isEmpty()) {
            throw new EmptyKeyException();
        }
    }

    public String encode(String input, String key) throws EmptyKeyException {
        this.setFields(input, key);
        return null;
    }

    public String decode(String input, String key) throws EmptyKeyException {
        this.setFields(input, key);
        return null;
    }
}
