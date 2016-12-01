public class FlashCard{
  
  public String question;
  public String answer;
  
  public FlashCard(String q,String a){
    question = q;
    answer = a;
  }
  
  public String toString(){
    return "Q: " + question + " A: " + answer;
  }
}