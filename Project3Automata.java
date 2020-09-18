import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Project3Automata {

	public static void main(String[] args) throws InvalidStepNumException, InvalidRuleNumException, IOException {
		
		// Creating the automata
		Cell[] cells1 = new Cell[101];
		
		CircularBoundaryConditions cbc = new CircularBoundaryConditions();
		FixedBoundaryConditions fbc = new FixedBoundaryConditions(CellState.OFF, CellState.OFF);
		
		ElementaryRule rule = new ElementaryRule(118);
		
		for (int i = 0; i < 101; i++) {
			if (i == 50) {
				cells1[i] = new Cell(CellState.ON);
			}
			else {
				cells1[i] = new Cell(CellState.OFF);
			}
		}

		Generation g1 = new Generation(cells1);
		Automaton a1 = new Automaton(rule, g1, cbc);
		Automaton a2 = new Automaton(rule, g1, fbc);
		
		a1.evolve(100);
		a2.evolve(100);
		
		
		// Creating files
		File file1 = new File("elementary118-100steps-circularbc.txt");
		FileWriter writer1 = new FileWriter(file1);
		File file2 = new File("elementary118-100steps-fixedbc-off-off.txt");
		FileWriter writer2 = new FileWriter(file2);
		writer1.write(a1.getHistory());
		writer2.write(a2.getHistory());
		
		File file3 = new File("hamming-elementary118-circularbc.txt");
		FileWriter writer3 = new FileWriter(file3);
		File file4 = new File("hamming-elementary118-fixedbc-off-off.txt");
		FileWriter writer4 = new FileWriter(file4);
		int[] hammingDistances1 = AutomatonMeasurements.hammingDistances(a1);
		int[] hammingDistances2 = AutomatonMeasurements.hammingDistances(a2);
		writer3.write(hammingDistances1[0]);
		writer4.write(hammingDistances2[0]);
		for (int i = 1; i < hammingDistances1.length; i++) {
			writer3.write("\n" + hammingDistances1[i]);
			writer4.write("\n" + hammingDistances2[i]);
		}
		
		
		
		File file5 = new File("subrules-elementary118-circularbc.csv");
		FileWriter writer5 = new FileWriter(file5);
		int[][] subruleCounts = AutomatonMeasurements.subruleCounts(a1);
				
		for (int i = 0; i < subruleCounts.length; i++) {
			writer5.write(Integer.toString(subruleCounts[i][0]));
			for (int k = 1; k < subruleCounts[i].length; k++) {
				writer5.write("," + Integer.toString(subruleCounts[i][k]));
			}
			writer5.write("\n");
		}
		
		
		
		writer1.flush();
		writer1.close();
		writer2.flush();
		writer2.close();
		writer3.flush();
		writer3.close();
		writer4.flush();
		writer4.close();
		writer5.flush();
		writer5.close();
		
		
		
		
		
		
		
	}
}
