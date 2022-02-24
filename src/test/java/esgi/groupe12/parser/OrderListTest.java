package esgi.groupe12.parser;

import esgi.groupe12.core.tools.FileType;
import esgi.groupe12.core.tools.parser.OrderList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderListTest {

    private OrderList orderList;
    private HashMap<FileType, List<String>> orderedMapTest;
    private List<List<String>> unorderedList;
    @Before
    public void initialize(){
        orderList = new OrderList();

        orderedMapTest = new HashMap<>();
        List<String> authorizedListTest = new ArrayList<>();
        List<String> errorListTest = new ArrayList<>();
        List<String> unknownListTest = new ArrayList<>();

        authorizedListTest.add("123456789");
        authorizedListTest.add("987654321");
        unknownListTest.add("12345678? ILL");
        unknownListTest.add("9876?4321 ILL");
        errorListTest.add("987654321 ERR");
        errorListTest.add("123456789 ERR");

        orderedMapTest.put(FileType.AUTHORIZED, authorizedListTest);
        orderedMapTest.put(FileType.ERRORED, errorListTest);
        orderedMapTest.put(FileType.UNKNOWN, unknownListTest);

        unorderedList = new ArrayList<>();
        unorderedList.add(authorizedListTest);
        unorderedList.add(unknownListTest);
        unorderedList.add(errorListTest);
    }

    @Test
    public void testGetHashmap(){
        assertEquals(orderedMapTest, orderList.getHashMap(unorderedList));
    }

    @Test
    public void testGetUnknown(){
        List<String> result = new ArrayList<>();

        for (List<String> strings : unorderedList) {
            result.addAll(orderList.getUnknown(strings));
        }
        assertEquals(orderedMapTest.get(FileType.UNKNOWN), result);
    }

    @Test
    public void testGetErrored(){
        List<String> result = new ArrayList<>();

        for (List<String> strings : unorderedList) {
            result.addAll(orderList.getErrored(strings));
        }
        assertEquals(orderedMapTest.get(FileType.ERRORED), result);
    }

    @Test
    public void testGetAuthorized(){
        List<String> result = new ArrayList<>();

        for (List<String> strings : unorderedList) {
            result.addAll(orderList.getAuthorized(strings));
        }
        assertEquals(orderedMapTest.get(FileType.AUTHORIZED), result);
    }
}
