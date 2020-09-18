import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ElementaryRuleTest {

	ElementaryRule rule;
	CircularBoundaryConditions bc;
	CellState[] cellStates = {CellState.OFF, CellState.ON, CellState.ON, CellState.OFF};
	Generation g1;
	
	@Test
	void testGetNumSubrules() throws InvalidRuleNumException {
		rule = new ElementaryRule(30);
	}

	@Test
	void testGetNeighborhood() throws InvalidRuleNumException {
		rule = new ElementaryRule(30);
		bc = new CircularBoundaryConditions();
		g1 =  new Generation(cellStates);
		Cell[] neighborhood = new Cell[3];
		neighborhood = rule.getNeighborhood(0, g1, bc);
		Cell[] realNeighborhood = {g1.getCell(3), g1.getCell(0), g1.getCell(1)};
		for (int i = 0; i < 3; i++) {
			assertEquals(realNeighborhood[i].getState(), neighborhood[i].getState());
		}
	}

	@Test
	void testEvolveCellArray() throws InvalidRuleNumException {
		rule = new ElementaryRule(30);
		bc = new CircularBoundaryConditions();
		g1 =  new Generation(cellStates);
		Cell[] neighborhood = {g1.getCell(2), g1.getCell(3), g1.getCell(0)};
		EvolvedCell evolvedCell = rule.evolve(neighborhood);
		Cell realEvolvedCell = new Cell(CellState.ON);
		
		assertEquals(realEvolvedCell.getState(), evolvedCell.getState());
	}

	@Test
	void testToString() throws InvalidRuleNumException {
		rule = new ElementaryRule(30);
		String realString = "OOO OO. O.O O.. .OO .O. ..O ..." + "\n" + " .   .   .   O   O   O   O   . ";
		String string = rule.toString();
		assertEquals(realString, string);
	}
	
	@Test
	void testgetRule() throws InvalidRuleNumException {
		rule = new ElementaryRule(110);
		assertEquals(110, rule.getRule());
	}
	

	@Test
	void testGetRuleCells() throws InvalidRuleNumException {
		rule = new ElementaryRule(110);
		CellState[] states2 = {CellState.OFF, CellState.ON, CellState.ON, CellState.OFF, CellState.ON, CellState.ON, CellState.ON, CellState.OFF};
		g1 = new Generation(states2);
		Cell[] theseCells = new Cell[8];
		for (int i = 0; i < theseCells.length; i++) {
			theseCells[i] = new Cell(states2[i]);
		}
		
		Cell[] ruleCells = rule.getRuleCells();
		
		assertEquals(theseCells[0].getState(), ruleCells[0].getState());
		assertEquals(theseCells[1].getState(), ruleCells[1].getState());
		assertEquals(theseCells[2].getState(), ruleCells[2].getState());
	}

}
