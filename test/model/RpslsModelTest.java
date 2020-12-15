package model;

import org.junit.jupiter.api.Test;

import model.RpslsModel;

import static org.junit.jupiter.api.Assertions.*;

public class RpslsModelTest {
	private static final int ROCK = 0;
	private static final int PAPER = 1;
	private static final int SCISSORS = 2;
	private static final int LIZARD = 3;
	private static final int SPOCK = 4;
	
	private static char determineWinner(int user, int comp) {
		RpslsModel.determineWinner(user, comp, 200);
		return RpslsModel.getWinner().charAt(0);
	}
	
	@Test
	void testTies() {
		assertAll(
			() -> assertEquals('I', determineWinner(ROCK,     ROCK),     "tie"),		//tie
			() -> assertEquals('I', determineWinner(PAPER,    PAPER),    "tie"),
			() -> assertEquals('I', determineWinner(SCISSORS, SCISSORS), "tie"),
			() -> assertEquals('I', determineWinner(LIZARD,   LIZARD),   "tie"),
			() -> assertEquals('I', determineWinner(SPOCK,    SPOCK),    "tie")
			);
	}
	
	@Test
	void TestYou() {
		assertAll(
			() -> assertEquals('Y', determineWinner(ROCK,     SCISSORS), "1-R-s"),	// Player 1 wins
			() -> assertEquals('Y', determineWinner(ROCK,     LIZARD),   "1-R-L"),
			() -> assertEquals('Y', determineWinner(PAPER,    ROCK),     "1-P-R"),
			() -> assertEquals('Y', determineWinner(PAPER,    SPOCK),    "1-P-S"),
			() -> assertEquals('Y', determineWinner(SCISSORS, PAPER),    "1-s-P"),
			() -> assertEquals('Y', determineWinner(SCISSORS, LIZARD),   "1-s-L"),
			() -> assertEquals('Y', determineWinner(LIZARD,   PAPER),    "1-L-P"),
			() -> assertEquals('Y', determineWinner(LIZARD,   SPOCK),    "1-L-S"),
			() -> assertEquals('Y', determineWinner(SPOCK,    ROCK),     "1-S-R"),
			() -> assertEquals('Y', determineWinner(SPOCK,    SCISSORS), "1-S-s")
			);
	}
	@Test
	void TestComp() {
		assertAll(	 
			() -> assertEquals('C', determineWinner(ROCK,     PAPER),    "2-R-P"),	// Player 2 wins
			() -> assertEquals('C', determineWinner(ROCK,     SPOCK),    "2-R-S"),
			() -> assertEquals('C', determineWinner(PAPER,    SCISSORS), "2-P-s"),
			() -> assertEquals('C', determineWinner(PAPER,    LIZARD),   "2-P-L"),
			() -> assertEquals('C', determineWinner(SCISSORS, ROCK),     "2-s-R"),
			() -> assertEquals('C', determineWinner(SCISSORS, SPOCK),    "2-s-S"),
			() -> assertEquals('C', determineWinner(LIZARD,   ROCK),     "2-L-R"),
			() -> assertEquals('C', determineWinner(LIZARD,   SCISSORS), "2-L-s"),
			() -> assertEquals('C', determineWinner(SPOCK,    PAPER),    "2-S-P"),
			() -> assertEquals('C', determineWinner(SPOCK,    LIZARD),   "2-S-L")
		);	
	}
}
