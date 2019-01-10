package Game;
import java.util.Scanner;

public class Runner{
	  
	  //Affiche les r�gles au d�but de la partie.
	  public static void init(){
	    System.out.println("Jouez en entrant les coordonn�es d'une case que vous souhaitez s�lectionner.");
	    System.out.println("Les coordonn�es � entrer est 1-10.");
	    System.out.println("Il y a 16 mines.");
	  }
	  
	  public static void test(){  
		FirstTest game = new FirstTest();
	    game.generateMines(16);
	    game.update();
	    Scanner scan = new Scanner(System.in); 
	    
	    int x, y;
	    System.out.print("Entrez une coordonn�e x.");
	    x = scan.nextInt();
	    System.out.print("Entrez une coordonn�e y.");
	    y = scan.nextInt();
	    
	    /* 
	     * Pour que le joueur ne perde pas � son premier coup,
	     * le jeu d�placera une mine sur une autre case si le joueur
	     * arrive � s�lectionner une case avec une mine pr�sente.
	     */ 
	    if(game.getTile(x,y).equals(" * ") == true){
	      game.generateMines(1);
	      game.field[x][y] = " ? ";
	    }
	    
	    game.clear(x,y);
	    game.detect();
	    game.update();
	    
	    //Apr�s le premier coup, boucle jusqu'� la fin du jeu.
	    while(true){
	      if(game.getDone() == true && game.getWin() == true){    //Si le joueur gagne.
	        System.out.println("Vous avez gagn�!");
	        game.onEnd();
	        break;
	      }else if(game.getDone() == true){                       //Si le joueur perd.
	        game.onEnd(); 
	        break;
	      }else if(game.getDone() == false){                      //Tant que le joueur ne gagne ou perd.
	        x = -1;
	        y = -1;     //Resets values.
	        System.out.print("Entrez une coordonn�e x.");
	        y = scan.nextInt();
	        System.out.print("Entrez une coordonn�e y.");
	        x = scan.nextInt();
	        game.turn(x,y);
	        game.isVictory();
	        game.detect();
	        game.update();
	      }
	      
	    }   
	  }
	}