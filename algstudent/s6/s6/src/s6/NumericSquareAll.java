
package s6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NumericSquareAll {
	ArrayList<String[]> result_files = new ArrayList<String[]>();
	private int size;
	private String fileName;
	int nSolutions = 0;

	public NumericSquareAll(String file) {
		fileName = file;
		this.loadData(fileName);
		this.showMatrix(this.result_files);
		this.computeSquare(this.result_files, 0, 0);
		System.out.println("Number of solutions: " + nSolutions);
	}

	private void computeSquare(ArrayList<String[]> square, int row, int col) {
		int nextRow;
		int nextCol;

		nextRow = row;
		nextCol = col + 1;

		if (col >= square.get(0).length - 1) {
			nextRow = row + 2;
			nextCol = 0;
		}

		if (nextCol >= square.get(0).length - 1) {
			if (!checkInd(square.get(row))) {
				return;
			}
		}

		if (row == square.get(0).length - 1) {
			for (int pos = 0; pos <= (this.size - 1) * 2; pos += 2) {
				if (!checkInd(getColumn(pos))) {
					return;
				}
			}
			nSolutions++;
			System.out.println("Solution number " + nSolutions);
			this.showMatrix(square);
			return;
		}

		if (square.get(row)[col].equals("?")) {
			for (int possibility = 0; possibility < 10; possibility++) {
				square.get(row)[col] = possibility + "";
				computeSquare(square, nextRow, nextCol);
			}
			square.get(row)[col] = "?";
		} else {
			computeSquare(square, nextRow, nextCol);
		}
	}

	private String[] getColumn(int pos) {
		String[] column = new String[this.result_files.size()];

		for (int i = 0; i < this.result_files.size(); i++) {
			if (i % 2 != 0 || i == this.size * 2) {
				column[i] = this.result_files.get(i)[pos / 2];
			} else {
				column[i] = this.result_files.get(i)[pos];
			}
		}

		return column;
	}

	private boolean checkInd(String[] operation) {
		int solution = Integer.parseInt(operation[operation.length - 1]);
		double partial = Double.parseDouble(operation[0]);

		for (int pos = 1; pos < operation.length - 1; pos += 2) {
			int next = Integer.parseInt(operation[pos + 1]);
			if (operation[pos].equals("+")) {
				partial += next;
			} else if (operation[pos].equals("-")) {
				partial -= next;
			}
			if (operation[pos].equals("*")) {
				partial *= next;
			}
			if (operation[pos].equals("/") && next != 0) {
				partial /= next;
			}
		}

		if (partial != solution) {
			return false;
		}
		return true;
	}

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
