package esgi.groupe12.core.tools;

import java.util.HashMap;

public enum NumberOCR {
    ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE;

    private String get(){
        switch (this){
            case ZERO:
                return " _ | ||_|   ";

            case ONE:
                return "     |  |   ";

            case TWO:
                return " _  _||_    ";

            case THREE:
                return " _  _| _|   ";

            case FOUR:
                return "   |_|  |   ";

            case FIVE:
                return " _ |_  _|   ";

            case SIX:
                return " _ |_ |_|   ";

            case SEVEN:
                return " _   |  |   ";

            case EIGHT:
                return " _ |_||_|   ";

            case NINE:
                return " _ |_| _|   ";

            default:
                return "?";
        }
    }

    public static HashMap<String, String> initializeCodex() {
        HashMap<String, String> codex = new HashMap<>();

        codex.put(NumberOCR.ZERO.get(), "0");
        codex.put(NumberOCR.ONE.get(), "1");
        codex.put(NumberOCR.TWO.get(), "2");
        codex.put(NumberOCR.THREE.get(), "3");
        codex.put(NumberOCR.FOUR.get(), "4");
        codex.put(NumberOCR.FIVE.get(), "5");
        codex.put(NumberOCR.SIX.get(), "6");
        codex.put(NumberOCR.SEVEN.get(), "7");
        codex.put(NumberOCR.EIGHT.get(), "8");
        codex.put(NumberOCR.NINE.get(), "9");
        return codex;
    }
}
