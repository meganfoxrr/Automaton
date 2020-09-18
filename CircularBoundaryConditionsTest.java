import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CircularBoundaryConditionsTest {

	CellState[] cellStates = {CellState.OFF, CellState.ON, CellState.ON, CellState.OFF, CellState.OFF};
	CellState[] cellStates2 = {CellState.OFF};
	Generation g1 = new Generation(cellStates);
	Generation g2 = new Generation(cellStates2);
	CircularBoundaryConditions cbc = new CircularBoundaryConditions();
	
	@Test
	void testGetNeighbor() {
		Cell neighbor = cbc.getNeighbor(0, -3, g2);
		Cell realNeighbor = g2.getCell(0);
		
		assertEquals(realNeighbor, neighbor);
	}

}
