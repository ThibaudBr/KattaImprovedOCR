package esgi.groupe12;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import esgi.groupe12.core.tools.FileType;
import esgi.groupe12.core.tools.fileManagement.ReadFile;
import esgi.groupe12.core.tools.parser.OcrParser;
import esgi.groupe12.core.tools.parser.OrderList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OcrParserUserCaseTest
{
    private String pathFileInput;
    private int maxLigneInfile;
    private int heightOCR;
    private int lengthOCR;

    @Before
    public void initialize(){
        pathFileInput = "src/test/resources/fileInputTest/";
        heightOCR = 4;
        lengthOCR = 3;
        maxLigneInfile = 100 * heightOCR;

    }

    @Test
    public void TestUserCase1()
    {
        ReadFile readFile = new ReadFile(
                pathFileInput + "userCase1/",
                maxLigneInfile
        );
        OcrParser ocrParser = new OcrParser(heightOCR, lengthOCR);

        List<String> ocrList = readFile.getStrings("TestUserCase1.txt");
        assertEquals("[123456789]", ocrParser.run(ocrList).toString());
    }

    @Test
    public void TestUserCase1_101Entrees()
    {
        ReadFile readFile = new ReadFile(
                pathFileInput + "userCase1/",
                maxLigneInfile
        );
        OcrParser ocrParser = new OcrParser(heightOCR, lengthOCR);

        List<String> ocrList = readFile.getStrings("TestUserCase1_101Entrees.txt");
        assertEquals(
                "[123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789," +
                        " 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789," +
                        " 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789," +
                        " 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789," +
                        " 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789," +
                        " 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789," +
                        " 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789," +
                        " 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789," +
                        " 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789," +
                        " 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789, 123456789]",
                ocrParser.run(ocrList).toString());
    }

    @Test
    public void TestUserCase2()
    {
        OcrParser ocrParser = new OcrParser(heightOCR, lengthOCR);
        assert ocrParser.calculChecksum(new StringBuilder("123456789"));
    }

    @Test
    public void TestUserCase3()
    {
        ReadFile readFile = new ReadFile(
                pathFileInput + "userCase3/",
                maxLigneInfile
        );
        OcrParser ocrParser = new OcrParser( heightOCR, lengthOCR);

        List<String> ocrList = readFile.getStrings("TestUserCase3.txt");
        assertEquals("[123456789, 123456780 ERR]", ocrParser.run(ocrList).toString());
    }

    @Test
    public void TestUserCase4()
    {
        ReadFile readFile = new ReadFile(
                pathFileInput + "userCase4/",
                maxLigneInfile
        );
        OcrParser ocrParser = new OcrParser( heightOCR, lengthOCR);

        List<String> ocrList = readFile.getStrings("TestUserCase4.txt");
        assertEquals("[123456789, 123456780 ERR, 12345678? ILL]", ocrParser.run(ocrList).toString());
    }

    @Test
    public void TestUserCase5()
    {
        HashMap<FileType, List<String>> orderedList;
        List<List<String>> listOcr = new ArrayList<>();
        ReadFile readFile = new ReadFile(
                pathFileInput + "userCase5/",
                maxLigneInfile
        );
        OrderList orderList = new OrderList();

        List<List<String>> ocrList = readFile.getAllString();
        OcrParser ocrParser = new OcrParser( heightOCR, lengthOCR);
        for (List<String> list: ocrList){
            listOcr.add(ocrParser.run(list));
        }

        orderedList = orderList.getHashMap(listOcr);
        assertEquals("[123456789, 123456789, 123456789, 123456789, 123456789]", orderedList.get(FileType.AUTHORIZED).toString());
        assertEquals("[123456780 ERR, 123456780 ERR, 123456780 ERR, 123456780 ERR]", orderedList.get(FileType.ERRORED).toString());
        assertEquals("[12345678? ILL, 12345678? ILL, 12345678? ILL]", orderedList.get(FileType.UNKNOWN).toString());
    }
}
