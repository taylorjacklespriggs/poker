package poker.game;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

import poker.hand.Hand;
import poker.input.ConsoleInput;
import poker.input.InputException;
import poker.input.PlayerInput;

public class Game {
	private static final int MIN_PLAYERS = 2;
	private static final int MAX_PLAYERS = 4;
	
	private ConsoleInput input;
	private PlayerInput playerInput;
	private PrintStream output;
	
	public Game() {
		input = new ConsoleInput();
		playerInput = new PlayerInput(input);
		output = System.out;
	}
	
	public void start() {
		while(true) {
			mainLoop();
		}
	}
	
	private void mainLoop() {
		output.println("WELCOME TO SIMPLISTIC POKER!");
		try {
			output.print("Enter the number of players: ");
			int numPlayers = input.readInt();
			if(numPlayers < MIN_PLAYERS || numPlayers > MAX_PLAYERS)
				throw new InputException();
			HashSet<Integer> left = new HashSet<Integer>();
			for(int i = 1; i <= numPlayers; ++i)
				left.add(i);
			ArrayList<Player> players = new ArrayList<Player>();
			while(!left.isEmpty()) {
				try {
					output.print("Enter a player and hand: ");
					Player ply = playerInput.readPlayer();
					int id = ply.getID();
					if(left.contains(id)) {
						left.remove(id);
						players.add(ply);
					} else {
						throw new InputException();
					}
				} catch(InputException ie) {
					output.println("The player entered was invalid");
				}
			}
			players.sort(new Comparator<Player>() {
				@Override
				public int compare(Player p1, Player p2) {
					return -p1.getHand().compareTo(p2.getHand());
				}
			});
			Hand prev = null;
			int rank = 0;
			for(Player ply: players) {
				Hand hand = ply.getHand();
				if(prev == null || prev.compareTo(hand) != 0) {
					++rank;
					prev = hand;
				}
				printPlayer(ply, rank);
			}
		} catch (InputException e) {
			output.println("That was an invalid number of players");
		}
	}

	private void printPlayer(Player ply, int rank) {
		output.println(String.format(
				"RANK: %d, PLAYER: %d, HAND: %s",
				rank, ply.getID(), ply.getHand().toString()));
	}

}
