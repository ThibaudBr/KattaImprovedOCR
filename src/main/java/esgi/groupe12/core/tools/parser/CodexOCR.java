package esgi.groupe12.core.tools.parser;

import java.security.InvalidParameterException;
import java.util.HashMap;

public class CodexOCR {

    public HashMap<String, String> initializeCodex(int height, int length){
        if (height == 4 && length == 3){
            return initializeCodex43();
        }else{
            throw new InvalidParameterException("InvalidParameterException: No codex for the parameter" + height + " and " + length);
        }
    }

    private HashMap<String, String> initializeCodex43() {
        HashMap<String, String> codex = new HashMap<>();

        codex.put( " _ | ||_|   ", "0");
        codex.put("     |  |   ", "1");
        codex.put(" _  _||_    ", "2");
        codex.put(" _  _| _|   ", "3");
        codex.put("   |_|  |   ", "4");
        codex.put(" _ |_  _|   ", "5");
        codex.put(" _ |_ |_|   ", "6");
        codex.put(" _   |  |   ", "7");
        codex.put(" _ |_||_|   ", "8");
        codex.put(" _ |_| _|   ", "9");
        return codex;
    }

}
