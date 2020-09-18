import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EvolvedCellTest {
	
	EvolvedCell evolvedCell = new EvolvedCell(CellState.ON, 7);

	@Test
	void testGetSubruleNum() {
		assertEquals(7, evolvedCell.getSubruleNum());
	}

}
