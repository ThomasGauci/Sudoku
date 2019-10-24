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
 * Hello world!
 * clear && mvn install && cd Main && mvn exec:java && cd ..
 */

 // Affichage de la grille
 // Récupération des données (123- back)
 // Gestion de l'écriture de commande ?
public class Gui 
{
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

    public static final String[] recupClavier(){
        System.out.print( "\n" );
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        // mots[0] = exit / help / save / load / 123
        String mots[] = str.split(" ");
        if(mots[0].equals("help")){
            System.out.print( "Pour saisir le chiffre 2 sur la ligne 1 colonne 5  tapez : 152  \n" );
            System.out.print( "Chiffres, lignes et colonnes : 1 à 9 \n " );
            System.out.print( "Pour sauvegarder une grille : save nomdelagrille \n " );
            System.out.print( "Pour charger une grille : load /Desktop/grille.txt \n " );
            return recupClavier();
        }
        
        if(mots[0].equals("exit")){
            System.exit(0);
        }
        if(Pattern.matches("[1-9]{3}", mots[0]) || mots[0].equals("load") || mots[0].equals("save")){
            return mots;
        }else{
            return recupClavier();
        }
    }
        
    public static void erreur(){
        System.out.println("Mauvais placement du chiffre");
    }
}
