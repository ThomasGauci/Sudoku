package gauci.sudoku.app;

import java.util.Scanner;
import java.lang.*;
import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.Table;
import com.indvd00m.ascii.render.elements.Text;

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

    public static final String recupClavier(){
        System.out.print( "\n" );
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str.equals("help")){
            System.out.print( "Pour saisir le chiffre 2 sur la ligne 1 colonne 5  tapez : 152  \n" );
            System.out.print( "Chiffres, lignes et colonnes : 1 à 9 \n " );
            return recupClavier();
        }
        
        if(str.equals("exit")){
            System.exit(0);
        }
        //else if(str = [1-9]{3})
        return str;
    }

}
