package lab1.services;

public abstract class StringParser {
    private static boolean isEnglishLetter(char ch) {
        ch = Character.toUpperCase(ch);
        return ch >= 'A' && ch <= 'Z';
    }

    private static boolean isRussianLetter(char ch) {
        ch = Character.toUpperCase(ch);
        return ch >= 'А' && ch <= 'Я' || ch == 'Ё';
    }

    public static String parseEnglishString(String str) {
        str = str.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (isEnglishLetter(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String parseRussianString(String str) {
        str = str.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (isRussianLetter(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
