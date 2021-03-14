import com.sda.kth.ToDoListCF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoListCFTest {
    @Test
    void CheckOrdinalIndexOfAStiring() {
        ToDoListCF ComFunc = new ToDoListCF();
        ComFunc.ordinalIndexOf("BluePrint is started", "is", 20);
        assertEquals(ComFunc.ordinalIndexOf("BluePrint", "Print", 9), 0);
    }

    @Test
    void CheckRightPaddingForAgivenStirng() {
        ToDoListCF ComFunc = new ToDoListCF();
        String Expected = "Today is sunday";
        assertEquals(ComFunc.rightPadding("Today issunday",'s',14),Expected);
    }


}