import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CellStateTest {

	CellState thisStateON = CellState.ON;
	CellState thisStateOFF = CellState.OFF;
	
	@Test
	void testGetState() {
		assertEquals(CellState.ON, thisStateON.getState('O'));
		assertEquals(CellState.OFF, thisStateOFF.getState('.'));
	}

	@Test
	void testToString() {
		assertEquals("O", thisStateON.toString());
		assertEquals(".", thisStateOFF.toString());
	}

}
