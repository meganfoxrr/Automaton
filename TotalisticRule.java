
public class TotalisticRule extends Rule {
	
	private int ruleNum;
	private final int NUM_SUBRULES = 6;
	private final int OFFSET_2_LEFT = -2;
	private final int OFFSET_1_LEFT = -1;
	private final int OFFSET_MIDDLE = 0;
	private final int OFFSET_1_RIGHT = 1;
	private final int OFFSET_2_RIGHT = 2;
	private final int NUM_NEIGHBORS = 5;
	private final int RULE_0 = 0;
	private final int RULE_1 = 1;
	private final int RULE_2 = 2;
	private final int RULE_3 = 3;
	private final int RULE_4 = 4;
	private final int RULE_5 = 5;


	public TotalisticRule(int ruleNum) throws InvalidRuleNumException {
		super(ruleNum);
		if (ruleNum < 0 || ruleNum > 63) {
			throw new InvalidRuleNumException();
		}
		this.ruleNum = ruleNum;
	}
	
	public int getNumSubrules() {
		return NUM_SUBRULES;
	}
	
	public Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc) {
		Cell[] neighborhood = new Cell[NUM_NEIGHBORS];
		neighborhood[0] = bc.getNeighbor(cellIdx, OFFSET_2_LEFT, gen);
		neighborhood[1] = bc.getNeighbor(cellIdx, OFFSET_1_LEFT, gen);
		neighborhood[2] = bc.getNeighbor(cellIdx, OFFSET_MIDDLE, gen);
		neighborhood[3] = bc.getNeighbor(cellIdx, OFFSET_1_RIGHT, gen);
		neighborhood[4] = bc.getNeighbor(cellIdx, OFFSET_2_RIGHT, gen);
		return neighborhood;
	}
	
	
	@Override
	public String toString() {
		
		Cell[] ruleCells = getRuleCells();
		String line1 = Integer.toString(RULE_5) +" "+ Integer.toString(RULE_4) +" "+ 
		Integer.toString(RULE_3) +" "+ Integer.toString(RULE_2) +" " + Integer.toString(RULE_1) + " " + Integer.toString(RULE_0);  
		String line2 = ruleCells[0].toString();
		for (int i = 1; i < 6; i++) {
			line2 = line2 + " " + ruleCells[i];
		}
		
		return (line1 + "\n" + line2);
	}
	
	
	
	public Cell[] getRuleCells() {
		//Converting int rule number into a binary string with padded zeros
		String ruleNumString = Integer.toBinaryString(ruleNum);	
		
		String numZeros = "";
		int difference = NUM_SUBRULES - (ruleNumString.length());
		for (int i = 0; i < difference; i++) {
			numZeros = numZeros + "0";
		}
		
		ruleNumString = numZeros + ruleNumString;
		char[] charString = ruleNumString.toCharArray();
		Cell[] ruleCells = new Cell[charString.length];
		
		//Converts from 0 and 1's to ON and OFF
		for (int i = 0; i < charString.length; i++) {
			if (charString[i] == '0') {
				ruleCells[i] = new Cell(CellState.OFF);
			}
			else {
				ruleCells[i] = new Cell(CellState.ON);
			}
		}
		
		return ruleCells;
	}
	
	
	

	@Override
	public EvolvedCell evolve(Cell[] neighborhood) {
		
		Cell[] ruleCells = getRuleCells();
		EvolvedCell evolvedCell;
		int numOn = 0;
		for (int i = 0; i < neighborhood.length; i++) {
			if (neighborhood[i].getState() == CellState.ON) {
				numOn++;
			}
		}
		
		if (numOn == RULE_5) {
			evolvedCell = new EvolvedCell(ruleCells[0].getState(), RULE_5);
		}
		else if (numOn == RULE_4) {
			evolvedCell = new EvolvedCell(ruleCells[1].getState(), RULE_4);
		}
		else if (numOn == RULE_3) {
			evolvedCell = new EvolvedCell(ruleCells[2].getState(), RULE_3);
		}
		else if (numOn == RULE_2) {
			evolvedCell = new EvolvedCell(ruleCells[3].getState(), RULE_2);
		}
		else if (numOn == RULE_1) {
			evolvedCell = new EvolvedCell(ruleCells[4].getState(), RULE_1);
		}
		else {
			evolvedCell = new EvolvedCell(ruleCells[5].getState(), RULE_0);
		}
		
		return evolvedCell;
	}
	
}