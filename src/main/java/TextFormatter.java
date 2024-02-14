public class TextFormatter {
    static String formatToUpperCase(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Provided argument is null or empty");
        } else {
            return text.toUpperCase();
        }
    }
}