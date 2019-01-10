package Game;

public class FirstTest{
	  public String[][] field = new String[12][12];   //12 lignes, 12 colonnes.
	  public String[][] display = new String[12][12]; //C'est le champ qui est visible pour le joueur
	  public Boolean isDone = false;
	  public Boolean isWin = false;
	  
	  private String unknown = " ? ";
	  private String mine = " * ";
	  private String empty = "   ";
	  
	  //Le constructeur place des espaces vides dans les cases.
	  public FirstTest(){
	    int row = 0;
	    int column = 0;
	    
	    for(int x = 0; x < field.length; x++){
	      for(int y = 0; y < field[0].length; y++){
	        //Placer des espaces vides dans les zones tampons.
	        if((x == 0 || x == field.length - 1)||(y == 0 || y == field[0].length - 1)){
	          field[x][y] = empty;
	          display[x][y] = empty;
	        }
	        //Placer ? dans le champ de jeu.
	        else{
	          field[x][y] = unknown;
	          display[x][y] = unknown;
	        }
	      }
	    }
	  }
	  
	  //Afficher le champ.
	  public static void printGame(String[][] str){
	    for(int x = 1; x < str.length - 1; x++){   
	      for(int y = 0; y < str[0].length ; y++){
	        //Ligne de formats.
	        if(y > 0 && y < str[0].length)
	          System.out.print("|");
	        else
	          System.out.println("");
	        
	        System.out.print(str[x][y]);  //G�n�re le contenu de chaque case.
	      }
	    }
	  }
	  
	  //Met � jour la console apr�s chaque match.
	  public void update(){
	    printGame(display);
	    System.out.println("");
	  }
	  
	  //Place n mines au hasard sur le terrain.
	  public void generateMines(int n){
	    for(int m = 0; m < n; m++){
	      //Boucler jusqu'� ce qu'une mine soit plac�e.
	      while(true){
	        int x, y = 0;   //Initialiser variables
	        x = (int)(10*Math.random());
	        y = (int)(10*Math.random());
	        
	        //Pour qu'une mine soit plac�e dans une case visible par le joueur.
	        if(x >= 1 && x <= 10){
	          if(y >= 1 && y <= 10){
	            //V�rifie si une mine est pr�sente � un endroit.
	            if(!field[x][y].equals(mine)){
	              field[x][y] = mine;
	              break;
	            }
	          }
	        }
	      }
	    }
	  }
	  
	  //Au premier d�placement, cela efface la zone autour de la case s�lectionn�e.
	  public void clear(int x, int y){  
	    for(int i = (x - 1); i <= (x + 1); i++){
	      for(int j = (y - 1); j <= (y + 1); j++){
	        if(field[i][j].equals(unknown) == true){
	          display[i][j] = empty;
	          field[i][j] = empty;
	        }
	      }
	    }
	  }
	  
	  //Obtient la valeur d'une case.
	  public String getTile(int x, int y){
	    return field[x][y];
	  }
	  
	  //D�tecte le nombre de mines autour d'une case s�lectionn�e.
	  public void detect(){
	    for(int x = 1; x < display.length - 2; x++){     //Parcourt l�ensemble de l��cran visible.
	      for(int y = 1; y < display.length - 2; y++){
	        if(field[x][y].equals(empty) == true){
	          int nums = 0;                              //Variable pour compter les mines.
	          for(int i = (x - 1); i <= (x + 1); i++){
	            for(int j = (y - 1); j <= (y + 1); j++){
	              if(field[i][j].equals(mine) == true)
	                nums++;                              //Incrementer nums quand une mine est d�tect�e.
	            }
	          }
	          display[x][y] = " " + nums + " ";
	        }
	      }
	    }
	  }
	  
	  //Prend les coordonn�es s�lectionn�es par l'utilisateur et ajuste le tableau.
	  public void turn(int x, int y){
	    if(field[x][y].equals(unknown) == true){           //Si le spot n'a pas �t� s�lectionn�, il est effac�
	      isDone = false;
	      display[x][y] = empty;
	      field[x][y] = empty;
	    }else if(field[x][y].equals(mine) == true){        //Si l'utilisateur s�lectionne une mine.
	      isDone = true;                                   //Jeu fini.
	      isWin = false;                                   //Joeur ne gagne pas.
	      System.out.println("Vous avez perdu!");
	    }else if(display[x][y].equals(empty) == true && field[x][y].equals(empty)){
	      isDone = false;
	      System.out.println("Cette case a �t� d�barras�e!");
	    }
	  }
	  
	  //D�termine si le joueur a trouv� tous les cases sans mines.
	  public void isVictory(){
	    int tile = 0;                                      //Var pour le nombre de cases non d�barras�es dans le tableau
	    for(int i = 0; i < field.length; i++){
	      for(int j = 0; j < field[0].length; j++){
	        if(field[i][j].equals(unknown) == true)
	          tile++;                                      //S'il y a des cases non d�barras�es, tile est incr�ment�.
	      }
	    }
	    if(tile != 0)
	      isWin = false;  // S'il y a encore des cases non d�barras�es, le joueur ne gagne pas.
	    else{
	      isWin = true;
	      isDone = true;
	    }
	  }
	  
	  //D�termine si le jeu est termin�.
	  public Boolean getDone(){
	    return isDone;
	  }
	  
	  //D�termine si un joueur a gagn�.
	  public Boolean getWin(){
	    return isWin;
	  }
	  
	  //Affiche l'emplacement des mines � la fin du jeu.
	  public void onEnd(){
	    printGame(field);
	  }
	  
	}