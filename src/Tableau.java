package Demineur;

import java.io.IOException;
import java.text.NumberFormat;

public class Tableau {
	public String[][] GestionTab(int ligne, int colonne, String grilleCachee[][], NumberFormat nbre) throws IOException {
		 //Créer des caches dans le tableau
		   for (int i = 0 ; i < ligne ; i++)
		       {
		       for (int j = 0 ; j < colonne ; j++)
		           {
		               grilleCachee[i][j] = "\03" ;
		           }    
		       }
		   //Créer les numéros des cases autour du tableau
		   for (int i = 0 ; i < ligne ; i++) 
		       {
		       grilleCachee[i][0] = nbre.format(i) + "";
		       grilleCachee[i][colonne-1] = nbre.format(i) + "" ;
		       
		       for (int j = 0 ; j < colonne ; j++)
		           {
		           grilleCachee[0][j] = nbre.format(j) + "" ;
		           grilleCachee[ligne-1][j] = nbre.format(j) + "" ;
		           }
		       }
		   //Remplace les 00 par des doubles espaces
		   grilleCachee[ligne-1][0] = "  " ;
		   grilleCachee[0][0] = "  " ;            
		   grilleCachee[0][colonne-1] = "  " ;    
		   grilleCachee[ligne-1][colonne-1] = "  " ;
		   
		   return grilleCachee;
	}
}
