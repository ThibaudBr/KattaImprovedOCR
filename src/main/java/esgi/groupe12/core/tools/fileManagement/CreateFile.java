package esgi.groupe12.core.tools.fileManagement;

import esgi.groupe12.core.tools.FileType;
import esgi.groupe12.core.tools.OrderList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CreateFile {
    private String pathFileOutput;
    private final OrderList orderList;

    public CreateFile(String pathFileOutput) {
        this.pathFileOutput = pathFileOutput;
        this.orderList = new OrderList();
    }


    public void generateAndWriteFile(List<List<String>> ocrLists, String dateNow){
        for (int i = 0; i < ocrLists.size(); i++){
            generateFile(dateNow + "_" + i);
            writeInFile(dateNow + "_" + i, ocrLists.get(i));
        }
    }

    public void generateAndWriteOrderedFile(List<List<String>> ocrLists, String name){
        Map<FileType, List<String>> orderedMap = orderList.getHashMap(ocrLists);

        generateFile(name + "_" + FileType.AUTHORIZED);
        generateFile(name + "_" + FileType.ERRORED);
        generateFile(name + "_" + FileType.UNKNOWN);

        writeInFile(name + "_" + FileType.AUTHORIZED, orderedMap.get(FileType.AUTHORIZED));
        writeInFile(name + "_" + FileType.ERRORED, orderedMap.get(FileType.ERRORED));
        writeInFile(name + "_" + FileType.UNKNOWN, orderedMap.get(FileType.UNKNOWN));


    }

    private void writeInFile(String name, List<String> ocrList) {
        try {
            FileWriter myWriter = new FileWriter(pathFileOutput + name + ".txt");
            for (String s : ocrList) {
                myWriter.write(s + "\n" );
            }
            myWriter.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void generateFile(String name){
        try {
            File outputFile = new File(pathFileOutput + name + ".txt");
            outputFile.createNewFile();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void setPathFileOutput(String pathFileOutput) {
        this.pathFileOutput = pathFileOutput;
    }

    public String getPathFileOutput() {
        return pathFileOutput;
    }
}
