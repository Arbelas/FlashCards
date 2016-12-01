import java.util.*;
import java.io.*;

public class FlashCards{
  
  public static void main (String[] args){
    ArrayList qList = loadCards();
    //System.out.println(qList);
    quiz(qList);
  }
  
  public static ArrayList<FlashCard> loadCards(){
    try{
      FileInputStream file = new FileInputStream("./FlashCards.txt");   
      ArrayList qList = new ArrayList<FlashCard>();
      
      Scanner sc = new Scanner(file);
      
      while (sc.hasNextLine()) {
        qList.add(new FlashCard(sc.nextLine(),sc.nextLine()));
      }
      
      sc.close();
      
      return qList;
      
    }catch(IOException e){
      e.printStackTrace();
      return null;
    }
  }
  
  public static void quiz(ArrayList<FlashCard> qList){
    Scanner sc = new Scanner(System.in);
    FlashCard card;
    do{
      card = qList.get((int) (Math.random()*qList.size()));
      System.out.println("Q: " + card.question);
      sc.nextLine();
      System.out.println("A: " + card.answer);
    }while(!(command.equals("STOP")));
  }
  
}
