
package barsees;

import java.util.List;
import java.util.Scanner;

public class Barsees {
     State s = new State();
    public void playGame() {
        s.print();
        boolean m ;
        while (true) {
            while (true){
            System.out.println("************USER************");
            m =  getUserMove();  
            s.print();
            if (!m)
                break;
            }
            if (s.how_Win()) {
                 System.out.println(" User Wins");
                break;
            } 
            
            else {
                boolean mm= true;
            System.out.println("************Computer************");
            mm = getComputerMove();
            s.print();
            if (s.how_Win()) {
                System.out.println("Computer Wins");
                break;
            }
        }
    }}
     private boolean getUserMove() {
        Scanner ss = new Scanner(System.in);
        int stone;
        nard n = new nard();
        n= n.s();   
        char on='n';       
            if(n.khal&&(!s.player_1.get(0).on_Board ||!s.player_1.get(1).on_Board ||!s.player_1.get(2).on_Board ||!s.player_1.get(3).on_Board)){
                System.out.println("Enter o if you want to add new Stonr to board or enter n if you want to move your stone");
                while (true){
               on = ss.next().charAt(0);
               if(on =='o'||on =='n'){
               break;
               }
            }
            
            if(on=='o'){
            while (true) {
             System.out.print("Enter number of Stone: ");
            stone = ss.nextInt();
            System.out.println();
            if (!s.player_1.get(stone-1).on_Board&& (stone > 0) && (stone < 5)) {
                break;
            }
            else {
                System.out.println("some things is rong try again");
            }
            }
            s.player_1.get(stone-1).on_Board=true;
            s.print();
          
            }
            else{  
                while (true) {
                    System.out.print("Enter number of Stone: ");
                    stone = ss.nextInt();
                    System.out.println();
                if ((stone > 0) && (stone < 5)&& s.player_1.get(stone-1).on_Board) {
                     break;
            }
      
        }
                System.out.println(n.moving);
                if (s.player_1.get(stone-1).x+n.moving+1<85){
                s.player_1.get(stone-1).x= s.player_1.get(stone-1).x+n.moving+1;
                s.print();
        }
                else {
                s.player_1.get(stone-1).x=1;
                s.player_1.get(stone-1).on_Board= false;
                }}
          return true; 
            }
             if ((n.moving==6 || n.moving==12)&&(s.player_1.get(0).on_Board||s.player_1.get(1).on_Board||s.player_1.get(2).on_Board||s.player_1.get(3).on_Board))
            {
                 while (true) {
                    System.out.print("Enter number of Stone: ");
                    stone = ss.nextInt();
                    System.out.println();
                if ((stone > 0) && (stone < 5)&& s.player_1.get(stone-1).on_Board) {
                     break;
            }  
        }
                System.out.println(n.moving);
                    if (s.player_1.get(stone-1).x+n.moving<85){
                s.player_1.get(stone-1).x= s.player_1.get(stone-1).x+n.moving;
                s.print();
        }
                else {
                s.player_1.get(stone-1).x=1;
                s.player_1.get(stone-1).on_Board= false;
                }
                return true;
            }
             if((n.moving==6 || n.moving==12)&&(!s.player_1.get(0).on_Board||!s.player_1.get(1).on_Board||!s.player_1.get(2).on_Board||!s.player_1.get(3).on_Board)){
             return true;
             }
             if((s.player_1.get(0).on_Board||s.player_1.get(1).on_Board||s.player_1.get(2).on_Board||s.player_1.get(3).on_Board)&&(n.moving==3||n.moving==2||n.moving==4)){
            
            while (true) {
                    System.out.print("Enter number of Stone: ");
                    stone = ss.nextInt();
                    System.out.println();
                if ((stone > 0) && (stone < 5)&& s.player_1.get(stone-1).on_Board) {
                     break;
            }  
        }
            System.out.println(n.moving);
                    if (s.player_1.get(stone-1).x+n.moving<85){
                s.player_1.get(stone-1).x= s.player_1.get(stone-1).x+n.moving;
                s.print();
        }
                else {
                s.player_1.get(stone-1).x=1;
                s.player_1.get(stone-1).on_Board= false;
                }
                return false;
            }
            
            return false;
            
    }

    public static void main(String[] args) {
   Barsees b = new Barsees();
        b.playGame();
  //   State s = new State();
   //s.print();
   
  /*      List<State> nextStates = s.getNextState();
            for (State nextState : nextStates) {
                
                nextState.print();
    }*/
           // s.solvebfs(s);
    
}
  private boolean getComputerMove() {
      s =maxMovea(s,4).state;
      return false;
    }
  private State_Eval maxMovea(State b ,int depth) {
      
       if(b.how_Win()|| depth==0){
        State_Eval m = new State_Eval(b, b.eval(3)); 
        return m;
 }
     int max=Integer.MIN_VALUE;
   
    State bestState = null;
    List <State> states = b.getNextState(3);      
    for(int i=0; i<states.size(); i++) {
      
           
            bestState = states.get(i);
           
              if(max < bestState.eval(3)) {
                   max= minMove(bestState,depth-1).eval;
              }
  
              b = bestState;
        
    }
 
 
 

      State_Eval m = new State_Eval(b, b.eval(3)); 
   return m;
}
  private State_Eval minMove(State b ,int depth) {
            if(b.how_Win() || depth==0){
        State_Eval m = new State_Eval(b, b.eval(3)); 
        return m;
 }
    int min = Integer.MAX_VALUE;
    State bestState = null;
    List <State> states = b.getNextState(2);      
    for(int i=0; i<states.size(); i++) {
        if(min > states.get(i).eval(2)) {
            min = states.get(i).eval(2);
            bestState = states.get(i); 
       min=  maxMovea(bestState,depth-1).eval;
        b = bestState;
        }
    }
    State_Eval m = new State_Eval(b, b.eval(2));    return m;
}
  
  class State_Eval{
    State state;
    Integer eval;

    public State_Eval(State state, Integer eval) {
        this.state = state;
        this.eval = eval;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    public Integer getEval(){return eval;}
    public void setEval(Integer eval){this.eval = eval;}}}
