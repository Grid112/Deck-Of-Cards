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
        System.out.print("\nEnter Between 2 to 4 Players To Platy The Game: ");
        int player = Sc.nextInt();
        if (player >= 2 && player <= 4) {
            System.out.println("\n" + player + " players will play the game");
        } else {
            System.out.println("Please enter number of players between 2 to 4");
            this.noOfPlayers();
            Sc.close();
        }
    }
    //In this method we have defined the sequence of the player.
    public void sequenceOfPlay(int player) {
        System.out.println("\nSequence of cards are below : ");
        for (int i = 1; i <= player; i++) {
            System.out.println("\nPlayer " + i + " Getting card.............");
        }
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
