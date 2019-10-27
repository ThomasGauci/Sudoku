package gauci.sudoku.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * @author Thomas Gauci
 */
public class Io 
{
  /**
   * @author Thomas Gauci
   * @return une grille lu dans les ressources du jeu
   */
    public static int[][] lire()
    {
      int grille[][] = new int[9][9];
      try{
        InputStream file = Io.class.getResourceAsStream("/grille1.txt");
        BufferedReader buff=new BufferedReader(new InputStreamReader(file));
        int nb;
        int col = 0;
        int row  = 0;
        while ((nb=buff.read())!=-1){
          if(Character.isDigit(nb) || (char)nb =='_'){
            if(col == 9){
              row++;
              col = 0;
            }
          if((char)nb =='_'){
            grille[row][col]=0;
          }else{
            char tmp = (char)nb;
            grille[row][col]=Character.getNumericValue(tmp);
          }
          col++;
          }
        }
        buff.close(); 
      }		
      catch (Exception e){
        System.out.println(e.toString());
      }
      return grille;
    }
  /**
   * @author Thomas Gauci
   * @param path le chemin absolu de la grille
   * @return une grille donné par le joueur
   */
    public static int[][] lire(String path)
    {
      int grille[][] = new int[9][9];
      try{
        FileReader file =  new FileReader(path);
        int nb;
        int col = 0;
        int row  = 0;
        while ((nb=file.read())!=-1){
          if(Character.isDigit(nb) || (char)nb =='_'){
            if(col == 9){
              row++;
              col = 0;
            }
          if((char)nb =='_'){
            grille[row][col]=0;
          }else{
            char tmp = (char)nb;
            grille[row][col]=Character.getNumericValue(tmp);
          }
          col++;
          }
        }
        file.close(); 
      }		
      catch (Exception e){
        System.out.println(e.toString());
      }
      return grille;
    }
  /**
   * @author Thomas Gauci
   * @param name le nom de la grille
   * @param grille la grille en cours de jeu
   */
    public static void ecrire(String name,int grille[][])
    {
      String content ="";
      for(int i = 0; i<9; i++){
        for(int j = 0; j<9; j++){
          if(grille[i][j]==0){
            content += "_";
          }else{
            content += String.valueOf(grille[i][j]);
          }
          if(j==8){
            content +="\n";
          }
        }
      }
      try (FileWriter writer = new FileWriter(name+".txt");
		  BufferedWriter bw = new BufferedWriter(writer)) {
        bw.write(content);
      } catch (IOException e) {
		    System.err.format("IOException: %s%n", e);
	    }
    }
}
