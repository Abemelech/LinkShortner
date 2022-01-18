package LinkShortner.src;
import java.util.Scanner;
import java.util.HashMap;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import LinkShortner.src.Randomizer;
import org.apache.commons.validator.routines.UrlValidator;

public class Main {
    public static void main (String[] args) throws MalformedURLException, IOException, URISyntaxException {

        // A hashmap to store the link and the shortned link
        HashMap<String, String> linkBank = new HashMap<String, String>();

        linkBank.put("AM.com/google", "www.google.com");

        // Console prints of instruction for the user to choose between creating a link or getting redirected
        System.out.println("Welcome to AM's Shortner. WE DO LIKE THEM SHORT!!!");
        System.out.println("What would you like to choose?");
        System.out.println("1. Create a short link");
        System.out.println("2. Get re-directed to a website");
        System.out.println("Enter only a number to decide.");

        // A Scanner for user inputs on the decision
        Scanner userInput = new Scanner(System.in);
        char menuDecision = userInput.next().charAt(0);

        // If the decision is to make a shortned link then initialize ShortLink class
        if (menuDecision == '1'){
            //Get link and shortned link and store them in the link bank
            ShortLink start = new ShortLink();
            linkBank.put(start.getShort(), start.getlink());
            System.out.println(linkBank);

        } else if (menuDecision == '2') {
            //If the decision was to redirect then initialize Redirect class
            Redirect menu2 = new Redirect();
            String website = linkBank.get(menu2.getUrl());

            // Get url from user and get access of the long url and head to a website 
            System.out.println(website);
            Desktop desktop = Desktop.getDesktop();

            desktop.browse(new URL("https://" + website).toURI());


        } else {
            System.out.println("Not working");
        }

    }
}

class ShortLink {
    String link;
    ShortLink(){
        // Get user input of the link they want to shorten
        System.out.println("What link do you want to shorten?");
        Scanner userInput = new Scanner(System.in);
        this.link = userInput.nextLine();

        // Validate if the url is valid and store link
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
        // Getter for the link
        return this.link;
    }

    public String getShort() {
        // Ask if the user want a custom short url
        System.out.println("Do you want to create a custom url. If 'yes', write down the word. If 'no', type 'no'");
        Scanner userInput = new Scanner(System.in);
        String specificInput = userInput.nextLine().toString();
        String shortlinkEnd;

        // Run a randomizer and generate a 6 letter string
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


class Redirect {
    String url;
    Redirect(){
        // Get user input of what link the user wants to access
        System.out.println("Enter your shortned URL to get redirected to the official website");
        Scanner userInput = new Scanner(System.in);
        this.url = userInput.nextLine().toString();       
    }

    public String getUrl() {
        // Send url
        return this.url;
    }
}