package esgi.groupe12.core.tools.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class OcrParser {
    private final HashMap<String, String> codex;
    private final int height;
    private final int length;

    public OcrParser(int height, int length) {
        this.height = height;
        this.length = length;
        this.codex = CodexOCR.initializeCodex(height, length);
    }

    public List<String> run(List<String> ocrList){
        List<String> finalResult = new ArrayList<>();

        int nbRun = countNbRun(ocrList);
        for (int i = 0; i < nbRun; i++){
            finalResult.add(runSublist(ocrList.subList(i*height, i*height+height)));
        }
        return finalResult;
    }

    private int countNbRun(List<String> ocrList) {
        return (ocrList.size() - ocrList.size()%height) / 4;
    }

    private String runSublist(List<String> ocrSublist) {
        StringBuilder result = new StringBuilder();
        String value;

        for (int i = 0; i < length*9; i += length ){
            value = codex.get(parse(i, ocrSublist));
            result.append(Objects.requireNonNullElse(value, "?"));
        }

        if (result.toString().contains("?")){
            result.append(" ILL");
        }else if (calculChecksum(result)){
            result.append(" ERR");
        }

        return result.toString();
    }

    public boolean calculChecksum(StringBuilder result) {
        int modulo = 0;
        for (int i = 1; i < 10; i++){
            modulo += (10-i) * Character.getNumericValue(result.charAt(i-1));
        }
        return modulo%11 != 0;
    }

    private String parse(int pos, List<String> ocr){
        StringBuilder number = new StringBuilder();
        for(int i = 0; i<this.height; i++){
            for(int j = pos; j<pos+3; j++){
                number.append((ocr.get(i)).charAt(j));
            }
        }
        return number.toString();
    }

}
