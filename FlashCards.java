import java.util.*;
import java.io.*;

public class FlashCards{
  
  public static void main (String[] args){
    ArrayList qList = loadCards();
    //System.out.println(qList);
    quiz(qList);
  }
  
  public static ArrayList<FlashCard> loadCards(){
    File file = new File("FlashCards.txt");
    ArrayList qList = new ArrayList<FlashCard>();
    
    try{
      Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            qList.add(new FlashCard(sc.nextLine(),sc.nextLine()));
        }
        
        sc.close();
     } 
    catch (FileNotFoundException e) {
        e.printStackTrace();
        return null;
    }
    
    return qList;
  }
  
  public static void quiz(ArrayList<FlashCard> qList){
    Scanner sc = new Scanner(System.in);
    FlashCard card;
    do{
      card = qList.get((int) (Math.random()*qList.size()));
      System.out.println(card.question);
      sc.nextLine();
      System.out.println(card.answer);
    }while(!(sc.nextLine().equals("STOP")));
  }

}