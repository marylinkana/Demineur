package demineur;

import java.io.* ;
import java.text.* ;


public class Main
{
	public static void main(String [] args) throws IOException
		{
		NumberFormat nbre = NumberFormat.getNumberInstance() ;
		nbre.setMinimumIntegerDigits(2) ;
		
		Grille Fonction = new Grille() ;
		
		
		int compteur = 0 ;
		int stop = 0 ;
		int ligne = 0  ;
		int colonne = 0 ;
		int nbMine = 0 ;
		int ligneDevoilee = 0 ;
		int colonneDevoilee = 0 ;
		boolean erreur = false ;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;

		System.out.println("========") ;
		System.out.println("Demineur") ;
		System.out.println("========\n\n\n") ;
				
		//Demande à l'utilisateur d'entrer le nombre de ligne
		do
			{
			try
				{
				System.out.println("Entrez un nombre de lignes") ;
				ligne = Integer.parseInt(in.readLine()) + 2 ;
				}
			catch (NumberFormatException e)
				{
				System.out.println("\nVeuillez entrer un entier pour le nombre de lignes\n");
				erreur = true ;	
				}			
			}
		while(erreur != false && ligne < 5) ;
		
		
		erreur = false ;
		
		//Demande à l'utilisateur d'entrer le nombre de colonnes
		do
			{
			try
				{			
				System.out.println("\nEntrez un nombre de colonnes") ;
				colonne = Integer.parseInt(in.readLine()) + 2;			
				}
			catch (NumberFormatException e)
				{
				System.out.println("\nVeuillez entrer un entier pour le nombre de lignes\n");
				erreur = true ;	
				}
			}
		while(erreur != false && colonne < 5) ;
		
		erreur = false ;
		
		//Demande à l'utilisateur le nombre de mines à découvrire
		do
			{
			try
				{
				System.out.println("\nEntrez un nombre de mines a decouvrire") ;
				nbMine = Integer.parseInt(in.readLine()) ;
				}
			catch (NumberFormatException e)
				{
				System.out.println("\nVeuillez entrer un entier pour le nombre de mines a decouvrire\n");
				erreur = true ;	
				}				
			}
		while (erreur != false && (nbMine < 1 || nbMine > ((ligne-3)*(colonne-3)))) ;
		
		erreur = false ;
		
	
		//Initialise la grille avec le tour en plus, 2 lignes et 2 colonnes	
		int grille[][] = new int[ligne][colonne] ;
		String grilleCachee[][] = new String[ligne][colonne] ;
		

		int randLigne = 0 ;
		int randColonne = 0 ;
		
		
		//Par rapport aux nombres de Mines, l'ordi les places alléatoirement dans la grille
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
			
		//Place des numéros qui indiquent le nombre de mines à proximité
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
		/***************************************
		 Créer un tableau en 2d rempli d'étoile
		***************************************/
		
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
		
		
		/***********************************	
		 Affiche le tableau avec les coeurs
		***********************************/
		
		Fonction.Grille(colonne, ligne, grilleCachee) ;		
		
		/************************
		 Entrée de l'utilisateur
		************************/
			
		do
		{
			//Entree de l'utilisateur de la ligne à dévoiler
			
			do
				{
				System.out.println("\nEntrer le numero de ligne que vous souhaitez devoiler") ;
				ligneDevoilee = Integer.parseInt(in.readLine()) - 1;
				}
			while(ligneDevoilee < 0 || ligneDevoilee > (ligne-3)) ;
			
			
			//Entree de l'utilisateur de la colonne à dévoiler
			do
				{
				System.out.println("\nEntrer le numero de colonne que vous souhaitez devoiler") ;
				colonneDevoilee = Integer.parseInt(in.readLine()) - 1 ;
				}
			while(colonneDevoilee < 0 || colonneDevoilee > (colonne-3)) ;


			if (grilleCachee[(ligneDevoilee+1)][(colonneDevoilee+1)] == "\03")
				{	
				compteur = compteur + 1 ;
				}			
			
			if (grille[(ligneDevoilee+1)][(colonneDevoilee+1)] == 9)
				{
				grilleCachee[(ligneDevoilee+1)][(colonneDevoilee+1)] = "*" ;		
				}
			else if (grille[(ligneDevoilee+1)][(colonneDevoilee+1)] == 0)
					{
					grilleCachee[(ligneDevoilee+1)][(colonneDevoilee+1)] = " " ;		
					}
				else
					{	
					grilleCachee[(ligneDevoilee+1)][(colonneDevoilee+1)] = grille[(ligneDevoilee+1)][(colonneDevoilee+1)] + "" ;	
					}
	
		/***********************************	
		 Affiche le tableau avec les entées
		***********************************/
		
		Fonction.Grille(colonne, ligne, grilleCachee) ;				
			
			
		/*******************
		 Gestion des bombes	
		*******************/
		
		System.out.println() ;
			//Si vous trouvez un 9, c'est perdu
			if (grille[(ligneDevoilee+1)][(colonneDevoilee+1)] == 9)
				{
				stop = 1 ;
				for (int i = 0 ; i < 25 ; i++)
					{
					System.out.println("Game Over \n Game Over \n Game Over \n Game Over \n Game Over \n Game Over \n");	
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

		}
		while(stop !=1) ;
		
		System.out.println() ;
		Fonction.Grille(colonne, ligne, grilleCachee) ;	
			
		System.out.println("\nMerci d'avoir joue\n") ;	
		}
	}

class Grille
{	
	public void Grille(int colonne, int ligne, String [][] grilleCachee) throws IOException
	{
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