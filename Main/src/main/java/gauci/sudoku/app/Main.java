package gauci.sudoku.app;

import gauci.sudoku.app.Gui;
import java.lang.Math;
/**
 * Hello world!
 *
 */
// clear && mvn install && cd Main && mvn exec:java && cd ..
public class Main 

{
    public static int grille[][];

    public static void main( String[] args ){
        Gui gui = new Gui();
        Io io = new Io();
        grille = new int[9][9];
        String mots[];
        boolean coup;

        if(args[0]!=null){
            grille = io.lire(args[0]);
        }else{
            grille = io.lire();
        }
        while(true){
            gui.afficherGrille(grille);
            mots = gui.recupClavier();
            if(gui.verifClavier(mots)){
                if(mots[0].equals("load") || mots[0].equals("save") || mots[0].equals("exit") || mots[0].equals("help")){
                    if(mots[0].equals("save")){
                        // Ajouter nom de la grille -save grille90
                        io.ecrire(mots[1],grille);
                    }
                    if(mots[0].equals("load")){
                        // Ajouter nom et chemin  -load /test/pil.txt
                        grille = io.lire(mots[1]);
                    }
                    if(mots[0].equals("exit")){
                        System.exit(0);
                    }
                    if(mots[0].equals("help")){
                        gui.help();
                    }
                }else{
                    coup = validationCoup(mots[0]);
                    if(coup){
                        ajouter(mots[0]);
                    }else{
                        gui.erreur();
                    }
                }
            }
        }
    }
    public static void ajouter(String str){
        grille[Character.getNumericValue(str.charAt(0))-1][Character.getNumericValue(str.charAt(1))-1]=Character.getNumericValue(str.charAt(2));
    }
    public static boolean validationCoup(String coup){
        boolean flag = true;
        int row = Character.getNumericValue(coup.charAt(0))-1;
        int col = Character.getNumericValue(coup.charAt(1))-1;
        int val = Character.getNumericValue(coup.charAt(2));
        int i = 0;
        while(i<9){
            if(grille[row][i]==val){
                return false;
            }
            if(grille[i][col]==val){
                return false;
            }
            i++;
        }

        int rowD = (int)Math.floor(row/3)*3;
        int colD = (int)Math.floor(col/3)*3;
        for(int j=0; j<9 && flag==true;j++){
            if(grille[rowD][colD] == val){
                return false;
            }
            colD++;
            if (colD%3 == 0){
                colD = colD - 3;
                rowD++;
            }
        }    
        return flag;    
   }
}
