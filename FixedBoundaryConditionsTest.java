import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FixedBoundaryConditionsTest {

	CellState left = CellState.OFF;
	CellState right = CellState.ON;
	FixedBoundaryConditions fbc = new FixedBoundaryConditions(left, right);
	
	CellState[] cellStates = {CellState.OFF, CellState.ON, CellState.ON, CellState.OFF};
	Generation g1 = new Generation(cellStates);
	
	@Test
	void testGetLeftState() {
		assertEquals(left, fbc.getLeftState());
	}

	@Test
	void testGetRightState() {
		assertEquals(right, fbc.getRightState());
	}

	@Test
	void testGetNeighbor() {
		Cell neighbor1 = fbc.getNeighbor(0, -2, g1);
		Cell realNeighbor1 = new Cell(fbc.getLeftState());
		
		Cell neighbor2 = fbc.getNeighbor(2, 8, g1);
		Cell realNeighbor2 = new Cell(fbc.getRightState());
		
		Cell neighbor3 = fbc.getNeighbor(0, 1, g1);
		Cell realNeighbor3 = g1.getCell(1);
		
		assertEquals(realNeighbor3.getState(), neighbor3.getState());
		assertEquals(realNeighbor1.getState(), neighbor1.getState());
		assertEquals(realNeighbor2.getState(), neighbor2.getState());
	}

}
