package esgi.groupe12.core.tools.fileManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile
{
    private String pathFileInput;
    private final int maxLigneInFile;

    public ReadFile(String pathFileInput, int maxLigneInFile) {
        this.pathFileInput = pathFileInput;
        this.maxLigneInFile = maxLigneInFile;
    }

    public List<List<String>> getAllString(){
        List<List<String>> allStrings = new ArrayList<>();
        for (String s: getListFiles()){
            allStrings.add(getStrings(s));
        }
        return allStrings;
    }

    public List<String> getListFiles(){
            File directoryPath = new File(pathFileInput);
            return Arrays.asList(Objects.requireNonNull(directoryPath.list()));
    }

    public List<String> getStrings(String fileName){
        File ocrFile = new File(pathFileInput + fileName);

        List<String> ocrStrings = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(ocrFile);
            while (scanner.hasNextLine()){
                ocrStrings.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return concatIfMaxLigne(ocrStrings);
    }

    public List<String> concatIfMaxLigne(List<String> ocrString){
        if (ocrString.size() > maxLigneInFile){
            return ocrString.subList(0, maxLigneInFile);
        }else{
            return ocrString;
        }
    }

    public void setPathFileInput(String pathFileInput) {
        this.pathFileInput = pathFileInput;
    }

    public String getPathFileInput() {
        return pathFileInput;
    }
}
