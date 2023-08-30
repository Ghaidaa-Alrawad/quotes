package quotesLab;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Qclass {
    private String author;
    private String text;
    private ArrayList<String> tags;


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

    public ArrayList<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Qclass{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", tags=" + tags +
                '}';
    }
}
