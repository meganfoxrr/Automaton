import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RuleTest {

	TotalisticRule rule;
	
	@Test
	void testGetRuleNum() throws InvalidRuleNumException {
		rule = new TotalisticRule(22);
		assertEquals(22, rule.getRuleNum());
	}

	@Test
	void testEvolveGenerationBoundaryConditions() {
		fail("Not yet implemented");
	}

}
