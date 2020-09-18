import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AutomatonTest {

	Automaton a;
	Rule rule;
	CellState[] cellStates = {CellState.OFF, CellState.ON, CellState.OFF, CellState.ON, CellState.ON, CellState.OFF};
	Generation g1;
	CircularBoundaryConditions bc;
	
	@Test
	void testGetRule() throws InvalidRuleNumException {
		rule = new TotalisticRule(22);
		g1 = new Generation(cellStates);
		bc = new CircularBoundaryConditions();
		a = new Automaton(rule, g1, bc);
		
		assertEquals(rule, a.getRule());
	}

	@Test
	void testGetGeneration() throws InvalidRuleNumException, InvalidStepNumException {
		rule = new TotalisticRule(22);
		g1 = new Generation(cellStates);
		bc = new CircularBoundaryConditions();
		a = new Automaton(rule, g1, bc);
		
		assertEquals(g1.toString(), a.getGeneration(6).toString());
	}

	@Test
	void testGetBoundaryConditions() throws InvalidRuleNumException {
		rule = new TotalisticRule(22);
		g1 = new Generation(cellStates);
		bc = new CircularBoundaryConditions();
		a = new Automaton(rule, g1, bc);
		BoundaryConditions bc2 = new CircularBoundaryConditions();
		
		assertEquals(bc2.toString(), a.getBoundaryConditions().toString());
	}

	@Test
	void testEvolve() throws InvalidRuleNumException, InvalidStepNumException {
		rule = new TotalisticRule(22);
		g1 = new Generation(cellStates);
		bc = new CircularBoundaryConditions();
		a = new Automaton(rule, g1, bc);
		Generation g1New = rule.evolve(g1, bc);
		a.evolve(1);
		Generation g1NewAuto = a.getGeneration(1);
		
		assertEquals(g1New.toString(), g1NewAuto.toString());
	}

	@Test
	void testGetTotalSteps() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testGetHistory() {
		fail("Not yet implemented");
	}

}
