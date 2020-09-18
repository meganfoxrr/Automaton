
public class CircularBoundaryConditions implements BoundaryConditions {

	public CircularBoundaryConditions() {
	}	
	
	@Override
	public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
		int wantedIdx = cellIdx + offset;
		return gen.getCell( ((wantedIdx%gen.size()) + gen.size()) % gen.size() );
	}
	
}

