import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CellTest {

	@Test
	void testGetState() {
		Cell testCell = new Cell(CellState.ON);
		assertEquals(testCell.getState(), CellState.ON);
	}

	@Test
	void testToString() {
		Cell testCell = new Cell(CellState.OFF);
		assertEquals(testCell.toString(), ".");
	}

}
