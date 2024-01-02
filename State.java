package barsees;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
public class State {
     List <Stone> player_1 = new LinkedList();
     int counter =2;
     nard n = new nard();
    public State (){
    player_1.add(new Stone(1,false));
    player_1.add(new Stone(1,false));
    player_1.add(new Stone(1,false));
    player_1.add(new Stone(1,false));
    player_1.add(new Stone(1,false));
    player_1.add(new Stone(1,false));
    player_1.add(new Stone(1,false));
    player_1.add(new Stone(1,false));
    }
    public void print()
    {
        for (int i = 0; i <4; i++) {
            System.out.print(" plater 1 stone ["+(i+1)+"] = " );
            if(player_1.get(i).on_Board)
            {
                System.out.println(player_1.get(i).x);
            }
            else{
                System.out.println("Not on the board");
                
            }
            
        }
        System.out.println("           _ _ _ _ _ _ _ _ _ _");
          System.out.println("           _ _ _ _ _ _ _ _ _ _");
        for (int i = 4; i < 8; i++) {
            System.out.print(" plater 2 stone ["+(i-3)+"] = " );
            
        
           if(player_1.get(i).on_Board)
            {
                System.out.println(getNew_x(player_1.get(i)));
            }
            else{
                System.out.println("Not on the board");
            }
        }
    System.out.println("           _ _ _ _ _ _ _ _ _ _");
          System.out.println("           _ _ _ _ _ _ _ _ _ _");
    }
    public boolean how_Win()
    {
    
        if (player_1.get(0).x==84 && player_1.get(1).x==84 && player_1.get(2).x==84 && player_1.get(3).x==84) return true; 
        if (player_1.get(4).x==84 && player_1.get(5).x==84 && player_1.get(6).x==84 && player_1.get(7).x==84) return true; 
             return false;     
    }
    public int getNew_x( Stone stone)
    {
    if(stone.x>=1&&stone.x<=7)return -stone.x;
    if(stone.x>=8&&stone.x<=41)return stone.x+34;
    if(stone.x>=42&&stone.x<=76)return stone.x-34;
    return -stone.x;
    }
    boolean canMove(Stone s) {
        
        return s.x<85 &&s.on_Board;
    }
    Map<Stone, Integer> checkMove( nard n,int num) {        
       int i,x,nn;
       Map<Stone, Integer> moves = new HashMap();
       if (num%2==0) {
           System.out.println("player 1 dor");
           i = 0;
           nn = 4;
       }
       else{
           System.out.println("player 2 dor");
       i=4;
       nn=8;
       }
       for (  x=i ; x < nn; x++){
           if(player_1.get(x).on_Board){
           if (canMove(new Stone(player_1.get(x).x+n.moving,true))){               
              Stone newStone = new Stone(player_1.get(x).x+n.moving,true);
              moves.put(newStone , x);   
           }    
           }
          else if (n.khal&&!player_1.get(x).on_Board){
              Stone newStone = new Stone(player_1.get(x).x,true);
              moves.put(newStone ,x);           
       }
          else{
              Stone newStone = new Stone(player_1.get(x).x,false);
              moves.put(newStone , x);
          break;
          }
       }
   return moves;
   }
   public void move(Stone s,int i)
   {
    if (i ==4 || i==5|| i ==6 || i==7){
        if ((getNew_x(s)==player_1.get(0).x || getNew_x(s)==player_1.get(1).x ||getNew_x(s)==player_1.get(3).x || getNew_x(s)==player_1.get(2).x)&& getNew_x(s)!=11 && getNew_x(s)!=22 && getNew_x(s)!=28 && getNew_x(s)!=39 && getNew_x(s)!=45 && getNew_x(s)!=56 && getNew_x(s)!=62 && getNew_x(s)!=73 ){
           player_1.get(i).x=1;
           player_1.get(i).on_Board=false;
       }
        else{
           player_1.get(i).x=s.x;
           player_1.get(i).on_Board=s.on_Board;
       }
    }
    else {
        if ((getNew_x(player_1.get(4))== s.x || getNew_x(player_1.get(5))== s.x||getNew_x(player_1.get(6))==s.x || getNew_x(player_1.get(7))==s.x) && s.x!=11 && s.x!=22 && s.x!=28 && s.x!=39 && s.x!=45 && s.x!=56 && s.x!=62 && s.x!=73 ){
            player_1.get(i).x=1;
            player_1.get(i).on_Board=false;
       }
        else{
            player_1.get(i).x=s.x;
            player_1.get(i).on_Board=s.on_Board;
       } 
               }
   }
   State deepCopy()
   {
   State s = new State();
       for (int i = 0; i < player_1.size(); i++) {
        s.player_1.get(i).x=this.player_1.get(i).x;
        s.player_1.get(i).on_Board=this.player_1.get(i).on_Board;     
       }
             return s;
   }
     
   List<State> getNextState(int num) {
            
        List<State> nextState = new LinkedList<>();
        Map<Stone, Integer> moves = checkMove(n.s(),num);
        System.out.println("move size = "+ moves.size());
        for (Map.Entry<Stone, Integer> entry : moves.entrySet()) {
            Stone key = entry.getKey();
            Integer value = entry.getValue();
            State s = deepCopy();
            s.move(key, value);
            nextState.add(s);
        }
        System.out.println("conter = ==============    "+num);
        return nextState;
    }
       public  State solvebfs(State startState) {
        Queue<State> queue = new LinkedList<>();
        int num =2;
        queue.add(startState);
        while (!queue.isEmpty()) {
            State current = queue.poll();        
            if (current.how_Win()) {

                System.out.println("you win !");
             
               
                return current;
            }

            List<State> nextStates = current.getNextState(num);
            for (State nextState : nextStates) {
                nextState.print();
                    queue.add(nextState);
            }
        num = num +1;
        }
        System.out.println("you lose");
        return startState;
    }
   public int  eval (int num)
   { int i,x,nn;
        if (num%2==0) {
           System.out.println("player 1 dor");
           i = 0;
           nn = 4;
       }
       else{
           System.out.println("player 2 dor");
       i=4;
       nn=8;
       }
       int eval=0;
       for (  x=i ; x < nn; x++){      
   if(n.khal&&!player_1.get(x).on_Board) {
   }
   eval = eval +100;
   if(player_1.get(x).x+n.moving==84)
   {
       eval +=1000000;   
   }
   if(player_1.get(x).x+n.moving>84)
   {
   eval += -10000;
   }
   if(player_1.get(x).x<player_1.get(x).x+n.moving)
   {eval += 10;}
   }
   
   return eval;
   }
   }

