
package s6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NumericSquareOne {
	ArrayList<String[]> result_files = new ArrayList<String[]>();
	private int size;
	private String fileName;

	public NumericSquareOne(String file) {
		fileName = file;
		this.loadData(fileName);
		this.showMatrix(this.result_files);
		this.computeSquare(0, 0);
		System.out.println("First solution");
		this.showMatrix(this.result_files);
	}

	private boolean computeSquare(int row, int col) {
		int nextRow;
		int nextCol;

		nextRow = row;
		nextCol = col + 2;

		if (col >= this.result_files.get(0).length - 1) {
			nextRow = row + 2;
			nextCol = 0;
		}

		if (col >= size * 2) {
			if (!checkInd(result_files.get(row))) {
				return false;
			}
		}

		if (row == this.result_files.get(0).length - 1) {
			for (int pos = 0; pos <= (this.size - 1) * 2; pos += 2) {
				if (!checkInd(getColumn(pos))) {
					return false;
				}
			}
			return true;
		}

		if (this.result_files.get(row)[col].equals("?")) {
			for (int possibility = 0; possibility < 10; possibility++) {
				this.result_files.get(row)[col] = possibility + "";
				if (computeSquare(nextRow, nextCol)) {
					return true;
				}
			}
			this.result_files.get(row)[col] = "?";
		} else {
			if (computeSquare(nextRow, nextCol)) {
				return true;
			}
		}
		return false;
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
