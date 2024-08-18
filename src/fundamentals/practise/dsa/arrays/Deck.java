package fundamentals.practise.dsa.arrays;

import java.util.Arrays;
import java.util.Random;

public class Deck {

    public static void shuffle(String[] cards){
        Random rand = new Random();
        for(int i=0;i<cards.length;i++){
            int position = rand.nextInt(cards.length);
            String temp = cards[i];
            cards[i] = cards[position];
            cards[position] = temp;
        }
    }

    public static void main(String[] args){
        String[] suits = {"clubs","Diamonds","Hearts","Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","Jack","Queen","King","Ace"};

        // initialize deck
        int n = suits.length * ranks.length;
        String[] deck = new String[n];

        for(int i=0;i<suits.length;i++){
            for(int j=0;j<ranks.length;j++){
                deck[ranks.length*i + j] = ranks[j] + " of " + suits[i];
            }
        }

        System.out.println(Arrays.toString(deck));
        shuffle(deck);
        System.out.println(Arrays.toString(deck));
    }
}
