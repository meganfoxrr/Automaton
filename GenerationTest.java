import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GenerationTest {

	CellState[] states = {CellState.ON, CellState.ON, CellState.OFF};
	Cell thisCell = new Cell(CellState.ON);
	Cell thisCell2 = new Cell(CellState.OFF);
	Cell[] newCells = {thisCell, thisCell2};
	Generation g1 = new Generation(states);
	Generation g2 = new Generation(newCells);
	
	@Test
	void testSize() {
		assertEquals(3, g1.size());
	}

	@Test
	void testGetCell() {
		assertEquals(thisCell, g2.getCell(0));
	}

	@Test
	void testToString() {
		assertEquals("OO.", g1.toString());
	}

}
