package quotesLab;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QclassTest {
    @Test
    @Description("Testing Random quotes")
    public void testRandom() {
        Qclass[] quotes = Qclass.randomQ();

        assertNotNull(quotes);

        assertTrue(quotes.length > 0);

        assertNotNull(quotes[0].getAuthor());
        assertFalse(quotes[0].getAuthor().isEmpty());

        assertNotNull(quotes[0].getText());
        assertFalse(quotes[0].getText().isEmpty());
    }

    @Test
    @Description("Testing correct object type")
    public void testObjectType() {
        Qclass quotes = new Qclass();
        assertInstanceOf(Qclass.class, quotes);
    }

    @Test
    @Description("Testing getter method for the author")
    public void testAutherGetter() {
        Qclass quotes = new Qclass("ghaidaa", "good");
        assertEquals("ghaidaa", quotes.getAuthor());
    }

    @Test
    @Description("Testing getter method for the text")
    public void testTextGetter() {
        Qclass quotes = new Qclass("ghaidaa", "good");
        assertEquals("good", quotes.getText());
    }
}
