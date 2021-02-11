package EulerProblems;

import java.io.*;
import java.util.*;

public class Euler54 {
    public static enum RANK{
        highCard(1),
        onePair(2),
        twoPairs(3),
        treeOfAKind(4),
        straight(5),
        flush(6),
        fullHouse(7),
        fourOfAKind(8),
        straightFlush(9),
        royalFlush(10);

        private final int value;
        private RANK(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
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

        @Override
        public int hashCode() {
            return value + strenght;
        }

        @Override
        public boolean equals(Object obj) {
            Card card = (Card)obj;
            if(this.getValue() == card.getValue()) return true;
            else return false;
        }
    }

    public static class PlayerCards{
        List<Card> cards;

        /**
         * card with index 0 is the most valuable
         * card with index n is the least valuable
         */
        List<Card> highestRankedCard;

        public PlayerCards() {
            cards = new ArrayList<Card>();
            highestRankedCard = new ArrayList<Card>();
        }

        public void addCard(Card card){
            cards.add(card);
            Collections.sort(cards, Comparator.comparingInt(Card::getStrenght));
        }

        public List<Card> getCards() {
            return cards;
        }

        public RANK getCardsRank(){
            if(isRoyalFlush()) return RANK.royalFlush;
            else if(isStraightFlush()) return RANK.straightFlush;
            else if(isFourOfAKind()) return RANK.fourOfAKind;
            else if(isFullHouse()) return RANK.fullHouse;
            else if(isFlush()) return RANK.flush;
            else if(isStraight()) return RANK.straight;
            else if(isThreeOfAKind()) return RANK.treeOfAKind;
            else if(isTwoPairs()) return RANK.twoPairs;
            else if(isSOnePair()) return RANK.onePair;
            else{
                for(int i = 4; i>=0; i--){
                    highestRankedCard.add(cards.get(i));
                }
                return RANK.highCard;
            }
        }

        /**
         *
         * @param n high card turn
         * @return if n=4 return highest card, if n=0 lowest
         */
        public Card getHighCard(int n){
            return cards.get(n);
        }

        public List<Card> getHighestRankedCard(){
            return highestRankedCard;
        }

        private boolean isRoyalFlush(){
            if(isStraightFlush() && getHighCard(0).getValue() == 'T'){
                highestRankedCard.add(cards.get(4));
                return true;
            }
            return false;
        }

        private boolean isStraightFlush(){
            if(isFlush() && isStraight()) {
                highestRankedCard.add(cards.get(4));
                return true;
            }
            return false;
        }

        /**
         *
         * @param set
         * @param exception1 is a first value which you don't want to return
         * @param exception2 is a second value which you don't want to return
         * @return
         */
        private Card getSetValue(Set<Card> set, char exception1, char exception2){
            Card cardValue = new Card("0X");
            for(Iterator<Card> it = set.iterator(); it.hasNext();){
                Card tmp = it.next();
                if(tmp.getStrenght() > cardValue.getStrenght() && tmp.getValue() != exception1 && tmp.getValue() != exception2) {
                    cardValue = tmp;
                }
            }
            return cardValue;
        }

        private boolean isFourOfAKind(){
            HashSet<Card> p = new HashSet<>();
            HashSet<Card> avoided = new HashSet<>();
            for(Card c:cards){
                if(!p.add(c)){
                    avoided.add(c);
                }
            }
            if(p.size() == 2 && avoided.size() == 1){
                Card fourValue = getSetValue(avoided, '0', '0');
                Card oneValue = getSetValue(p, fourValue.getValue(), '0');
                highestRankedCard.add(fourValue);
                highestRankedCard.add(oneValue);
                return true;
            }
            return false;
        }

        private boolean isFullHouse(){
            Set<Card> p = new HashSet<>();
            Set<Card> avoided = new HashSet<>();
            for(Card c:cards){
                if(!p.add(c)){
                    avoided.add(c);
                }
            }
            if(p.size() == 2 && avoided.size() == 2){
                Card higerValue = getSetValue(avoided, '0', '0');
                Card oneValue = getSetValue(p, higerValue.getValue(), '0');
                highestRankedCard.add(higerValue);
                highestRankedCard.add(oneValue);
                return true;
            }
            return false;
        }

