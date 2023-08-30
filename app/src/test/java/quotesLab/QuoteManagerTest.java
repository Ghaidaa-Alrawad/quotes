package quotesLab;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class QuoteManagerTest {

    @Test
    @Description("Testing Random quotes")
    public void testGetRandomQuote() {
        Qclass[] quotes = {
                new Qclass("Quote 1", "Author 1"),
                new Qclass("Quote 2", "Author 2"),
                new Qclass("Quote 3", "Author 3")
        };

        Qclass randomQuote = QuoteManager.getRandomQuote(quotes);

        assertNotNull(randomQuote);
        assertTrue(Arrays.asList(quotes).contains(randomQuote));
    }

    @Test
    @Description("Testing if the file will be updated or not when fetching the data")
    public void testFileUpdate() {
        Qclass quote = new Qclass("Test Author", "Test Quote");
        String filePath = "src/test/resources/RandomQtest.json";

        Qclass[] existingQuotes = QuoteManager.readQuotesFromFile(filePath);
        int initialLength = (existingQuotes != null) ? existingQuotes.length : 0;

        QuoteManager.saveQuoteToJson(quote, filePath);

        Qclass[] updatedQuotes = QuoteManager.readQuotesFromFile(filePath);
        assertNotNull(updatedQuotes);
        assertEquals(initialLength + 1, updatedQuotes.length);
    }

    @Test
    @Description("Testing if i fetched the data correctly")
    public void testReadQuotesFromApi() {
        String apiUrl = "https://codefellows.github.io/code-401-java-guide/curriculum/class-08/recentquotes.json";
        Qclass[] apiQuotes = QuoteManager.readQuotesFromApi(apiUrl);
        assertNotNull(apiQuotes);
        assertTrue(apiQuotes.length > 0);
    }

}
