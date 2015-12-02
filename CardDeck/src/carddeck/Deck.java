package carddeck;

//********************************************************************
//  Deck.java
//
//  Solution to Programming Project 6.8
//********************************************************************

import java.util.Random;

public class Deck
{
   private int numCards;
   private Card[] cards;
   private int NUM_CARDS = 52;

   //-----------------------------------------------------------------
   //  Creates a deck, cards are created in order
   //-----------------------------------------------------------------
   public Deck()
   {
      numCards = NUM_CARDS;
      cards = new Card[numCards];

      //create the deck (cards created in order)
      int cardIndex = 0;
      for (int face = Card.ACE; face <= Card.KING; face++)
         for (int suit = Card.CLUBS; suit <= Card.SPADES; suit++)
            cards[cardIndex++] = new Card(face, suit);
   }

   //-----------------------------------------------------------------
   //  Deals a card from the deck
   //-----------------------------------------------------------------
   public Card deal()
   {
      if (numCards > 0)
         return cards[--numCards];
      else
         return null;
   }

   //-----------------------------------------------------------------
   //  Returns the number of cards left in the deck
   //-----------------------------------------------------------------
   public int getNumCardsInDeck()
   {
      return numCards;
   }

   //-----------------------------------------------------------------
   //  Returns true is the deck has cards in it, else false
   //-----------------------------------------------------------------
   public boolean hasMoreCards()
   {
      return (numCards > 0);
   }

   //-----------------------------------------------------------------
   //  Shuffles the deck.  Resets the number of cards in the deck to 52
   //-----------------------------------------------------------------
   public void shuffle()
   {
      Random gen = new Random();

      numCards = NUM_CARDS;

      boolean[] taken= new boolean[NUM_CARDS];
      for (int i=0; i<numCards; i++)
         taken[i] = false;

      int[] shufflePositions = new int[NUM_CARDS];
      int count = 0;

      // determine shuffled positions
      while (count < 52)
      {
         int place = gen.nextInt(NUM_CARDS);
         if (!taken[place])
         {
            shufflePositions[count] = place;
            taken[place] = true;
            count++;
         }
      }

      // move cards to shuffled positions
      Card[] temp = new Card[NUM_CARDS];

      for (int i=0; i< numCards; i++)
         temp[shufflePositions[i]] = cards[i];

      cards = temp;
   }
}
