package task3;

public class TextCounter {
    static int getTextLength(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }
        return text.length();
    }
}