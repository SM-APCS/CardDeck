package carddeck;

//********************************************************************
//  CardDeck.java
//
//  Solution to Programming Project 6.8
//********************************************************************

public class CardDeck
{
   //-----------------------------------------------------------------
   //  Creates a deck, shuffles the deck and deals the cards.
   //-----------------------------------------------------------------
   public static void main (String args[])
   {
      Deck deck = new Deck();

      deck.shuffle();

      int cardNumber = 0;

      System.out.println("Dealing shuffled cards:");
      while (deck.hasMoreCards())
         System.out.println("   " + ++cardNumber + ": " + deck.deal());

   }
}
