package Demineur;

import java.io.IOException;

public class Fin {
	public int GameOver(int ligneDevoilee, int colonneDevoilee, int grille[][], int stop, int nbMine, int compteur, int ligne, int colonne  ) throws IOException {
		 //Gestion des bombes    
	    
	    System.out.println() ;
	        //Si vous trouvez un 9, c'est perdu
	        if (grille[(ligneDevoilee+1)][(colonneDevoilee+1)] == 9)
	            {
	            stop = 1 ;
	            for (int i = 0 ; i < 25 ; i++)
	                {
	                System.out.println("BBBBBBBBBBBBOOOOOOOOOOOOOOOOOOOOOOOOOOOOMMMMMMMMMMMMMMMMM");    
	                }
	            }

	      //Une fois qu'il ne reste plus de cases à découvrire, le jeu s'arrête    
	        if (compteur == ((ligne-2)*(colonne-2)-nbMine) && stop != 1)
	            {
	            stop = 1 ;
	            System.out.println("\nEt");
	            System.out.println("C'est") ;
	            System.out.println("GAGNE") ;
	            }
	        return stop;
	}

}
