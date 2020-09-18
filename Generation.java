
public class Generation {

	private Cell[] cells;
	
	public Generation(CellState[] states) {
		cells = new Cell[states.length];
		for (int i = 0; i < states.length; i++) {
			Cell thisCell = new Cell(states[i]);
			cells[i] = thisCell;
		}
	}
	
	public Generation(String states) {
		char[] stateChars = states.toCharArray();
		cells = new Cell[stateChars.length];
		for (int i = 0; i < stateChars.length; i++) {
			Cell thisCell;
			char c = stateChars[i];
			if (CellState.getState(c) == CellState.ON) {
				thisCell = new Cell(CellState.ON);
				cells[i] = thisCell;
			}
			else if (CellState.getState(c) == CellState.OFF) {
				thisCell = new Cell(CellState.OFF);
				cells[i] = thisCell;
			}
			else {
				throw new IllegalArgumentException();
			}
		}
	}

	public Generation(Cell[] cells) {
		this.cells = new Cell[cells.length];
		Cell[] newCells = new Cell[cells.length];
		for (int i = 0; i < cells.length; i++) {
			newCells[i] = cells[i];
		}
		for (int i = 0; i < cells.length; i++) {
			this.cells[i] = newCells[i];
		}
	}
	
	public int size() {
		return cells.length;
	}
	
	public Cell getCell(int idx) {
		return cells[idx];
	}
	
	@Override
	public String toString() {
		String cellString = "";
		for (int i = 0; i < cells.length; i++) {
			cellString = cellString + cells[i].toString();
		}
		return cellString;
	}
	
}
