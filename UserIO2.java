import java.util.Scanner;
import javax.swing.JOptionPane;

public class UserIO2 {
    private String mood_Question;
    private String health_Question; 
    private String loc_Question; 
    private String takeOut_Question; 
    private Scanner sc;

    private DiningAlgorithm diningAlgorithm;
    
    public UserIO2()
    {
        sc = new Scanner(System.in); //scanner takes in user input
        mood_Question = "What mood are you in right now? Choose between happy/alright/meh/depressed."; //1
        health_Question = "How healthy are you feeling right now? Choose between healthy/don't care/unhealthy."; //2
        loc_Question = "Where are you closest to right now? Choose between Covel, Sproul, Hedrick, De Neve, Rieber, Campus."; //3
        takeOut_Question = "Are you fine with eating at takeout places? Yes/No/idc"; //4
        welcome();

       	diningAlgorithm = new DiningAlgorithm(getMood(), getHealthLevel(), getLoc(), takeout());
    }

    
    public void welcome()
    {
    	JOptionPane.showMessageDialog(null,"Welcome to DiningDecisions!!(Click OK to continue)");
    	JOptionPane.showMessageDialog(null,"We are here to help you make a decision on WHERE you should dine right now.");
    	JOptionPane.showMessageDialog(null,"Please answer the following questions to help us make the BEST decision for you :)");
    }
    
    public int getMood()
    {
        int ans = -1; //scale out of 4 of mood, 4 being happiest
        System.out.println(mood_Question); //asks the question
        String response = JOptionPane.showInputDialog(mood_Question).toLowerCase().trim();
        if(response.equals("happy"))
        {
            ans = 3;
        }else if(response.equals("alright"))
        {
            ans = 2;
        }else if(response.equals("meh"))
        {
            ans = 1;
        }else if(response.equals("depressed"))
        {
            ans = 0;
        }else
        {
            JOptionPane.showMessageDialog(null,"Please input a valid response again!");
            return getMood();
        }
        return ans; 
    }
    
    public int getHealthLevel()
    {
        int ans = -1; //scale out of 10 of health, 10 being feeling the most healthy
        System.out.println(health_Question);
        String response = JOptionPane.showInputDialog(health_Question).toLowerCase().trim();
        if(response.equals("healthy"))
        {
            ans = 2;
        }else if(response.equals("don't care"))
        {
            ans = 1;
        }else if(response.equals("unhealthy"))
        {
            ans = 0;
        }else
        {
        	JOptionPane.showMessageDialog(null,"Please input a valid response again!");
            return getHealthLevel();
        }
        return ans;
    }

    public int getLoc()
    {
        int ans = 0;
        System.out.println(loc_Question);
        String response = JOptionPane.showInputDialog(loc_Question).toLowerCase().trim();
        if(response.equals("covel"))
        {
            ans = 0;
        }else if(response.equals("hedrick"))
        {
            ans = 1;
        }else if(response.equals("rieber"))
        {
            ans = 2;
        }else if(response.equals("de neve"))
        {
            ans = 3;
        }else if(response.equals("sproul"))
        {
            ans = 4;
        }else if(response.equals("campus"))
        {
            ans = 5;
        }else
        {
        	JOptionPane.showMessageDialog(null,"Please input a valid response again!");
            return getLoc();
        }
        return ans;
    }

    public int takeout()
    {
        int ans = 0;
        System.out.println(takeOut_Question);
        String response = JOptionPane.showInputDialog(takeOut_Question).toLowerCase().trim();
        if(response.equals("yes"))
        {
            ans = 1;
        }else if(response.equals("no"))
        {
            ans = 0;
        }else if(response.equals("idc"))
        {
            ans = 2;
        }
        return ans;
    }

    public void printDiningHall()
    {
        //System.out.println("You should go to " + diningAlgorithm.calculateDiningHall());
        JOptionPane.showMessageDialog(null,"You should go to " + diningAlgorithm.calculateDiningHall());
    }
}