package poker.input;

import java.io.PrintStream;

public interface PlayerInput {
	
	public int readNumberOfPlayers() throws InputException;
	
	public void setOutput(PrintStream ps);

}
