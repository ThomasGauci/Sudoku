package gauci.sudoku.app;

import static org.junit.Assert.*;

import java.beans.Transient;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import org.junit.rules.TemporaryFolder;
import java.io.*;
import java.util.Arrays;

public class IoTest 
{
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    private Io testIo;

    @Before
    public final void setUp() {
        testIo = new Io();
    }

    @Test
    public final void lireTest(){
        int grilleLu[][];
        int grilleReponse[][]={{0,0,4,0,0,5,0,0,0},
            {3,0,0,4,0,0,0,9,0},
            {0,0,0,0,2,0,0,0,0},
            {0,0,0,3,0,9,0,0,6},
            {0,3,2,0,0,7,0,0,5},
            {5,0,7,0,0,0,0,0,4},
            {0,5,0,0,0,0,4,3,0},
            {0,8,0,1,3,0,0,0,0},
            {9,0,0,0,0,0,0,0,7}};

        testIo.ecrire("lireTest",grilleReponse);
        grilleLu = testIo.lire();
        for(int i = 0; i<9;i++){
            for(int j = 0; j<9;j++){
            assertEquals(grilleReponse[i][j],grilleLu[i][j]);
            }
        }
    }

    @Test
    public final void ecrireTest(){
        int grilleLu[][];
        int grilleReponse[][]={{1,2,4,0,0,5,0,0,0},
            {3,0,0,4,0,0,0,9,0},
            {0,0,0,0,2,0,0,0,0},
            {0,0,0,3,0,9,0,0,6},
            {0,3,2,0,0,7,0,0,5},
            {5,0,7,0,0,0,0,0,4},
            {0,5,0,0,0,0,4,3,0},
            {0,8,0,1,3,0,0,0,0},
            {9,0,0,0,0,0,0,0,7}};

        testIo.ecrire("ecrireTest",grilleReponse);
        grilleLu = testIo.lire("./ecrireTest.txt");
        for(int i = 0; i<9;i++){
            for(int j = 0; j<9;j++){
            assertEquals(grilleReponse[i][j],grilleLu[i][j]);
            }
        }
    }
}
