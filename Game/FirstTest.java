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
	        
	        System.out.print(str[x][y]);  //Génère le contenu de chaque case.
	      }
	    }
	  }
	  
	  //Met à jour la console après chaque match.
	  public void update(){
	    printGame(display);
	    System.out.println("");
	  }
	  
	  //Place n mines au hasard sur le terrain.
	  public void generateMines(int n){
	    for(int m = 0; m < n; m++){
	      //Boucler jusqu'à ce qu'une mine soit placée.
	      while(true){
	        int x, y = 0;   //Initialiser variables
	        x = (int)(10*Math.random());
	        y = (int)(10*Math.random());
	        
	        //Pour qu'une mine soit placée dans une case visible par le joueur.
	        if(x >= 1 && x <= 10){
	          if(y >= 1 && y <= 10){
	            //Vérifie si une mine est présente à un endroit.
	            if(!field[x][y].equals(mine)){
	              field[x][y] = mine;
	              break;
	            }
	          }
	        }
	      }
	    }
	  }
	  
	  //Au premier déplacement, cela efface la zone autour de la case sélectionnée.
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
	  
	  //Détecte le nombre de mines autour d'une case sélectionnée.
	  public void detect(){
	    for(int x = 1; x < display.length - 2; x++){     //Parcourt l’ensemble de l’écran visible.
	      for(int y = 1; y < display.length - 2; y++){
	        if(field[x][y].equals(empty) == true){
	          int nums = 0;                              //Variable pour compter les mines.
	          for(int i = (x - 1); i <= (x + 1); i++){
	            for(int j = (y - 1); j <= (y + 1); j++){
	              if(field[i][j].equals(mine) == true)
	                nums++;                              //Incrementer nums quand une mine est détectée.
	            }
	          }
	          display[x][y] = " " + nums + " ";
	        }
	      }
	    }
	  }
	  
	  //Prend les coordonnées sélectionnées par l'utilisateur et ajuste le tableau.
	  public void turn(int x, int y){
	    if(field[x][y].equals(unknown) == true){           //Si le spot n'a pas été sélectionné, il est effacé
	      isDone = false;
	      display[x][y] = empty;
	      field[x][y] = empty;
	    }else if(field[x][y].equals(mine) == true){        //Si l'utilisateur sélectionne une mine.
	      isDone = true;                                   //Jeu fini.
	      isWin = false;                                   //Joeur ne gagne pas.
	      System.out.println("Vous avez perdu!");
	    }else if(display[x][y].equals(empty) == true && field[x][y].equals(empty)){
	      isDone = false;
	      System.out.println("Cette case a été débarrasée!");
	    }
	  }
	  
	  //Détermine si le joueur a trouvé tous les cases sans mines.
	  public void isVictory(){
	    int tile = 0;                                      //Var pour le nombre de cases non débarrasées dans le tableau
	    for(int i = 0; i < field.length; i++){
	      for(int j = 0; j < field[0].length; j++){
	        if(field[i][j].equals(unknown) == true)
	          tile++;                                      //S'il y a des cases non débarrasées, tile est incrémenté.
	      }
	    }
	    if(tile != 0)
	      isWin = false;  // S'il y a encore des cases non débarrasées, le joueur ne gagne pas.
	    else{
	      isWin = true;
	      isDone = true;
	    }
	  }
	  
	  //Détermine si le jeu est terminé.
	  public Boolean getDone(){
	    return isDone;
	  }
	  
	  //Détermine si un joueur a gagné.
	  public Boolean getWin(){
	    return isWin;
	  }
	  
	  //Affiche l'emplacement des mines à la fin du jeu.
	  public void onEnd(){
	    printGame(field);
	  }
	  
	}