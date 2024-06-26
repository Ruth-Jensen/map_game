import java.util.ArrayList;
import java.util.List;

public class TextWrap {

    public static List<String> wrap(String text, int maxWidth) {
        List<String> wrappedLines = new ArrayList<>();
        
        int offset = 0;
        while (offset < text.length()) {
            // Determine the end of the line
            int end = Math.min(offset + maxWidth, text.length());
            
            // Find the last space within the line
            if (end < text.length()) {
                int space = text.lastIndexOf(' ', end);
                if (space > offset) {
                    end = space;
                }
            }
            
            // Add the substring to the list
            wrappedLines.add(text.substring(offset, end).trim());
            offset = end + 1; // Move past the space
        }
        
        return wrappedLines;
    }
}
