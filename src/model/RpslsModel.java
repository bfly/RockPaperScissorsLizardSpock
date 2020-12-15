package model;

public class RpslsModel {
	public static final String[] rules = new String[] {
		"Rock crushes lizard.",   "Rock smashes scissors",
		"Paper covers rock.",     "Paper disproves Spock",
		"Scissors cuts paper.",   "Scissors decapitates lizard",
		"Lizard eats paper",      "Lizard poisons Spock.",
		"Spock smashes scissors", "Spock vaporizes rock", ""
	};
	private static final String[] winners = new String[] {
		"It's a tie.", "You win!", "Computer wins"};
	private static final Result[][] table = new Result[][] {
		// Rows are user, Columns are computer
		// Rock						  Paper							Scissors				    Lizard						 Spock
		{ new Result(0,10), new Result(2,2),  new Result(1,1),  new Result(1,0),  new Result(2,9) },   // Rock
		{ new Result(1,2),  new Result(0,10), new Result(2,4),  new Result(2,6),  new Result(1,3) },   // Paper
		{ new Result(2,1),  new Result(1,4),  new Result(0,10), new Result(1,5),  new Result(2,8) },   // Scissors
		{ new Result(2,0),  new Result(1,6),  new Result(2,5),  new Result(0,10), new Result(1,7) },   // Lizard
		{ new Result(1,9),  new Result(2,3),  new Result(1,8),  new Result(2,7),  new Result(0,10) }   // Spock
	};
	final static String NL = "\n\n";
	private static String winner, rule;

	public static String determineWinner(int user, int comp, int width) {
		Result result = table[user][comp];
		winner = winners[result.winner];
		rule   = rules[result.rule];

		return center(winner, width) + NL + center(rule, width);
	}
	
	public static String center (String s, int width) {

	    int padSize = width - s.length();
	    int padStart = s.length() + padSize / 2;

	    s = String.format("%" + padStart + "s", s);
	    s = String.format("%-" + width  + "s", s);

	    return s;
	}
	
	public static String getWinner() {
		return winner;
	}
	
	public static String getRule() {
		return rule;
	}

	private static class Result {
		int winner;
		int rule;

		public Result( int winner, int rule ) {
			this.winner = winner;
			this.rule = rule;
		}
	}
}
