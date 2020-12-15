package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RpslsModelParameterizedTest {
	static int ROCK = 0;
	static int PAPER = 1;
	static int SCISSORS = 2;
	static int LIZARD = 3;
	static int SPOCK = 4;
	static char TIE = 'I';
	static char YOU = 'Y';
	static char COMP = 'C';
	static String winner;
	static String rule;

    @ParameterizedTest(name = "user = {0}, computer = {1}, winner is {2}, and rule is {3}")
    @MethodSource("throwList")
    void testThrow(int x, int y, char z, int r) {
    	RpslsModel.determineWinner(x, y, 200);
    	winner = RpslsModel.getWinner();
    	rule = RpslsModel.getRule();
        assertEquals(z, winner.charAt(0), "winner");
        assertEquals(RpslsModel.rules[r], rule, "rule");
//        System.out.printf("%-10s %-10s %-15s %-30s\n",
//        		rpsls[x], rpsls[y], winner, RpslsModel.getRule());
    }

    private static List<Arguments> throwList() { return List.of(
            Arguments.of(ROCK,     ROCK,     TIE, 10),
            Arguments.of(ROCK,     PAPER,    COMP, 2),
            Arguments.of(ROCK,     SCISSORS, YOU, 1),
            Arguments.of(ROCK,     LIZARD,   YOU, 0),
            Arguments.of(ROCK,     SPOCK,    COMP, 9),
            Arguments.of(PAPER,    ROCK,     YOU,  2),
            Arguments.of(PAPER,    PAPER,    TIE,  10),
            Arguments.of(PAPER,    SCISSORS, COMP, 4),
            Arguments.of(PAPER,    LIZARD,   COMP, 6),
            Arguments.of(PAPER,    SPOCK,    YOU , 3),
            Arguments.of(SCISSORS, ROCK,     COMP, 1),
            Arguments.of(SCISSORS, PAPER,    YOU,  4),
            Arguments.of(SCISSORS, SCISSORS, TIE,  10),
            Arguments.of(SCISSORS, LIZARD,   YOU,  5),
            Arguments.of(SCISSORS, SPOCK,    COMP, 8),
            Arguments.of(LIZARD,   ROCK,     COMP, 0),
            Arguments.of(LIZARD,   PAPER,    YOU,  6),
            Arguments.of(LIZARD,   SCISSORS, COMP, 5),
            Arguments.of(LIZARD,   LIZARD,   TIE,  10),
            Arguments.of(LIZARD,   SPOCK,    YOU,  7),
            Arguments.of(SPOCK,    ROCK,     YOU,  9),
            Arguments.of(SPOCK,    PAPER,    COMP, 3),
            Arguments.of(SPOCK,    SCISSORS, YOU,  8),
            Arguments.of(SPOCK,    LIZARD,   COMP, 7),
            Arguments.of(SPOCK,    SPOCK,    TIE,  10));
    }
}
