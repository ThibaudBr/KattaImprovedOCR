package esgi.groupe12.core.tools.parser;

import java.security.InvalidParameterException;
import java.util.HashMap;

public interface CodexOCR {
    String ZERO = " _ | ||_|   ";
    String ONE = "     |  |   ";
    String TWO = " _  _||_    ";
    String THREE = " _  _| _|   ";
    String FOUR = "   |_|  |   ";
    String FIVE = " _ |_  _|   ";
    String SIX = " _ |_ |_|   ";
    String SEVEN = " _   |  |   ";
    String EIGHT = " _ |_||_|   ";
    String NINE = " _ |_| _|   ";

    static HashMap<String, String> initializeCodex(int height, int length){
        if (height == 4 && length == 3){
            return initializeCodex43();
        }else{
            throw new InvalidParameterException("InvalidParameterException: No codex for the parameter" + height + " and " + length);
        }
    }

    static private HashMap<String, String> initializeCodex43() {
        HashMap<String, String> codex = new HashMap<>();

        codex.put(ZERO, "0");
        codex.put(ONE, "1");
        codex.put(TWO, "2");
        codex.put(THREE, "3");
        codex.put(FOUR, "4");
        codex.put(FIVE, "5");
        codex.put(SIX, "6");
        codex.put(SEVEN, "7");
        codex.put(EIGHT, "8");
        codex.put(NINE, "9");
        return codex;
    }

}
