
public class ElementaryRule extends Rule {

	private int ruleNum;
	private final int NUM_SUBRULES = 8;
	private final int NUM_CELLS = 3;
	private final int OFFSET_LEFT = -1;
	private final int OFFSET_MIDDLE = 0;
	private final int OFFSET_RIGHT = 1;
	private final int RULE_LENGTH = 8;
	private final int SUBRULE0 = 0;
	private final int SUBRULE1 = 1;
	private final int SUBRULE2 = 2;
	private final int SUBRULE3 = 3;
	private final int SUBRULE4 = 4;
	private final int SUBRULE5 = 5;
	private final int SUBRULE6 = 6;
	private final int SUBRULE7 = 7;
	
	public ElementaryRule(int ruleNum) throws InvalidRuleNumException {
		super(ruleNum);
		if (ruleNum < 0 || ruleNum > 255) {
			throw new InvalidRuleNumException();
		}
		this.ruleNum = ruleNum;
	}
	
	public int getNumSubrules() {
		return NUM_SUBRULES;
	}
	
	public Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc) {
		Cell[] cells = new Cell[NUM_CELLS];
		cells[0] = bc.getNeighbor(cellIdx, OFFSET_LEFT, gen);
		cells[1] = bc.getNeighbor(cellIdx, OFFSET_MIDDLE, gen);
		cells[2] = bc.getNeighbor(cellIdx, OFFSET_RIGHT, gen);
		return cells;
	}
	
	public int getRule() {
		return this.ruleNum;
	}
	
	
	public Cell[] getRuleCells() {
		//Converting int rule number into a binary string with padded zeros
		String ruleNumString = Integer.toBinaryString(ruleNum);	
		
		String numZeros = "";
		int difference = RULE_LENGTH - (ruleNumString.length());
		for (int i = 0; i < difference; i++) {
			numZeros = numZeros + "0";
		}
		
		String finalString = numZeros + ruleNumString;
		char[] charString = finalString.toCharArray();
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
	
	
	public EvolvedCell evolve(Cell[] neighborhood) {
		
		Cell[] ruleCells = getRuleCells();
		
		EvolvedCell evolvedCell;
		if (neighborhood[0].getState() == CellState.ON) {
			if (neighborhood[1].getState() == CellState.ON) {
				if (neighborhood[2].getState() == CellState.ON) {
					evolvedCell = new EvolvedCell(ruleCells[0].getState(), SUBRULE7);
				}
				else {
					evolvedCell = new EvolvedCell(ruleCells[1].getState(), SUBRULE6);
				}
			}
			else {
				if (neighborhood[2].getState() == CellState.ON) {
					evolvedCell = new EvolvedCell(ruleCells[2].getState(), SUBRULE5);
				}
				else {
					evolvedCell = new EvolvedCell(ruleCells[3].getState(), SUBRULE4);
				}
			}
		}
		else {
			if (neighborhood[1].getState() == CellState.ON) {
				if (neighborhood[2].getState() == CellState.ON) {
					evolvedCell = new EvolvedCell(ruleCells[4].getState(), SUBRULE3);
				}
				else {
					evolvedCell = new EvolvedCell(ruleCells[5].getState(), SUBRULE2);
				}
			}
			else {
				if (neighborhood[2].getState() == CellState.ON) {
					evolvedCell = new EvolvedCell(ruleCells[6].getState(), SUBRULE1);
				}
				else {
					evolvedCell = new EvolvedCell(ruleCells[7].getState(), SUBRULE0);
				}
			}
		}
		
		return evolvedCell;
		
	}
	
	@Override
	public String toString() {
		String str1 = CellState.ON.toString() + CellState.ON.toString() + CellState.ON.toString();
		String str2 = CellState.ON.toString() + CellState.ON.toString() + CellState.OFF.toString();
		String str3 = CellState.ON.toString() + CellState.OFF.toString() + CellState.ON.toString();
		String str4 = CellState.ON.toString() + CellState.OFF.toString() + CellState.OFF.toString();
		String str5 = CellState.OFF.toString() + CellState.ON.toString() + CellState.ON.toString();
		String str6 = CellState.OFF.toString() + CellState.ON.toString() + CellState.OFF.toString();
		String str7 = CellState.OFF.toString() + CellState.OFF.toString() + CellState.ON.toString();
		String str8 = CellState.OFF.toString() + CellState.OFF.toString() + CellState.OFF.toString();
		
		String line1 = str1 + " " + str2 + " " + str3 + " " + str4 + " " + str5 + " " + str6 + " " + str7 + " " + str8;
		Cell[] ruleCells = getRuleCells();
		String line2 = " " + ruleCells[0].toString();
		for (int i = 1; i < ruleCells.length; i++) {
			line2 = line2 + "   " + ruleCells[i].toString();
		}
		line2 = line2 + " ";

		return (line1 + "\n" + line2);
	}
	
	
}
