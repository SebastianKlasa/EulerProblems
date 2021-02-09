package EulerProblems;

import java.io.*;
import java.util.*;

public class Euler54 {
    public static enum RANK{
        highCard,
        onePair,
        twoPairs,
        treeOfAKind,
        Straight,
        flush,
        fullHouse,
        fourOfAKind,
        StraightFlush,
        RoyalFlush
    }


    public static class Card{
        char color;
        char value;
        int strenght;

        public Card(String valcol) {
            this.color = valcol.charAt(1);
            this.value = valcol.charAt(0);
            this.strenght = this.value - '0';
            if(this.value == 'T') this.strenght = 10;
            if(this.value == 'J') this.strenght = 11;
            if(this.value == 'Q') this.strenght = 12;
            if(this.value == 'K') this.strenght = 13;
            if(this.value == 'A') this.strenght = 14;
        }

        public char getColor() {
            return color;
        }

        public char getValue() {
            return value;
        }

        public int getStrenght() {
            return strenght;
        }
    }

    public static class PlayerCards{
        List<Card> cards;

        public PlayerCards() {
            cards = new ArrayList<Card>();
        }

        public void addCard(Card card){
            cards.add(card);
            Collections.sort(cards, Comparator.comparingInt(Card::getStrenght));
        }

        public List<Card> getCards() {
            return cards;
        }

        private boolean isRoyalFlush(){
            return true;
        }

        private boolean isFlush(){
            char color = cards.get(0).getColor();
            for(Card card:cards){
                if(card.getColor()!=color) return false;
            }
            return true;
        }

        private boolean isStraight(){
            return true;
        }

    }

    public static void main(String[] args) {
        List<PlayerCards> player1 = new ArrayList<PlayerCards>();
        List<PlayerCards> player2 = new ArrayList<PlayerCards>();

        try(BufferedReader br = new BufferedReader(new FileReader("poker.txt"))){
            String line;
            while((line = br.readLine()) != null){
                String[] splitted = line.split(" ");
                PlayerCards pl1 = new PlayerCards();
                PlayerCards pl2 = new PlayerCards();
                for(int i=0; i<splitted.length;i++){
                    Card card = new Card(splitted[i]);
                    if(i<5) pl1.addCard(card);
                    else pl2.addCard(card);
                }
                player1.add(pl1);
                player2.add(pl2);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
