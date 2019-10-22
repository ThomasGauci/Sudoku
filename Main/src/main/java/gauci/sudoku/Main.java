package gauci.sudoku.app;

import gauci.sudoku.app.Gui;
/**
 * Hello world!
 *
 */
// clear && mvn install && cd Main && mvn exec:java && cd ..
public class Main 
{
    private static int grille[][];
    private static int tour;

    public static void main( String[] args ){
        Gui gui = new Gui();
        //Gui io = new Io();
        grille = new int[9][9];
        String str;

        for(int i=0 ; i<6; i++){
            gui.afficherGrille(grille);
            str = gui.recupClavier();
            ajouter(str);
        }
    }
    private static void ajouter(String str){
        grille[Character.getNumericValue(str.charAt(0))-1][Character.getNumericValue(str.charAt(1))-1]=Character.getNumericValue(str.charAt(2));
    }
    private static void initialisationGrille(){
        
   }
}
