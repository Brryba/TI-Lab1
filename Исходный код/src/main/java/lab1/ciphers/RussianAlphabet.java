package lab1.ciphers;

public class RussianAlphabet {
    public static final int LETTERS_COUNT = 33;
    private final char[] letters = new char[LETTERS_COUNT];

    public RussianAlphabet() {
        int ЁPosition = 6;
        for (int i = 0; i < ЁPosition; i++) {
            letters[i] = (char) ('А' + i);
        }
        letters[ЁPosition] = 'Ё';
        for (int i = ЁPosition + 1; i < LETTERS_COUNT; i++) {
            letters[i] = (char) ('А' + i - 1);
        }
    }

    public int getLettersNum(char ch) {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    public char getEncodedLetter(char plainLetter, int key, boolean isEncoding) {
        int plainLetterPos = this.getLettersNum(plainLetter);
        return letters[(isEncoding ? plainLetterPos + key : plainLetterPos - key + LETTERS_COUNT) % LETTERS_COUNT];
    }
}
