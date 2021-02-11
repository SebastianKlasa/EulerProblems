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
    public static Euler54.PlayerCards pl2;    //player with straight
    public static Euler54.PlayerCards pl3;    //player with straight flush
    public static Euler54.PlayerCards pl4;    //player with royal flush
    public static Euler54.PlayerCards pl5;    //player with pair
    public static Euler54.PlayerCards pl6;    //player with two pairs
    public static Euler54.PlayerCards pl7;    //player with three of a kind
    public static Euler54.PlayerCards pl8;    //player with full house
    public static Euler54.PlayerCards pl9;    //player with four of a kind

    public static Method isRoyalFlush;
    public static Method isStraightFlush;
    public static Method isFourOfAKind;
    public static Method isFullHouse;
    public static Method isFlush;
    public static Method isStraight;
    public static Method isThreeOfAKind;
    public static Method isTwoPairs;
    public static Method isSOnePair;

    @BeforeClass
    public static void initFlush(){
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

    @BeforeClass
    public static void initStright(){
        Euler54.Card c1 = new Euler54.Card("8D");
        Euler54.Card c2 = new Euler54.Card("TC");
        Euler54.Card c3 = new Euler54.Card("QD");
        Euler54.Card c4 = new Euler54.Card("JD");
        Euler54.Card c5 = new Euler54.Card("9S");
        pl2 = new Euler54.PlayerCards();
        pl2.addCard(c1);
        pl2.addCard(c2);
        pl2.addCard(c3);
        pl2.addCard(c4);
        pl2.addCard(c5);
    }

    @BeforeClass
    public static void initStrightFlush(){
        Euler54.Card c1 = new Euler54.Card("5H");
        Euler54.Card c2 = new Euler54.Card("3H");
        Euler54.Card c3 = new Euler54.Card("2H");
        Euler54.Card c4 = new Euler54.Card("6H");
        Euler54.Card c5 = new Euler54.Card("4H");
        pl3 = new Euler54.PlayerCards();
        pl3.addCard(c1);
        pl3.addCard(c2);
        pl3.addCard(c3);
        pl3.addCard(c4);
        pl3.addCard(c5);
    }

    @BeforeClass
    public static void initRoyalFlush(){
        Euler54.Card c1 = new Euler54.Card("TD");
        Euler54.Card c2 = new Euler54.Card("AD");
        Euler54.Card c3 = new Euler54.Card("QD");
        Euler54.Card c4 = new Euler54.Card("JD");
        Euler54.Card c5 = new Euler54.Card("KD");
        pl4 = new Euler54.PlayerCards();
        pl4.addCard(c1);
        pl4.addCard(c2);
        pl4.addCard(c3);
        pl4.addCard(c4);
        pl4.addCard(c5);
    }

    @BeforeClass
    public static void initPair(){
        Euler54.Card c1 = new Euler54.Card("TS");
        Euler54.Card c2 = new Euler54.Card("AD");
        Euler54.Card c3 = new Euler54.Card("QD");
        Euler54.Card c4 = new Euler54.Card("JH");
        Euler54.Card c5 = new Euler54.Card("TD");
        pl5 = new Euler54.PlayerCards();
        pl5.addCard(c1);
        pl5.addCard(c2);
        pl5.addCard(c3);
        pl5.addCard(c4);
        pl5.addCard(c5);
    }

    @BeforeClass
    public static void initTwoPair(){
        Euler54.Card c1 = new Euler54.Card("TS");
        Euler54.Card c2 = new Euler54.Card("2D");
        Euler54.Card c3 = new Euler54.Card("2D");
        Euler54.Card c4 = new Euler54.Card("JH");
        Euler54.Card c5 = new Euler54.Card("TD");
        pl6 = new Euler54.PlayerCards();
        pl6.addCard(c1);
        pl6.addCard(c2);
        pl6.addCard(c3);
        pl6.addCard(c4);
        pl6.addCard(c5);
    }

    @BeforeClass
    public static void initThreeOfAKind(){
        Euler54.Card c1 = new Euler54.Card("8S");
        Euler54.Card c2 = new Euler54.Card("3D");
        Euler54.Card c3 = new Euler54.Card("3D");
        Euler54.Card c4 = new Euler54.Card("3H");
        Euler54.Card c5 = new Euler54.Card("TD");
        pl7 = new Euler54.PlayerCards();
        pl7.addCard(c1);
        pl7.addCard(c2);
        pl7.addCard(c3);
        pl7.addCard(c4);
        pl7.addCard(c5);
    }

    @BeforeClass
    public static void initFullHouse(){
        Euler54.Card c1 = new Euler54.Card("8S");
        Euler54.Card c2 = new Euler54.Card("3D");
        Euler54.Card c3 = new Euler54.Card("8D");
        Euler54.Card c4 = new Euler54.Card("3H");
        Euler54.Card c5 = new Euler54.Card("8D");
        pl8 = new Euler54.PlayerCards();
        pl8.addCard(c1);
        pl8.addCard(c2);
        pl8.addCard(c3);
        pl8.addCard(c4);
        pl8.addCard(c5);
    }

    @BeforeClass
    public static void initFourOfAKind(){
        Euler54.Card c1 = new Euler54.Card("QS");
        Euler54.Card c2 = new Euler54.Card("3D");
        Euler54.Card c3 = new Euler54.Card("QD");
        Euler54.Card c4 = new Euler54.Card("QH");
        Euler54.Card c5 = new Euler54.Card("QD");
        pl9 = new Euler54.PlayerCards();
        pl9.addCard(c1);
        pl9.addCard(c2);
        pl9.addCard(c3);
        pl9.addCard(c4);
        pl9.addCard(c5);
    }

    @BeforeClass
    public static void initMethods(){
        try {
            isRoyalFlush = Euler54.PlayerCards.class.getDeclaredMethod("isRoyalFlush", null);
            isStraightFlush = Euler54.PlayerCards.class.getDeclaredMethod("isStraightFlush", null);
            isFourOfAKind = Euler54.PlayerCards.class.getDeclaredMethod("isFourOfAKind", null);
            isFullHouse = Euler54.PlayerCards.class.getDeclaredMethod("isFullHouse", null);
            isFlush= Euler54.PlayerCards.class.getDeclaredMethod("isFlush", null);
            isStraight = Euler54.PlayerCards.class.getDeclaredMethod("isStraight", null);;
            isThreeOfAKind = Euler54.PlayerCards.class.getDeclaredMethod("isThreeOfAKind", null);
            isTwoPairs = Euler54.PlayerCards.class.getDeclaredMethod("isTwoPairs", null);
            isSOnePair = Euler54.PlayerCards.class.getDeclaredMethod("isSOnePair", null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
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
        try {
            isFlush.setAccessible(true);
            Object b = isFlush.invoke(pl1, null);
            assertTrue((Boolean) b);

            Object b2 = isFlush.invoke(pl4, null);
            assertTrue((Boolean)b2);
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

    @Test
    public void TestStraight(){
        try {
            isStraight.setAccessible(true);
            Object b = isStraight.invoke(pl2, null);
            assertTrue((Boolean) b);

            Object b2 = isStraight.invoke(pl4, null);
            assertTrue((Boolean)b2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestStraightFlush(){
        try {
            isStraightFlush.setAccessible(true);
            Object b = isStraightFlush.invoke(pl3, null);
            assertTrue((Boolean) b);

            Object b2 = isStraightFlush.invoke(pl4, null);
            assertTrue((Boolean)b2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestRoyalFlush(){
        try {
            isRoyalFlush.setAccessible(true);
            Object b = isRoyalFlush.invoke(pl4, null);
            assertTrue((Boolean) b);

            isRoyalFlush.setAccessible(true);
            Object b2 = isRoyalFlush.invoke(pl3, null);
            assertFalse((Boolean) b2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestPair(){
        try {
            isSOnePair.setAccessible(true);
            Object b = isSOnePair.invoke(pl5, null);
            assertTrue((Boolean) b);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestTwoPair(){
        try {
            isTwoPairs.setAccessible(true);
            Object b = isTwoPairs.invoke(pl6, null);
            assertTrue((Boolean) b);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestThreeOfAKind(){
        try {
            isThreeOfAKind.setAccessible(true);
            Object b = isThreeOfAKind.invoke(pl7, null);
            assertTrue((Boolean) b);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestFullHouse(){
        try {
            isFullHouse.setAccessible(true);
            Object b = isFullHouse.invoke(pl8, null);
            assertTrue((Boolean) b);
        }  catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestFourOfAKind(){
        try {
            isFourOfAKind.setAccessible(true);
            Object b = isFourOfAKind.invoke(pl9, null);
            assertTrue((Boolean) b);
        }  catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestHighCard1(){
        pl1.getCardsRank();
        Euler54.Card c1 = pl1.getHighestRankedCard().get(0);
        Euler54.Card c3 = pl1.getHighestRankedCard().get(2);
        Euler54.Card c5 = pl1.getHighestRankedCard().get(4);
        assertEquals(c1.getValue(), 'K');
        assertEquals(c3.getValue(), '7');
        assertEquals(c5.getValue(), '5');
    }

    @Test
    public void TestHighCard2(){
        Euler54.Card c2 = pl2.getHighestRankedCard().get(0);
        assertEquals(c2.getValue(), 'Q');
    }

    @Test
    public void TestHighCard3(){
        Euler54.Card c3 = pl3.getHighestRankedCard().get(0);
        assertEquals(c3.getValue(), '6');
    }

    @Test
    public void TestHighCard4(){
        Euler54.Card c4 = pl4.getHighestRankedCard().get(0);
        assertEquals(c4.getValue(), 'A');
    }

    @Test
    public void TestHighCard5(){
        Euler54.Card c5 = pl5.getHighestRankedCard().get(0);
        Euler54.Card c52 = pl5.getHighestRankedCard().get(3);
        assertEquals(c5.getValue(), 'T');
        assertEquals(c52.getValue(), 'J');
    }

    @Test
    public void TestHighCard6(){
        Euler54.Card c6 =  pl6.getHighestRankedCard().get(0);
        Euler54.Card c62 =  pl6.getHighestRankedCard().get(2);
        assertEquals(c6.getValue(), 'T');
        assertEquals(c62.getValue(), 'J');
    }

    @Test
    public void TestHighCard7(){
        pl7.getCardsRank();
        Euler54.Card c7 = pl7.getHighestRankedCard().get(0);
        Euler54.Card c72 = pl7.getHighestRankedCard().get(1);
        assertEquals(c7.getValue(), '3');
        assertEquals(c72.getValue(), 'T');
    }

    @Test
    public void TestHighCard8(){
        Euler54.Card c8 =   pl8.getHighestRankedCard().get(0);
        Euler54.Card c82 =   pl8.getHighestRankedCard().get(1);
        assertEquals(c8.getValue(), '8');
        assertEquals(c82.getValue(), '3');
    }

    @Test
    public void TestHighCard9(){
        Euler54.Card c9 =   pl9.getHighestRankedCard().get(0);
        Euler54.Card c92 =   pl9.getHighestRankedCard().get(1);
        assertEquals(c92.getValue(), '3');
    }

    /**
     *  Euler54.PlayerCards pl1;    //player with flush
     *  Euler54.PlayerCards pl2;    //player with straight
     *  Euler54.PlayerCards pl3;    //player with straight flush
     *  Euler54.PlayerCards pl4;    //player with royal flush
     *  Euler54.PlayerCards pl5;    //player with pair
     *  Euler54.PlayerCards pl6;    //player with two pairs
     *  Euler54.PlayerCards pl7;    //player with three of a kind
     *  Euler54.PlayerCards pl8;    //player with full house
     *  Euler54.PlayerCards pl9;    //player with four of a kind
     */

    @Test
    public void TestWinner1(){
        int winner = Euler54.getWinner(pl1, pl2);
        assertEquals(winner, 1);
    }

    @Test
    public void TestWinner2(){
        int winner = Euler54.getWinner(pl9, pl5);
        assertEquals(winner, 1);
    }

    @Test
    public void TestWinner3(){
        int winner = Euler54.getWinner(pl8, pl4);
        assertEquals(winner, 2);
    }

    @Test
    public void TestWinner4(){
        int winner = Euler54.getWinner(pl5, pl6);
        assertEquals(winner, 2);
    }

    @Test
    public void TestWinner5(){
        int winner = Euler54.getWinner(pl6, pl2);
        assertEquals(winner, 2);
    }

}
