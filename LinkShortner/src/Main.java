package LinkShortner.src;
import java.util.Scanner;
import java.util.HashMap;
import LinkShortner.src.Randomizer;
import org.apache.commons.validator.routines.UrlValidator;

    public class Main {
    public static void main (String[] args) {

        HashMap<String, String> linkBank = new HashMap<String, String>();

        System.out.println("Welcome to AM's Shortner. WE DO LIKE THEM SHORT!!!");
        System.out.println("What would you like to choose?");
        System.out.println("1. Create a short link");
        System.out.println("2. Get re-directed to a website");
        System.out.println("Enter only a number to decide.");

        Scanner userInput = new Scanner(System.in);
        char menuDecision = userInput.next().charAt(0);

        if (menuDecision == '1'){
            //Run another class
            ShortLink start = new ShortLink();
            linkBank.put(start.getShort(), start.getlink());
            System.out.println(linkBank);

        } else if (menuDecision == '2') {
            //Run another class
            System.out.println("2");
        } else {
            System.out.println("Not working");
        }

    }
}

class ShortLink {
    String link;
    ShortLink(){
        System.out.println("What link do you want to shorten?");
        Scanner userInput = new Scanner(System.in);
        this.link = userInput.nextLine();
        String[] schemes = {"http","https"};
        UrlValidator urlValidator = new UrlValidator(schemes);

        if (urlValidator.isValid("https://"+this.link)){
            System.out.println("Link Verified");
        } else {
            System.out.println("Link Invalid");
            this.link = null;
        }

    } 
    public String getlink() {
        return this.link;
    }

    public String getShort() {
        System.out.println("Do you want to create a custom url. If 'yes', write down the word. If 'no', type 'no'");
        Scanner userInput = new Scanner(System.in);
        String specificInput = userInput.nextLine().toString();
        String shortlinkEnd;
        if (specificInput.equals("no")) {
            Randomizer shorter = new Randomizer(6);
            shortlinkEnd = shorter.nextString();
        } else {
            shortlinkEnd = specificInput;
        }

        
        String shortlink = "AM.com/" + shortlinkEnd;
        System.out.println(shortlink);
        return  shortlink;
    }
}

