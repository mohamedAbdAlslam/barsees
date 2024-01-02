package barsees;

import java.util.Random;

public class nard {
    boolean khal;
    int moving;
   public  int generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(100);        
        if (randomNumber < 60) {
            return 1; 
        } else {
            return 0;
        }
    }
    public nard() {
        
       
    }
    public nard s()
    {
        nard n = new nard();
        for (int i = 0; i < 6; i++) {
            if(generateRandomNumber()==1)
            n.moving=n.moving+1;           
        }
        System.out.println("move = "+n.moving);
        if(n.moving==1||n.moving==5){
            n.khal=true;  
        System.out.println("khal ="+n.khal);}
        switch (n.moving){
                case 1:
                    System.out.println(" good luck you have khal + bang =24 ");
                    n.moving=24;
                    break;
                case 2 :
                    System.out.println("you have foure = 4 ");
                    n.moving=4;
                    break;
                case 3 :
                    System.out.println("you have three = 3 ");
                    n.moving= 3;
                    break;
                case 4 :
                     System.out.println("you have doaq = 2 ");
                    n.moving= 2;
                    break;
                    case 5:
                    System.out.println(" good luck you have khal + dest =10 ");
                    n.moving=10;
                    break;
                    case 6 :
                     System.out.println("you have shaka = 6 ");
                    n.moving= 6;
                    break;
                    case 0 :
                     System.out.println("you have bara = 12 ");
                    n.moving= 12;
                    break;
                    
                    
        } 
        
    return n;
    }
}
