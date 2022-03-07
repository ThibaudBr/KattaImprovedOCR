package esgi.groupe12.fileManagement;

import esgi.groupe12.core.tools.fileManagement.ReadFile;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReadFileTest {

    private ReadFile readFile;
    @Before
    public void initialize(){
        String pathFileInput = "src/test/resources/fileInputTest/readFileTest/";
        readFile = new ReadFile(pathFileInput, 20);
    }

    @Test
    public void testGetListFile(){
        List<String> listResultTest = new ArrayList<>();
        listResultTest.add("ocr.txt");
        listResultTest.add("ocr2.txt");

        assertEquals(readFile.getListFiles(), listResultTest);
    }

    @Test
    public void testGetString(){
        List<String> stringListTest = new ArrayList<>();
        stringListTest.add("    _  _  _  _  _  _  _  _ \\");
        stringListTest.add("|_||_   ||_ | ||_|| || || |\\");
        stringListTest.add("  | _|  | _||_||_||_||_||_|\\");
        stringListTest.add("                           \\");
        stringListTest.add("    _  _     _  _  _  _  _ \\");
        stringListTest.add("  | _| _||_||_ |_   ||_|| |\\");
        stringListTest.add("  ||_  _|  | _||_|  ||_||_|\\");
        stringListTest.add("                           \\");

        assertEquals(stringListTest, readFile.getStrings("ocr.txt"));
    }

    @Test
    public void testConcatMaxLigne(){
        List<String> stringListTest = new ArrayList<>();
        List<String> stringListTestResult = new ArrayList<>();
        for (int i = 0; i<23; i++){
            stringListTest.add("    _  _  _  _  _  _  _  _ \\");
        }
        for (int i = 0; i<20; i++){
            stringListTestResult.add("    _  _  _  _  _  _  _  _ \\");
        }

        assertEquals(stringListTestResult, readFile.concatIfMaxLigne(stringListTest));

    }
}
