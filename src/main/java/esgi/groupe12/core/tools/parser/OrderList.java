package esgi.groupe12.core.tools.parser;

import esgi.groupe12.core.tools.fileManagement.FileType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderList {


    public OrderList() {
    }

    public HashMap<FileType, List<String>> getHashMap(List<List<String>> allOcrList) {
        HashMap<FileType, List<String>> orderedMap = new HashMap<>();
        List<String> authorizedList = new ArrayList<>();
        List<String> errorList = new ArrayList<>();
        List<String> unknownList = new ArrayList<>();

        for (List<String> ocrList: allOcrList){
            authorizedList.addAll(getAuthorized(ocrList));
            errorList.addAll(getErrored(ocrList));
            unknownList.addAll(getUnknown(ocrList));
        }

        orderedMap.put(FileType.AUTHORIZED, authorizedList);
        orderedMap.put(FileType.ERRORED, errorList);
        orderedMap.put(FileType.UNKNOWN, unknownList);

        return orderedMap;
    }

    private List<String> getUnknown(List<String> ocrList) {
        List<String> resultList = new ArrayList<>();
        for (String s: ocrList){
            if (s.contains(" ILL")){
                resultList.add(s);
            }
        }
        return resultList;
    }

    private List<String> getErrored(List<String> ocrList) {
        List<String> resultList = new ArrayList<>();
        for (String s: ocrList){
            if (s.contains(" ERR")){
                resultList.add(s);
            }
        }
        return resultList;
    }

    private List<String> getAuthorized(List<String> ocrList) {
        List<String> resultList = new ArrayList<>();
        for (String s: ocrList){
            if (!s.contains(" ERR") && !s.contains(" ILL")){
                resultList.add(s);
            }
        }
        return resultList;
    }
}
