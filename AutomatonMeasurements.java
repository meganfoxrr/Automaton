
public class AutomatonMeasurements {

	public static int hammingDistance(Generation g1, Generation g2) {
		int hammingDist = 0;
		if (g1.size() != g2.size()) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < g1.size(); i++) {
			if (g1.getCell(i).getState() != g2.getCell(i).getState()) {
				hammingDist++;
			}
		}
		return hammingDist;
	}
	
	
	public static int hammingDistance(int stepNum, Automaton a) throws InvalidStepNumException, InvalidRuleNumException {
		if (stepNum < 1) {
			throw new InvalidStepNumException();
		}
		
		Generation g1 = a.getGeneration(stepNum-1);
		Generation g2 = a.getGeneration(stepNum);
		
		return hammingDistance(g1,g2);
	
	}
	
	
	public static int[] hammingDistances(Automaton a) throws InvalidStepNumException, InvalidRuleNumException {
		int[] hammingDistances = new int[a.getTotalSteps()];
		for (int i = 0; i < a.getTotalSteps(); i++) {
			hammingDistances[i] = (hammingDistance(i+1, a));
		}
		return hammingDistances;
	}
	
	
	
	
	public static int[] subruleCount(int stepNum, Automaton a) throws InvalidStepNumException, InvalidRuleNumException {
		
		if (stepNum < 1) {
			throw new InvalidStepNumException();
		}
		
		int[] subruleCount = new int[a.getRule().getNumSubrules()];
		
		for (int i = 0; i < subruleCount.length; i++) {
			int counter = 0;
			for (int j = 0; j < a.getGeneration(stepNum).size(); j++) {
				EvolvedCell thisCell = (EvolvedCell) a.getGeneration(stepNum).getCell(j);
				if (thisCell.getSubruleNum() == i) {
					counter++;
				}
			}
			subruleCount[i] = counter;
		}

		return subruleCount;
	}
	
	
	
	public static int[][] subruleCounts(Automaton a) throws InvalidStepNumException, InvalidRuleNumException {
		
		int[][] subruleCounts = new int[a.getTotalSteps()][a.getRule().getNumSubrules()];
		int[] rules = new int[subruleCounts[0].length];
		
		for (int i = 0; i < subruleCounts.length; i++) {
			
			rules = subruleCount(i+1, a);
			
			for (int j = 0; j < subruleCounts[i].length; j++) {
				subruleCounts[i][j] = rules[j];
			}
			
		}
		
		return subruleCounts;
	}
	
	
	
}
