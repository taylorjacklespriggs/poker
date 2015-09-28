package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import poker.game.Player;
import poker.hand.Hand.Strength;
import poker.input.ConsoleInput;
import poker.input.InputException;
import poker.input.PlayerInput;

public class PlayerInputTest {

	@Test
	public void testPlayerInput() throws InputException {
		System.setIn(new ByteArrayInputStream("1 SixSpades TwoDiamonds ThreeHearts FourClubs FiveDiamonds\n".getBytes()));
		PlayerInput pi = new PlayerInput(new ConsoleInput());
		Player pl = pi.readPlayer();
		assertEquals("Player is player1", 1, pl.getID());
		assertEquals("Hand strength is straight", Strength.STRAIGHT, pl.getHand().getStrength());
	}

}
