package gauci.sudoku.app;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GuiTest 
{
    private Gui testGui;

    @Before
    public final void setUp() {
        testGui = new Gui();
    }

    @Test
    public final  void verifClavierTest(){
        String testString[] = new String[1];
        testString[0]="178";
        assertEquals(true,Gui.verifClavier(testString));
        testString[0]="1289";
        assertEquals(true,Gui.verifClavier(testString));
        testString[0]="012";
        assertEquals(false,Gui.verifClavier(testString));
        testString[0]="coucou";
        assertEquals(true,Gui.verifClavier(testString));
        testString[0]="exit";
        assertEquals(true,Gui.verifClavier(testString));
        testString[0]="help";
        assertEquals(true,Gui.verifClavier(testString));
        testString[0]="save";
        assertEquals(true,Gui.verifClavier(testString));
        testString[0]="load";
        assertEquals(false,Gui.verifClavier(testString));
        testString[0]="#¨+::";
        assertEquals(false,Gui.verifClavier(testString));
    }
    
}
