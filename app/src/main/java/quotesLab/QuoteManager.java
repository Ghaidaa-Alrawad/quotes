package quotesLab;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class QuoteManager {

    public static Qclass[] readQuotesFromFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            Gson gson = new Gson();
            return gson.fromJson(bufferedReader, Qclass[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Qclass[] readQuotesFromApi(String apiUrl) {
        try {
            URL qUrl = new URL(apiUrl);
            // making a connection
            HttpURLConnection qUrlConnection = (HttpURLConnection) qUrl.openConnection();
            // the method for the connection in GET by default but i'll specify it anyway
            qUrlConnection.setRequestMethod("GET");
            // now reading
            InputStreamReader redQ = new InputStreamReader(qUrlConnection.getInputStream());
            BufferedReader qBufferReader = new BufferedReader(redQ);
            StringBuilder qDataBuilder = new StringBuilder();
            String line;
            while ((line = qBufferReader.readLine()) != null) {
                qDataBuilder.append(line);
            }
            String qData = qDataBuilder.toString();
            Gson gson = new Gson();
            return gson.fromJson(qData, Qclass[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Qclass getRandomQuote(Qclass[] quotes) {
        Random random = new Random();
        int ran = random.nextInt(quotes.length);
        return quotes[ran];
    }

    public static void displayQuote(Qclass quote) {
        System.out.println("Quote: " + quote.getText());
        System.out.println("Author: " + quote.getAuthor());

        // okay here in the output is there is a tag in the api will show it
        // otherwise no it will not be shown in the output, cuz some quotes has no tags
        // but in the Random.json file the tags will be there, whether it's empty or not
        ArrayList<String> tags = quote.getTags();
        if (tags != null && !tags.isEmpty()) {
            System.out.print("Tags: ");
            for (String tag : tags) {
                System.out.print(tag + " ");
            }
            System.out.println();
        }
    }

    public static void saveQuoteToJson(Qclass quote, String filePath) {
        Qclass[] existingQuotes = readQuotesFromFile(filePath);
        Qclass[] newQuotes;

        if (existingQuotes != null) {
            newQuotes = Arrays.copyOf(existingQuotes, existingQuotes.length + 1);
            newQuotes[existingQuotes.length] = quote;
        } else {
            newQuotes = new Qclass[]{quote};
        }

        try (FileWriter writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(newQuotes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
