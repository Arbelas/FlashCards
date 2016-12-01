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
    int index;
    String command;
    
    do{
      index = (int) (Math.random()*qList.size());
      card = qList.get(index);
      System.out.println("Q: " + card.question);
      sc.nextLine();
      System.out.println("A: " + card.answer);
      command = sc.nextLine();
      if(command.equals("REMOVE"))
         qList.remove(index);
      else if(command.equals("LIST"))
         System.out.println(qList);
    }while(!(command.equals("STOP") && qList.size() > 0));
  }
  
}