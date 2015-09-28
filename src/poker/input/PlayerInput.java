package poker.input;

import poker.card.Card;
import poker.card.Rank;
import poker.card.Suit;
import poker.game.Player;
import poker.hand.Hand;

public class PlayerInput {
	private ConsoleInput input;
	
	public PlayerInput(ConsoleInput in) {
		input = in;
	}
	
	public Player readPlayer() throws InputException {
		try {
			String line = input.readLine();
			String[] strs = line.split(" ");
			assert(strs.length == 6);
			int id = Integer.parseInt(strs[0]);
			Card[] cards = new Card[5];
			for(int i = 0; i < 5; ++i) {
				cards[i] = parseCard(strs[i + 1]);
			}
			return new Player(id, new Hand(
					cards[0], cards[1], cards[2], cards[3], cards[4]));
		} catch (Exception e) {
		}
		throw new InputException();
	}
	
	private Card parseCard(String ser) throws Exception {
		ser = ser.toLowerCase();
		Rank r = parseRank(ser);
		ser = ser.substring(r.niceName().length());
		Suit s = parseSuit(ser);
		return new Card(r, s);
	}
	
	private Rank parseRank(String ser) throws Exception {
		for(Rank r : Rank.values())
			if(ser.startsWith(r.niceName().toLowerCase()))
				return r;
		throw new Exception();
	}
	
	private Suit parseSuit(String ser) throws Exception {
		for(Suit s : Suit.values())
			if(ser.equals(s.niceName().toLowerCase()))
				return s;
		throw new Exception();
	}

}
