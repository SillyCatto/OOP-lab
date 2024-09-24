import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumWordPrinterTest {

    @Test
    public void testDivBy2(){
        NumWordPrinter nwPrinter = new NumWordPrinter();
        assertEquals("Even", nwPrinter.printWord(2));
    }

    @Test
    public void testDivBy11(){
        NumWordPrinter nwPrinter = new NumWordPrinter();
        assertEquals("PrimeEleven", nwPrinter.printWord(121));
    }

    @Test
    public void testDivBy13(){
        NumWordPrinter nwPrinter = new NumWordPrinter();
        assertEquals("LuckyThirteen", nwPrinter.printWord(169));
    }

    @Test
    public void testDivBy2and11(){
        NumWordPrinter nwPrinter = new NumWordPrinter();
        assertEquals("EvenPrimeEleven", nwPrinter.printWord(22));
    }

    @Test
    public void testDivBy2_11_13(){
        NumWordPrinter nwPrinter = new NumWordPrinter();
        assertEquals("EvenPrimeLucky", nwPrinter.printWord(286));
    }

}