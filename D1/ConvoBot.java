import java.io.Console;

public class ConvoBot{
   
    public static void main(String[] args) {
        boolean running = true;

        Console cons = System.console();        

        while(running){
            String qns = cons.readLine("What is your hobby?");
            switch(qns.trim().toLowerCase()){
                case "swim":
                    System.out.println("So you like swimming huh?");
                    break;
                case "run":
                    System.out.println("Are you tired? Becauses you've been running in my dreams.");
                    break;
                case "sleep":
                    System.out.println("Surprise, Muthafucka!");
                    running = false;
                    break;
            }
        

        
        }
    }
    
}