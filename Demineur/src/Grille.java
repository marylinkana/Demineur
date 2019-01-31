package Demineur;


import java.io.* ;


public class Grille
{    	    
	    
    public void getGrille(int colonne, int ligne, String[][] grilleCachee) throws IOException {
        for (int i = 0 ; i < ligne ; i++)
            {
            for (int j = 0 ; j < colonne ; j++)
                {
                    if(i == ligne-1 && colonne > 0)
                        {
                        System.out.print(grilleCachee[i][j]+ " ") ;    
                        }
                    else if(i > 0 && j > 0 || j == (colonne-1))
                         {
                         System.out.print(grilleCachee[i][j]+ "  ") ;
                         }
                         else 
                         {
                         System.out.print(grilleCachee[i][j]+ " ") ;    
                         }
                }
            System.out.println() ;    
            }

}
    
    
    
}
