package lab1.ciphers;

import lab1.services.StringParser;

public class VigenereCipher extends Cipher {
    private final RussianAlphabet alphabet = new RussianAlphabet();

    private String extendKeyToProg(String key) {
        final int LEN = this.input.length();
        StringBuilder stringBuilder = new StringBuilder(key);

        for (int i = 1; stringBuilder.length() < LEN; i++) {
            for (int j = 0; j < key.length() && stringBuilder.length() < LEN; j++) {
                stringBuilder.append(alphabet.getEncodedLetter(key.charAt(j), i, true));
            }
        }

        return stringBuilder.toString();
    }

    @Override
    public String encode(String input, String key) throws EmptyKeyException {
        super.encode(StringParser.parseRussianString(input), StringParser.parseRussianString(key));
        if (this.input.isEmpty()) {
            return "";
        }
        this.key = extendKeyToProg(this.key);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.input.length(); i++) {
            stringBuilder.append(alphabet.getEncodedLetter(this.input.charAt(i),
                    alphabet.getLettersNum(this.key.charAt(i)), true));
        }

        return stringBuilder.toString();
    }

    @Override
    public String decode(String input, String key) throws EmptyKeyException {
        super.encode(StringParser.parseRussianString(input), StringParser.parseRussianString(key));
        if (this.input.isEmpty()) {
            return "";
        }
        this.key = extendKeyToProg(this.key);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.input.length(); i++) {
            stringBuilder.append(alphabet.getEncodedLetter(this.input.charAt(i),
                    alphabet.getLettersNum(this.key.charAt(i)), false));
        }

        return stringBuilder.toString();
    }
}
