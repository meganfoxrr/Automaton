
public class FixedBoundaryConditions implements BoundaryConditions {

	CellState left;
	CellState right;
	
	public FixedBoundaryConditions(CellState left, CellState right) {
		this.left = left;
		this.right = right;
	}
	
	public CellState getLeftState() {
		return left;
	}
	
	public CellState getRightState() {
		return right;
	}
	
	@Override
	public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
		Cell thisCell;
		if (cellIdx + offset < 0) {
			thisCell = new Cell(getLeftState());
			return thisCell;
		}
		else if (cellIdx + offset >= gen.size()) {
			thisCell = new Cell(getRightState());
			return thisCell;
		}
		else {
			thisCell = gen.getCell(cellIdx + offset);
			return thisCell;
		}	
	}
	
}
