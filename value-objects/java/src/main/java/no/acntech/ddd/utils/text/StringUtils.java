package no.acntech.ddd.utils.text;

public final class StringUtils {

    private StringUtils() {
    }

    private static final String ELLIPSIS = "...";

    public static String truncate(String text, int length) {
        return truncate(text, length, false, false);
    }

    public static String truncate(String text, int length, boolean sliceFromStart, boolean ellipsis) {
        String placeholder = "";
        int placeLength = 0;

        if (ellipsis) {
            placeholder = ELLIPSIS;
            placeLength = placeholder.length();
        }

        if (text.length() > length) {
            if (sliceFromStart) {
                return placeholder + text.substring(placeLength + length);
            } else {
                return text.substring(0, length - placeLength) + placeholder;
            }
        } else {
            return text;
        }
    }
}
