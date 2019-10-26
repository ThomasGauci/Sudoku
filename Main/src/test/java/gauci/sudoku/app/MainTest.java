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
{/*
    private static int grille[][];

    @Before
    public final void setUp() {
        grille = new int[9][9];
    }

    @Test
    public final void ajouterTest(String str){
        /*
         * Tests : Les coordonnées sont elles bien ajoutées ?
         *//*
        Io io = new Io();
        grille = io.lire();
        String strTest ="111";
        ajouter(strTest);
        assertEquals(1, grille[0][0]);
    }

    @Test
    public final void validationCoupTest(String coup){
        /*
         * Tests : Le coup est il bien vérifié ?
         *//*
        grille[0][0]=1;
        grille[1][6]=3;

        assertEquals(false,validationCoup("221"));
        assertEquals(false,validationCoup("161"));
        assertEquals(false,validationCoup("411"));
        assertEquals(true,validationCoup("241"));
        assertEquals(true,validationCoup("161"));
        assertEquals(false,validationCoup("778"));
        assertEquals(false,validationCoup("188"));
        assertEquals(false,validationCoup("498"));
        assertEquals(true,validationCoup("458"));
        assertEquals(true,validationCoup("838"));
    }*/
}
