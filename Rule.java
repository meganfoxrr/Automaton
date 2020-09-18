
public abstract class Rule {

	private int ruleNum;

	
	protected Rule(int ruleNum) {
		this.ruleNum = ruleNum;
	}
	
	public int getRuleNum() {
		return ruleNum;
	}
	
	public Generation evolve(Generation gen, BoundaryConditions bc) {
		Cell[] cells = new Cell[gen.size()];
		for (int i = 0; i < cells.length; i++) {
			Cell[] neighborhood = getNeighborhood(i, gen, bc);
			EvolvedCell thisCell = evolve(neighborhood);
			cells[i] = thisCell;
		}
		Generation thisGen = new Generation(cells);
		return thisGen;
	}
	
	public abstract int getNumSubrules();
	
	public abstract Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc);
	
	public abstract EvolvedCell evolve(Cell[] neighborhood);
	
	@Override
	public abstract String toString();
	
}
