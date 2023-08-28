package quotesLab;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Qclass {
    private String author;
    private String text;

    public Qclass(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public Qclass(){

    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public static Qclass[] randomQ(){
        Qclass[] quotes = null;
        //reading the quotes lab 08
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\SS2\\Desktop\\adv-java\\quotes\\app\\src\\\\main\\resources\\recentquotes.json"))){
            Gson gson = new Gson();
            quotes = gson.fromJson(bufferedReader, Qclass[].class);

            if (quotes.length > 0) {
                Random random = new Random();
                int ran = random.nextInt(quotes.length);
                Qclass randomQuote = quotes[ran];

                System.out.println("Quote: " + randomQuote.getText());
                System.out.println("Author: " + randomQuote.getAuthor());
            } else {
                System.out.println("No quotes found.");
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return quotes;
    }
    @Override
    public String toString() {
        return "Qclass{" +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
