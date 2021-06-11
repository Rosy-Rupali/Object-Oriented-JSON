package helper;
/**************************************************
 * Purpose : Shuffling cards using Random method
 * @author Rosy Rupali
 * @since 11-06-2021
 *
 *************************************************/
import java.util.Random;

public class DeckOfCards {

	String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
	String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	String[] player = { "player1", "player2", "player3", "player4" };

	String[][] cards = new String[suit.length][rank.length];

	private void shuffle() {
		
		//Random number generation
		Random randomCards = new Random();
		int row = randomCards.nextInt(suit.length);
		int column = randomCards.nextInt(rank.length);

		for (int i = 0; i < suit.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				cards[i][j] = suit[i] + "-" + rank[j];
			}
		}

		// Fetching cards from 2-D Arrays
		for (int i = 0; i < suit.length; i++) {
			for (int j = 0; j < rank.length - 4; j++) {
				while (cards[row][column] == null) {
					
					row = randomCards.nextInt(suit.length);
					column = randomCards.nextInt(rank.length);
				}
				System.out.println(player[i] + " : " + cards[row][column]);
				cards[row][column] = null;
			}
			System.out.println();
		}
	}




	public static void main(String[] args) {
		
		DeckOfCards deckOfCards = new DeckOfCards();
		deckOfCards.shuffle();     //calling of shuffle method
	}
}



