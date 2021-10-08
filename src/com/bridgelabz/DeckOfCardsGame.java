package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class DeckOfCardsGame {
    public static final Scanner Sc = new Scanner(System.in);
    public ArrayList<String> cardsDeck = new ArrayList<>();

    /*
    In this method we have initialized the size of cards.
    In this method  we are also printing the size of card as well as all the possible combinations of cards
     */
    public void deckOfCards(){
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Queen", "Ace"};
        int numOfCards = suits.length * ranks.length;
        System.out.println("\nNumber of cards in the deck are:" + numOfCards);//gives total no of cards in deck
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                cardsDeck.add(ranks[i] + "--->" + suits[j]);
            }
        }
        toDisplay(cardsDeck);
    }
     /*
    In this we have to define no of players should be minimum 2 and maximum 4.
    we use if condition to chek whether entered players are between given range ie 2 to 4
     */
     public void noOfPlayers() {
         System.out.print("\nEnter number of players minimum 2 , maximum 4 : ");
         int player = Sc.nextInt();
         if (player >= 2 && player <= 4) {
             System.out.println("\n" + player + " players will play the game");
             sequenceOfPlay(player);  // We are calling sequence method inside the if condition
         } else {
             System.out.println("Please enter number of players in the Range");
             noOfPlayers();
         }
         Sc.close(); // Closed the Scanner Object.
     }
    /*
       In this method we have defined the sequence of the player.
       We are iterating the loop till player input.
       */
    public void sequenceOfPlay(int player) {
        System.out.println("\nSequence of cards are below : ");
        toshuffle(cardsDeck, player);  // caling toShuffle Method inside it.
    }
    //In this method we have defined the sequence of the player.
    public static ArrayList<String> toshuffle(ArrayList<String> cardsDeck, int player) {
        System.out.println("Shuffling the cards before Distribution");
        ArrayList<String> temp = new ArrayList<>();
        while (!cardsDeck.isEmpty()) {
            int loc = (int) (Math.random() * cardsDeck.size());
            temp.add(cardsDeck.get(loc));
            cardsDeck.remove(loc);
        }
        cardsDeck = temp;
        toDisplay(cardsDeck); // To display the cards this method is called.
        cardDistribution(cardsDeck, player); // Calling Card Distribution method inside this method
        return cardsDeck;
    }
    //Created a method for equal distribution of cards.
    public static void cardDistribution(ArrayList<String> cardsDeck, int player) {
        // This loop will iterate for no of players
        for (int i = 0; i < player; i++) {
            System.out.print("\nPlayer " + (i + 1) + " got cards:\n");
            // This loop will iterate for no of cards for each player
            for (int j = 0; j < 9; j++) {
                System.out.print("\t" + cardsDeck.get(i+j*player));
            }
        }
        System.out.println();
    }

    //This Method Is used to Display the Deck Of Cards
    public static void toDisplay(ArrayList<String> cardsDeck) {
        System.out.println("\nCards in the Deck are:");
        for (String element : cardsDeck) {
            System.out.println(element);
        }
        System.out.println();
    }
}
