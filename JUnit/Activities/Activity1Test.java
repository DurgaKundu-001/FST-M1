package Activities;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class Activity1Test {

    static ArrayList<String> list;
    @BeforeEach
    void setUp() throws Exception {
        list = new ArrayList<String>();

        list.add("alpha"); // at index 0

        list.add("beta"); // at index 1
    }

    @Test
    public void insertTest(){
        //int Size= list.size();
        //System.out.println(Size);
        assertEquals(2, list.size(), "Wrong size");
        list.add(2, "charlie");
        assertEquals(3, (list.size()), "Wrong size");
        assertEquals("alpha", list.get(0), "Wrong element");

        assertEquals("beta", list.get(1), "Wrong element");

        assertEquals("charlie", list.get(2), "Wrong element");
    }

    @Test
    public void replaceTest(){
        list.set(1, "charlie");
        assertEquals(2, list.size(), "Wrong size");

        // Assert individual elements

        assertEquals("alpha", list.get(0), "Wrong element");

        assertEquals("charlie", list.get(1), "Wrong element");
    }
}
