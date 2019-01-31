package Demineur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;

public class Jeux {

	public Jeux() throws IOException {
		NumberFormat nbre = NumberFormat.getNumberInstance() ;
	    nbre.setMinimumIntegerDigits(2) ;
	    
	    Grille FonctionGrille = new Grille() ;
	    Mines FonctionMines = new Mines();
	    EntreesUsers FonctionEU = new EntreesUsers();
	    Tableau FonctionTableau = new Tableau();
	    Fin FonctionFin = new Fin();
	    
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
	  
	    
	    // Entrés Utilisateur
	    ligne = FonctionEU.ligne(erreur, in, ligne );
	    colonne = FonctionEU.colonne(erreur, in, ligne, colonne );
	    nbMine = FonctionEU.nbMine(nbMine, erreur, in, ligne, colonne );

	    //Initialise la grille avec le tour en plus, 2 lignes et 2 colonnes   
	    int grille[][] = new int[ligne][colonne] ;
	    String grilleCachee[][] = new String[ligne][colonne] ;
		int randLigne = 0 ;
	    int randColonne = 0 ;
	    
		//Par rapport aux nombres de Mines, l'ordi les places alléatoirement dans la grille
	    grille = FonctionMines.positionRandomMine(randColonne,randLigne, grilleCachee, grille, ligne, colonne, nbMine);
	    
	    //Place des numéros qui indiquent le nombre de mines à proximité
	    grille = FonctionMines.indicMines(ligne, colonne, grille);

	   
	    //Créer des caches dans le tableau, Créer les numéros des cases autour du tableau, Remplace les 00 par des doubles espaces    
	    grilleCachee = FonctionTableau.GestionTab(ligne, colonne, grilleCachee, nbre);
	    
	    //Affiche le tableau
	    FonctionGrille.getGrille(colonne, ligne, grilleCachee) ;    
	   
	    
	    //Entrée de l'utilisateur
	        
	    do
	    {
	    	FonctionEU.GestionJeux(in, ligneDevoilee, colonneDevoilee, grilleCachee, grille, stop, nbMine, compteur, ligne, colonne );


	     //Affiche le tableau avec les entées
	    FonctionGrille.getGrille(colonne, ligne, grilleCachee) ;                
	        
	        
	     //Gestion des bombes et arret de jeux
	    stop = FonctionFin.GameOver(ligneDevoilee, colonneDevoilee, grille, stop, nbMine, compteur, ligne, colonne);
	 

	    }
	    while(stop !=1) ;
	    System.out.println() ;
	    
	    FonctionGrille.getGrille(colonne, ligne, grilleCachee) ;    
	        
	    System.out.println("\nMerci d'avoir joue\n") ;    
	    }
}
