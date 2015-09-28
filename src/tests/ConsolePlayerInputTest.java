package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import poker.input.InputException;
import poker.input.PlayerInput;
import poker.input.console.ConsolePlayerInput;

public class ConsolePlayerInputTest {

	@Test(expected=InputException.class)
	public void testPlayerInput() throws InputException {
		System.setIn(new ByteArrayInputStream("2\n3\n4\n5\n".getBytes()));
		PlayerInput pi = new ConsolePlayerInput();
		pi.setOutput(System.out);
		assertEquals("The first number is 2", 2, pi.readNumberOfPlayers());
		assertEquals("The second number is 3", 3, pi.readNumberOfPlayers());
		assertEquals("The third number is 4", 4, pi.readNumberOfPlayers());
		pi.readNumberOfPlayers();
	}

}
