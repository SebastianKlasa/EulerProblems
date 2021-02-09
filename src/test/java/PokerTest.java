import EulerProblems.Euler54;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class PokerTest {
    public static Euler54.PlayerCards pl1;    //player with flush

    @BeforeClass
    public static void init(){
        Euler54.Card c1 = new Euler54.Card("QD");
        Euler54.Card c2 = new Euler54.Card("5D");
        Euler54.Card c3 = new Euler54.Card("6D");
        Euler54.Card c4 = new Euler54.Card("7D");
        Euler54.Card c5 = new Euler54.Card("KD");
        pl1 = new Euler54.PlayerCards();
        pl1.addCard(c1);
        pl1.addCard(c2);
        pl1.addCard(c3);
        pl1.addCard(c4);
        pl1.addCard(c5);
    }

    @Test
    public void TestStrength(){
        Euler54.Card c1 = new Euler54.Card("5H");
        Euler54.Card c2 = new Euler54.Card("5C");
        Euler54.Card c3 = new Euler54.Card("6S");
        Euler54.Card c4 = new Euler54.Card("7S");
        Euler54.Card c5 = new Euler54.Card("KD");

        assertEquals(c1.getStrenght(), 5);
        assertEquals(c2.getStrenght(), 5);
        assertEquals(c3.getStrenght(), 6);
        assertEquals(c4.getStrenght(), 7);
        assertEquals(c5.getStrenght(), 13);
    }

    @Test
    public void TestFlush(){
        Method method = null;
        try {
            method = Euler54.PlayerCards.class.getDeclaredMethod("isFlush", null);
            method.setAccessible(true);
            Object b = method.invoke(pl1, null);
            assertTrue((Boolean) b);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestSorted(){
        List<Euler54.Card> cards = pl1.getCards();
        assertEquals(cards.get(3).getStrenght(), 12);
    }

}
