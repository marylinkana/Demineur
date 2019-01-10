package Game;
import java.util.Scanner;

public class Runner{
	  
	  //Affiche les règles au début de la partie.
	  public static void init(){
	    System.out.println("Jouez en entrant les coordonnées d'une case que vous souhaitez sélectionner.");
	    System.out.println("Les coordonnées à entrer est 1-10.");
	    System.out.println("Il y a 16 mines.");
	  }
	  
	  public static void test(){  
		FirstTest game = new FirstTest();
	    game.generateMines(16);
	    game.update();
	    Scanner scan = new Scanner(System.in); 
	    
	    int x, y;
	    System.out.print("Entrez une coordonnée x.");
	    x = scan.nextInt();
	    System.out.print("Entrez une coordonnée y.");
	    y = scan.nextInt();
	    
	    /* 
	     * Pour que le joueur ne perde pas à son premier coup,
	     * le jeu déplacera une mine sur une autre case si le joueur
	     * arrive à sélectionner une case avec une mine présente.
	     */ 
	    if(game.getTile(x,y).equals(" * ") == true){
	      game.generateMines(1);
	      game.field[x][y] = " ? ";
	    }
	    
	    game.clear(x,y);
	    game.detect();
	    game.update();
	    
	    //Après le premier coup, boucle jusqu'à la fin du jeu.
	    while(true){
	      if(game.getDone() == true && game.getWin() == true){    //Si le joueur gagne.
	        System.out.println("Vous avez gagné!");
	        game.onEnd();
	        break;
	      }else if(game.getDone() == true){                       //Si le joueur perd.
	        game.onEnd(); 
	        break;
	      }else if(game.getDone() == false){                      //Tant que le joueur ne gagne ou perd.
	        x = -1;
	        y = -1;     //Resets values.
	        System.out.print("Entrez une coordonnée x.");
	        y = scan.nextInt();
	        System.out.print("Entrez une coordonnée y.");
	        x = scan.nextInt();
	        game.turn(x,y);
	        game.isVictory();
	        game.detect();
	        game.update();
	      }
	      
	    }   
	  }
	}