import java.util.ArrayList;
import java.util.List;

public class Automaton {
	
	private Rule rule;
	private List<Generation> generations = new ArrayList<Generation>();
	private BoundaryConditions bc;
	private int numSteps = 0;
	
	public Automaton(Rule rule, Generation init, BoundaryConditions bc) {
		this.rule = rule;
		generations.add(init);
		this.bc = bc;
	}
	
	public Rule getRule() {
		return rule;
	}
	
	public Generation getGeneration(int stepNum) throws InvalidStepNumException, InvalidRuleNumException {
		if (stepNum < 0) {
			throw new InvalidStepNumException();
		}
		if (stepNum == 0) {
			return generations.get(0);
		}
		if (numSteps < stepNum) {
			int diff = stepNum-numSteps;
			evolve(diff);
		}
		return generations.get(stepNum);
	}
	
	public BoundaryConditions getBoundaryConditions() {
		return bc;
	}
	
	public void evolve(int numSteps) throws InvalidStepNumException {
		Generation thisGen;
		int size = generations.size();
		if (numSteps < 0) {
			throw new InvalidStepNumException();
		}
		if (numSteps == 0) {
			this.numSteps = this.numSteps;
		}
		for (int i = 0; i < numSteps; i++) {
			thisGen = rule.evolve(generations.get(size+i-1), bc);
			generations.add(thisGen);
		}
		this.numSteps += numSteps;
	}
	
	public int getTotalSteps() {
		return numSteps;
	}
	
	@Override
	public String toString() {
		return (generations.get(generations.size()-1) ).toString();
	}
	
	public String getHistory() {
		String history = generations.get(0).toString();
		for (int i = 1; i < generations.size(); i++) {
			history = history + "\n" + generations.get(i).toString() ;
		}
		return history.trim();
	}

}
