import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxStackTest {

    @Test
    void testGetMax() {
        MaxStack mxStack = new MaxStack();

        mxStack.push(3);
        mxStack.push(3);
        mxStack.push(19);
        mxStack.push(0);
        mxStack.push(7);

        assertEquals(19, mxStack.getMax());
    }

    @Test
    void testGetMaxAfterPopping(){
        MaxStack mxStack = new MaxStack();

        mxStack.push(3);
        mxStack.push(5);
        mxStack.push(19);
        mxStack.push(0);
        mxStack.push(7);
        mxStack.push(21);

        assertEquals(21, mxStack.getMax());

        mxStack.pop();

        assertEquals(19, mxStack.getMax());
    }

}