        private boolean isFlush(){
            char color = cards.get(0).getColor();
            for(Card card:cards){
                if(card.getColor()!=color) return false;
            }
            for(int i=4; i>=0; i--){
                highestRankedCard.add(cards.get(i));
            }
            return true;
        }

        private boolean isStraight(){
            int currStrength = cards.get(0).getStrenght();
            for(int i=1; i<cards.size(); i++){
                if(cards.get(i).getStrenght() != (currStrength+1)) return false;
                currStrength = cards.get(i).getStrenght();
            }
            highestRankedCard.add(cards.get(4));
            return true;
        }

        private boolean isThreeOfAKind(){
            Set<Card> p = new HashSet<>();
            Set<Card> avoided = new HashSet<>();
            for(Card c:cards){
                if(!p.add(c)){
                    avoided.add(c);
                }
            }
            if(p.size() == 3 && avoided.size() == 1){
                Card threeValue = getSetValue(avoided, '0', '0');
                Card oneHigherValue = getSetValue(p, threeValue.getValue(), '0');
                Card oneLowerValue = getSetValue(p, threeValue.getValue(), oneHigherValue.getValue());
                highestRankedCard.add(threeValue);
                highestRankedCard.add(oneHigherValue);
                highestRankedCard.add(oneLowerValue);
                return true;
            }
            return false;
        }

        private boolean isTwoPairs(){
            Set<Card> p = new HashSet<>();
            Set<Card> avoided = new HashSet<>();
            for(Card c:cards){
                if(!p.add(c)){
                    avoided.add(c);
                }
            }
            if(p.size() == 3 && avoided.size() == 2){
                Card higherPair = getSetValue(avoided, '0', '0');
                Card lowerPair = getSetValue(avoided, higherPair.getValue(), '0');
                Card oneLowerValue = getSetValue(p, higherPair.getValue(), lowerPair.getValue());
                highestRankedCard.add(higherPair);
                highestRankedCard.add(lowerPair);
                highestRankedCard.add(oneLowerValue);
                return true;
            }
            return false;
        }

        private boolean isSOnePair(){
            Set<Card> p = new HashSet();
            Set<Card> avoided = new HashSet<>();
            for(Card c:cards){
                if(!p.add(c)){
                    avoided.add(c);
                }
            }
            if(p.size() == 4){
                Card pair = getSetValue(avoided, '0', '0');
                highestRankedCard.add(pair);
                for(int i=4; i>=0; i--){
                    Card tmp = cards.get(i);
                    if(!tmp.equals(pair)) {
                        highestRankedCard.add(tmp);
                    }
                }

                return true;
            }
            return false;
        }

    }

    public static int getWinner(PlayerCards pl1, PlayerCards pl2){
        RANK rankPl1 = pl1.getCardsRank();
        RANK rankPl2 = pl2.getCardsRank();
        if(rankPl1.getValue() > rankPl2.getValue()) return 1;
        else if(rankPl1.getValue() < rankPl2.getValue()) return 2;
        else{
            //wysoka karta w ukladzie
            int n=4;
            List<Card> pl1Cards = pl1.getHighestRankedCard();
            List<Card> pl2Cards = pl2.getHighestRankedCard();
            for (int i=0;i<pl1Cards.size(); i++){
                if(pl1Cards.get(i).getStrenght() > pl2Cards.get(i).getStrenght()) return 1;
                else if(pl1Cards.get(i).getStrenght() < pl2Cards.get(i).getStrenght()) return 2;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<PlayerCards> player1 = new ArrayList<PlayerCards>();
        List<PlayerCards> player2 = new ArrayList<PlayerCards>();

        try(BufferedReader br = new BufferedReader(new FileReader("poker.txt"))){
            String line;
            int player1Wins = 0;
            int player2Wins = 0;
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
                int winner = getWinner(pl1, pl2);
                switch (winner) {
                    case 1: player1Wins++;
                    break;
                    case 2: player2Wins++;
                    break;
                }
            }
            System.out.println("Player1 wins: ");
            System.out.println(player1Wins);
            System.out.println("Player2 wins: ");
            System.out.println(player2Wins);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
