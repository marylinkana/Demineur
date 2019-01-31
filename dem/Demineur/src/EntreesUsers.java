package Demineur;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.Integer;

public class EntreesUsers {
	public int ligne(boolean erreur, BufferedReader in, int ligne) throws IOException {
		//Demande à l'utilisateur d'entrer le nombre de ligne
	    do
	        {
	        try
	            {
	            System.out.println("Entrez un nombre de ligne") ;
	            ligne = Integer.parseInt(in.readLine()) + 2 ;
	            }
	        catch (NumberFormatException e)
	            {
	            System.out.println("\nVeuillez entrer un entier pour le nombre de ligne\n");
	            erreur = true ;    
	            }            
	        }
	    while(erreur != false && ligne < 5) ;
	    erreur = false ;
	    
	    return ligne;
	}
	public int colonne(boolean erreur, BufferedReader in, int ligne, int colonne ) throws IOException {
		//Demande à l'utilisateur d'entrer le nombre de colonnes
	    do
	        {
	        try
	            {            
	            System.out.println("\nEntrez un nombre de colonne") ;
	            colonne = Integer.parseInt(in.readLine()) + 2;            
	            }
	        catch (NumberFormatException e)
	            {
	            System.out.println("\nVeuillez entrer un entier pour le nombre de colonne\n");
	            erreur = true ;    
	            }
	        }
	    while(erreur != false && colonne < 5) ;
	    erreur = false ;
	    
	    return colonne;
	}
	
	  
	public int nbMine(int nbMine, boolean erreur, BufferedReader in, int ligne, int colonne ) throws IOException {
		//Demande à l'utilisateur le nombre de mines à découvrire
	    do
	        {
	        try
	            {
	            System.out.println("\nEntrez un nombre de mines à decouvrir") ;
	            nbMine = Integer.parseInt(in.readLine()) ;
	            }
	        catch (NumberFormatException e)
	            {
	            System.out.println("\nVeuillez entrer un entier pour le nombre de mines à decouvrir\n");
	            erreur = true ;    
	            }                
	        }
	    while (erreur != false && (nbMine < 1 || nbMine > ((ligne-3)*(colonne-3)))) ;
	    erreur = false ;
	    
	    return nbMine;
	}
	
	
	public void GestionJeux(BufferedReader in, int ligneDevoilee, int colonneDevoilee,String grilleCachee[][], int grille[][], int stop,int nbMine,int compteur,int ligne,int colonne ) throws IOException {
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
	}
}

	
	

