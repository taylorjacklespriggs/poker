package poker.game;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;

import poker.input.CardInput;
import poker.input.HandInput;
import poker.input.InputException;
import poker.input.PlayerInput;

public class Game {
	
	private HandInput handInput;
	private PlayerInput playerInput;
	private PrintStream output;
	
	public Game(PlayerInput pin, CardInput cin, PrintStream out) {
		playerInput = pin;
		handInput = new HandInput(cin);
		output = out;
		playerInput.setOutput(out);
		handInput.setOutput(out);
	}
	
	public void start() {
		while(true) {
			mainLoop();
		}
	}
	
	private void mainLoop() {
		output.println("WELCOME TO SIMPLISTIC POKER!");
		try {
			int numPlayers = playerInput.readNumberOfPlayers();
			ArrayList<Player> players = new ArrayList<Player>();
			for(int i = 1; i <= numPlayers; ++i) {
				try {
					Player ply = new Player(i, handInput.readHand());
					players.add(ply);
				} catch (InputException e) {
					output.println(String.format(
							"Player {0} forfeited their turn by inputting an invalid card", i));
				}
			}
			players.sort(new Comparator<Player>() {
				@Override
				public int compare(Player p1, Player p2) {
					return -p1.getHand().compareTo(p2.getHand());
				}
			});
			
		} catch (InputException e) {
			output.println("That was an invalid number of players");
		}
	}

}
