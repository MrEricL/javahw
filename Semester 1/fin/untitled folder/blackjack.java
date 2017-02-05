
import cs1.Keyboard;

public class blackjack {
    public String[] deck= new String[312];
    // the bots
    public String[] jack= new String[11];
    public String[] lois= new String[11];
    public String[] will= new String[11];
    public String[] robin= new String[11];
    public String[] emily= new String [11];
    //the player	
    public String[] player = new String [11];
    //background stuff
    public int difficulty;
    public double  money;
    public double bet;

    public void play(){
	
	start();
	deal();
	go();
	bj(deck);
	//	win();
    }

    public blackjack(int x, double  y){
	difficulty=x;
	money=y;
    }

    public  void bet(){
    }
    //♥♣♦♠
    public  void start(){
	int x=2;
	int y=0;
	
	while (x < 11){
	    for (int i=0; i < 24; i++){
		    if (i%4.0 == 0) deck[y+i]=""+x+"♦";
		    if (i%4.0==1) deck[y+i]=""+x+"♣";
		    if (i%4.0==2) deck[y+i]=""+x+"♥";
		    if (i%4.0==3) deck[y+i]=""+x+"♠";
	    }
	    x+=1;
	    y+=24;
	}
	while (x<15){
	    if (x==11){
		for (int i=0; i < 24; i++){
		    if (i%4.0 == 0) deck[y+i]="JACK♦";
		    if (i%4.0==1) deck[y+i]="JACK♣";
		    if (i%4.0==2) deck[y+i]="JACK♥";
		    if (i%4.0==3) deck[y+i]="JACK♠";
		}	
	    }
	    if (x==12){
		for (int i=0; i < 24; i++){
		    if (i%4.0 == 0) deck[y+i]="QUEEN♦";
		    if (i%4.0==1) deck[y+i]="QUEEN♣";
		    if (i%4.0==2) deck[y+i]="QUEEN♥";
		    if (i%4.0==3) deck[y+i]="QUEEN♠";
		}
	    }
	    if (x==13){
		for (int i=0; i < 24; i++){
		    if (i%4.0 == 0) deck[y+i]="KING♦";
		    if (i%4.0==1) deck[y+i]="KING♣";
		    if (i%4.0==2) deck[y+i]="KING♥";
		    if (i%4.0==3) deck[y+i]="KING♠";
		}
	    }	    

	    if (x==14){
		for (int i=0; i < 24; i++){
		    if (i%4.0 == 0) deck[y+i]="ACE♦";
		    if (i%4.0==1) deck[y+i]="ACE♣";
		    if (i%4.0==2) deck[y+i]="ACE♥";
		    if (i%4.0==3) deck[y+i]="ACE♠";
		}
	    }
	    x+=1;
	    y+=24;
	}
	//	bj();
    }
    //bj is the to string method
    public  void bj(String[] x){
	for (int i=0; i<x.length;i++){
	    if (!x[i].equals("0")) System.out.println (x[i]);
	}
    }
    public void deal(){
	for (int i=0; i <6; i++){
	    
	    int x= (int)(Math.random()*312-1);
	    while (deck[x]=="0"){
		x=(int)(Math.random()*312-1);
	    }
	    faceup[i]=deck[x];	   
	    deck[x]=""+0;
	}
	for (int i=0; i <6; i++){
	    
	    int x= (int)(Math.random()*312-1);
	    while (deck[x]=="0"){
		x=(int)(Math.random()*312-1);
	    }
	    facedown[i]=deck[x];	   
	    deck[x]=""+0;
	}	
	for (int i = 0; i<11; i++) player[i]="0";
	player[0]=faceup[0];
	player[1]=facedown[0];
	System.out.println("\n\n~~~ YOU ARE NOW PLAYING BLACKJACK ~~~\n");
	System.out.println("Your face up card is " + faceup[0]);
	for (int i=1; i < 6; i++){
	    System.out.println("The other player's card is " + faceup[i]);
	}	
       
    }

    public  void go(){
	int cards=2;

	while (true){
	    System.out.println("\nDo you want to hit?\n(y/n)");
	    try{
		String word= Keyboard.readWord();
		if (word.equals("y")){
		    int x= (int)(Math.random()*312-1);
		    while (deck[x]=="0"){
			x=(int)(Math.random()*312-1);
		    }
		    player[cards]=deck[x];
		    deck[x]=""+0;		    
		    cards++;
		}
		else{
		    System.out.println("\n\n\n");
		    bj(player);
		    return;
		}
	    }
	    catch (Exception e) {
		play();
		
		return;		
	    }			   

	}
    }
    
    public static void main (String[] args){
	
    }


}
