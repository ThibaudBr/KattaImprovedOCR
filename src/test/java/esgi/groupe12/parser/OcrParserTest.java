package esgi.groupe12.parser;

import esgi.groupe12.core.tools.parser.OcrParser;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OcrParserTest {

    private OcrParser ocrParser;

    @Before
    public void initialize(){
        int height = 4;
        int length = 3;
        ocrParser = new OcrParser(height, length);
    }

    @Test
    public void testCountRun(){
        List<String> list = new ArrayList<>();
        list.add("120");
        list.add("120");
        list.add("120");
        list.add("120");
        list.add("120");
        list.add("120");
        list.add("120");
        list.add("120");
        list.add("120");

        assertEquals(2, ocrParser.countNbRun(list));
    }

    @Test
    public void testRunSubList(){
        List<String> stringListTest = new ArrayList<>();
        stringListTest.add("    _  _  _  _  _  _  _  _ \\");
        stringListTest.add("|_||_   ||_ | ||_|| || || |\\");
        stringListTest.add("  | _|  | _||_||_||_||_||_|\\");
        stringListTest.add("                           \\");


        assertEquals("457508000", ocrParser.runSublist(stringListTest));
    }

    @Test
    public void testIsWithError(){
        StringBuilder stringTest = new StringBuilder();
        stringTest.append("4578?100");

        assertEquals(" ILL", ocrParser.isWithErrorOrUnknown(stringTest));
    }

    @Test
    public void testIsWithUnknown(){
        StringBuilder stringTest = new StringBuilder();
        stringTest.append("457801880");

        assertEquals(" ERR", ocrParser.isWithErrorOrUnknown(stringTest));
    }

    @Test
    public void testParse(){
        List<String> stringListTest = new ArrayList<>();
        stringListTest.add("    _  _  _  _  _  _  _  _ \\");
        stringListTest.add("|_||_   ||_ | ||_|| || || |\\");
        stringListTest.add("  | _|  | _||_||_||_||_||_|\\");
        stringListTest.add("                           \\");

        assertEquals("   |_|  |   ", ocrParser.parse(0, stringListTest));
        assertEquals(" _   |  |   ", ocrParser.parse(6, stringListTest));
    }

    @Test
    public void testParseEight(){
        List<String> stringListTest = new ArrayList<>();
        stringListTest.add("    _  _  _  _  _  _  _  _ \\");
        stringListTest.add("|_||_   ||_ | ||_|| || || |\\");
        stringListTest.add("  | _|  | _||_||_||_||_||_|\\");
        stringListTest.add("                           \\");

        assertEquals("|_|", ocrParser.parseEight(1, 0, stringListTest).toString());
        assertEquals("  |", ocrParser.parseEight(2, 6, stringListTest).toString());
    }
}
