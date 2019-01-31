package Demineur;

import java.io.IOException;

public class Mines {
	
	//Par rapport aux nombres de Mines, l'ordi les places alléatoirement dans la grille
    public int[][] positionRandomMine(int randColonne, int randLigne, String grilleCachee[][], int grille[][], int ligne, int colonne, int nbMine) throws IOException {
	    for (int i = 0 ; i < nbMine ; i++)
	        {
	            randLigne = (int)(Math.random() * (ligne - 2) + 1) ;
	            randColonne = (int)(Math.random() * (colonne - 2) + 1) ;
	            
	            if(grille[randLigne][randColonne] != 9)
	                {
	                grille[randLigne][randColonne] = 9 ;    
	                }
	            else
	                {
	                i = i - 1 ;    
	                }
	        }
	    return grille;
	    }
    
    //Place des numéros qui indiquent le nombre de mines à proximité
    public int[][] indicMines(int ligne, int colonne, int grille[][]) throws IOException {
	    for (int i = 0 ; i < ligne ; i++)
	        {
	        for (int j = 0 ; j < colonne ; j++)
	            {
	            if (grille[i][j] == 9)
	                {
	                for (int k = (i-1) ; k < (i+2) ; k++) 
	                    {
	                    for (int l = (j-1) ; l < (j+2) ; l++) 
	                        {
	                        if (grille[k][l] != 9)
	                            {
	                            grille[k][l] = grille[k][l] + 1 ;    
	                            }    
	                        }
	                    }    
	                }
	                
	            }    
	        }
	    return grille;
    }
    
}

