package poker.input.console;

import java.io.PrintStream;

import poker.input.InputException;
import poker.input.PlayerInput;

public class ConsolePlayerInput extends ConsoleInput implements PlayerInput {
	private static final int MIN_PLAYERS = 2;
	private static final int MAX_PLAYERS = 4;
	
	private PrintStream output;

	@Override
	public int readNumberOfPlayers() throws InputException {
		try {
			output.print("Please input the number of players: ");
			int num = readInt();
			if(num >= MIN_PLAYERS && num <= MAX_PLAYERS)
				return num;
		} catch(Exception e) {
		}
		throw new InputException();
	}

	@Override
	public void setOutput(PrintStream ps) {
		output = ps;
	}
}
