package s6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class NumericSquareOne {
	int size;
	ArrayList<String[]> result_files = new ArrayList<String[]>();
	boolean isSolution = false;
	

	public void main() {
		loadData("src/files/test00.txt");
		showMatrix(this.result_files);
		ArrayList<String[]> possible_solution = computeSquare(this.result_files);
		System.out.println("First solution");
		showMatrix(this.result_files);
	}

	private ArrayList<String[]> computeSquare(ArrayList<String[]> square) {
		int counter = 1;
		for (int i = 0; i < square.size()-1; i+=2) {
			for (int j = 0; j < square.get(i).length; j++) {
				if (square.get(i)[j].equals("?")) {
					square.get(i)[j] = counter + "";
					counter++;
				}
			}
			if(checkInd(square.get(i))) {
				computeSquare(square);
			}
		}
		return square;
	}
	
	private boolean checkInd(String[] operation) {
		int solution = Integer.parseInt(operation[operation.length-1]);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<String> operations = new ArrayList<String>();
		for(int i=0; i<operation.length-2;i++) {
			if (i % 2 == 0) {
				numbers.add(Integer.parseInt(operation[i]));
			} else {
				operations.add(operation[i]);
			}
		}
		
		int partial = numbers.get(0);
		for (int k = 0; k < operations.size(); k++) {
			if(operations.get(k).equals("+")) {
				partial += numbers.get(k+1);
			} else if(operations.get(k).equals("-")) {
				partial -= numbers.get(k+1);
			} else if(operations.get(k).equals("*")) {
				partial *= numbers.get(k+1);
			} else if(operations.get(k).equals("/")) {
				partial /= numbers.get(k+1);
			}
		}
		
		if(partial != solution) {
			return false;
		}
		return true;
	}

	/*private boolean checkSolution() {
		//---- Rows ----\\
		for (int i = 0; i < result_files.size(); i+=2) {
			String[] aux = result_files.get(i);
			int solution = Integer.parseInt(aux[aux.length - 1]);
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			ArrayList<String> operations = new ArrayList<String>();
			for (int j = 0; j < aux.length - 2; j++) {
				if (j % 2 == 0) {
					numbers.add(Integer.parseInt(aux[j]));
				} else {
					operations.add(aux[j]);
				}
			}
			int partial = numbers.get(0);
			for (int k = 0; k < operations.size(); k++) {
				if(operations.get(k).equals("+")) {
					partial += numbers.get(k+1);
				} else if(operations.get(k).equals("-")) {
					partial -= numbers.get(k+1);
				} else if(operations.get(k).equals("*")) {
					partial *= numbers.get(k+1);
				} else if(operations.get(k).equals("/")) {
					partial /= numbers.get(k+1);
				}
			}
			
			if(partial != solution) {
				return false;
			}
		}
		
		//---- Columns ----\\
		for (int i = 0; i < result_files.size(); i+=2) {
			String[] aux = result_files.get(i);
			int solution = Integer.parseInt(aux[aux.length - 1]);
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			ArrayList<String> operations = new ArrayList<String>();
			for (int j = 0; j < aux.length - 2; j++) {
				if (j % 2 == 0) {
					numbers.add(Integer.parseInt(aux[j]));
				} else {
					operations.add(aux[j]);
				}
			}
			int partial = numbers.get(0);
			for (int k = 0; k < operations.size(); k++) {
				if(operations.get(k).equals("+")) {
					partial += numbers.get(k+1);
				} else if(operations.get(k).equals("-")) {
					partial -= numbers.get(k+1);
				} else if(operations.get(k).equals("*")) {
					partial *= numbers.get(k+1);
				} else if(operations.get(k).equals("/")) {
					partial /= numbers.get(k+1);
				}
			}
			
			if(partial != solution) {
				return false;
			}
		}
	}*/

	private void showMatrix(ArrayList<String[]> square) {
		for (int i = 0; i < square.size(); i++) {
			for (int j = 0; j < square.get(i).length; j++) {
				if (square.get(i).length != square.get(0).length && j != 0) {
					System.out.print("\t");
				}
				System.out.print(square.get(i)[j] + "\t");
			}
			System.out.println();
			System.out.println();
		}
	}

	private void loadData(String file) {
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			this.size = Integer.parseInt(reader.readLine());
			while (reader.ready()) {
				String[] parts = reader.readLine().split(" ");
				result_files.add(parts);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
