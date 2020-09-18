import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TotalisticRuleTest {
	
	TotalisticRule rule;
	CircularBoundaryConditions bc;
	CellState[] cellStates = {CellState.OFF, CellState.ON, CellState.OFF, CellState.ON, CellState.ON, CellState.OFF};
	Generation g1;
	
	@Test
	void testGetNumSubrules() throws InvalidRuleNumException {
		rule = new TotalisticRule(7);
		assertEquals(6, rule.getNumSubrules());
	}

	@Test
	void testGetNeighborhood() throws InvalidRuleNumException {
		rule = new TotalisticRule(30);
		bc = new CircularBoundaryConditions();
		g1 =  new Generation(cellStates);
		Cell[] neighborhood = new Cell[5];
		
		neighborhood = rule.getNeighborhood(0, g1, bc);
		Cell[] realNeighborhood = {};
		for (int i = 0; i < 5; i++) {
			assertEquals(realNeighborhood[i].getState(), neighborhood[i].getState());
		}
	}

	@Test
	void testEvolveCellArray() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testGetRuleCells() {
		fail("Not yet implemented");
	}

}
