package lab1.ciphers;

import javafx.util.Pair;
import lab1.services.StringParser;

import java.util.*;
import java.util.stream.IntStream;

public class ColumnCipher extends Cipher {
    private List<char[]> matrix;
    private List<Pair<Integer, Character>> colIndexes;

    private void initializeColIndexes() {
        this.colIndexes = new ArrayList<>();
        for (int i = 0; i < this.key.length(); i++) {
            this.colIndexes.add(new Pair<>(i, this.key.charAt(i)));
        }
        colIndexes.sort((o1, o2) -> o1.getValue() >= o2.getValue() ? 1 : -1);
    }

    private void initializeEncodingMatrix() {
        matrix = new ArrayList<>();
        int len = this.key.length();
        for (int i = 0; i < this.input.length(); i += len) {
            char[] row = new char[len];
            matrix.add(row);
            for (int j = 0; j < len && i + j < this.input.length() ; j++) {
                row[j] = this.input.charAt(i + j);
            }
        }
    }

    private String parseEncodedString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < this.key.length(); i++) {
            int index = colIndexes.get(i).getKey();
            for (char[] chars : matrix) {
                stringBuilder.append(chars[index]);
            }
        }

        return stringBuilder.toString();
    }

    @Override
    public String encode(String input, String key) throws EmptyKeyException {
        super.encode(StringParser.parseEnglishString(input),
                StringParser.parseEnglishString(key.toLowerCase()));
        initializeEncodingMatrix();
        initializeColIndexes();
        return parseEncodedString();
    }

    public void initializeDecodingMatrix() {
        matrix = new ArrayList<>();
        int len = this.key.length();
        for (int i = 0; i < this.input.length(); i += len) {
            matrix.add(new char[len]);
        }

        int currChar = 0;
        for (int i = 0; i < len; i++) {
            int index = colIndexes.get(i).getKey();

            for (int j = 0; j * len + index < this.input.length(); j++) {
                matrix.get(j)[index] = this.input.charAt(currChar++);
            }
        }
    }

    private String parseDecodedString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] row : this.matrix) {
            stringBuilder.append(row);
        }
        return stringBuilder.toString();
    }

    @Override
    public String decode(String input, String key) throws EmptyKeyException {
        super.decode(StringParser.parseEnglishString(input),
                StringParser.parseEnglishString(key));
        initializeColIndexes();
        initializeDecodingMatrix();
        return parseDecodedString();
    }
}
