package gauci.sudoku.app;

import java.util.Scanner;
import java.lang.*;
import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.Table;
import com.indvd00m.ascii.render.elements.Text;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author Thomas Gauci
 */
public class Gui 
{
    /**
     * @author Thomas Gauci
     * @param grille la grille à afficher
     */
    public static final void afficherGrille(int grille[][]){
        IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(30).height(30);
        Table table = new Table(9,9);

        for(int j=0 ; j<9; j++){
            for(int k=0 ; k<9; k++){
                if(grille[j][k]==0){
                    table.setElement(k+1,j+1, new Text("_"));
                }else{
                    table.setElement(k+1,j+1, new Text(String.valueOf(grille[j][k])));
                }
            } 
        }

        builder.element(table);
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
        System.out.println(s);
    }
    /**
     * @author Thomas Gauci
     * @return ce que le joueur à écrit
     */
    public static final String[] recupClavier(){
        System.out.print( "\n" );
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        // mots[0] = exit / help / save / load / 123 / b
        String mots[] = str.split(" ");
        return mots;
    }
    /**
     * @author Thomas Gauci
     * @param mots contient ce que le joueur à écrit
     * @return true si le joueur a écrit une demande valide sinon false
     */
    public static boolean verifClavier(String mots[]){
        if(Pattern.matches("[1-9]{3}", mots[0]) || mots[0].equals("load") || mots[0].equals("save") || mots[0].equals("exit") || mots[0].equals("help") || mots[0].equals("b")){
            return true;
        }else{
            return false;
        }
    }
    /**
     * @author Thomas Gauci
     */
    public static void help(){
        System.out.print( "Pour saisir le chiffre 2 sur la ligne 1 colonne 5  tapez : 152  \n" );
        System.out.print( "Chiffres, lignes et colonnes : 1 à 9 \n " );
        System.out.print( "Pour sauvegarder une grille : save nomdelagrille \n " );
        System.out.print( "Pour charger une grille : load /Desktop/grille.txt " );
    }
    /**
     * @author Thomas Gauci
     */
    public static void erreur(){
        System.out.println("Mauvais placement du chiffre");
    }
}
