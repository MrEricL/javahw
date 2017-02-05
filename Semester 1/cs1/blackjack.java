import cs1.Keyboard;
package cs1;
public class blackjack {
    public String[] deck= new String[312];
    public String[] faceup= new String[6];
    public String[] facedown=new String[6];
    public String[] player = new String [11];
    public blackjack(){
	int x=2;
	int y=0;
	
	while (x < 11){
	    for (int i=0; i < 24; i++) deck[y+i]=""+x;
	    x+=1;
	    y+=24;
	}
	while (x<15){
	    if (x==11){
		for (int i=0; i < 24; i++) deck[y+i]="JACK";
	    }
	    if (x==12){
		for (int i=0; i < 24; i++) deck[y+i]="QUEEN";
	    }
	    if (x==13){
		for (int i=0; i < 24; i++) deck[y+i]="KING";
	    }	    

	    if (x==14){
		for (int i=0; i < 24; i++) deck[y+i]="ACE";
	    }
	    x+=1;
	    y+=24;
	}
	//	bj();
	deal();
	play();
    }

    public void bj(String[] x){
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
       
    }

    public void play(){
	int cards=2;
	System.out.println("Your face up card is " + faceup[0]);
	for (int i=1; i < 6; i++){
	    System.out.println("The other player's card is " + faceup[i]);
	}
	while (true){
	    System.out.println("\nDo you want to me hit?\n(y/n)");
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
	blackjack play = new blackjack();
    }


}
