package gauci.sudoku.app;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import gauci.sudoku.app.Io;
import gauci.sudoku.app.Main;
/**
 * Unit test for simple App.
 */
public class MainTest 
{
    
    public static int grille[][];
    Main mainTest;

    @Before
    public final void setUp() {
        mainTest = new Main();
        mainTest.grille = new int[9][9];
    }

    @Test
    public final void ajouterTest(){
        /*
         * Tests : Les coordonnées sont elles bien ajoutées ?
         */
        Io io = new Io();
        mainTest.grille = io.lire();
        String strTest ="111";
        mainTest.ajouter(strTest);
        assertEquals(1, mainTest.grille[0][0]);
    }

    @Test
    public final void validationCoupTest(){
        /*
         * Tests : Le coup est il bien vérifié ?
         */
        mainTest.grille[0][0]=1;
        mainTest.grille[8][7]=8;

        assertEquals(true,mainTest.validationCoup("221"));
        assertEquals(false,mainTest.validationCoup("161"));
        assertEquals(true,mainTest.validationCoup("411"));
        assertEquals(true,mainTest.validationCoup("241"));
        assertEquals(false,mainTest.validationCoup("161"));

        assertEquals(false,mainTest.validationCoup("778"));
        assertEquals(false,mainTest.validationCoup("188"));
        assertEquals(true,mainTest.validationCoup("498"));
        assertEquals(false,mainTest.validationCoup("458"));
        assertEquals(true,mainTest.validationCoup("838"));
    }
}
