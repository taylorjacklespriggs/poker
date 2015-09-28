package poker.input.console;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsoleInput {
	private InputStream is;
	private BufferedReader br;
	
	public ConsoleInput() {
		is = System.in;
		br = new BufferedReader(new InputStreamReader(is));
	}
	
	protected String readLine() throws Exception {
		return br.readLine();
	}
	
	protected char readChar() throws Exception {
		return readLine().toLowerCase().charAt(0);
	}
	
	protected int readInt() throws Exception {
		return Integer.parseInt(readLine());
	}
}
