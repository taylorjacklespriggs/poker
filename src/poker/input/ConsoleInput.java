package poker.input;

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
	
	public String readLine() throws InputException {
		try {
			return br.readLine();
		} catch(Exception e) {
		}
		throw new InputException();
	}
	
	public int readInt() throws InputException {
		try {
			return Integer.parseInt(readLine());
		} catch(Exception e) {
		}
		throw new InputException();
	}
}
