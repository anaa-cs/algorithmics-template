package s7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class NumericSquareBaB {

	private int size;
	private ArrayList<String[]> board = new ArrayList<String[]>();
	private ArrayList<ArrayList<String[]>> boards = new ArrayList<ArrayList<String[]>>();
	private int steps;

	public NumericSquareBaB(String fileName) {
		steps = 1;
		loadData(fileName);
		compute(0, 0, this.board);
		showMatrix(boards.get(0));
		System.out.println("Nodes developed: " + steps);
		System.out.println();
	}

	private boolean compute(int row, int col, ArrayList<String[]> board) {
		int nextRow = row;
		int nextCol = col + 2;

		if (col >= board.get(0).length - 1) {
			nextRow = row + 2;
			nextCol = 0;
		}

		if (row >= size * 2) {
			return true;
		}

		if (board.get(row)[col].equals("?")) {
			for (int pos = 0; pos <= 9; pos++) {
				steps++;
				board.get(row)[col] = pos + "";
				ArrayList<String[]> aux = copy(board);
				boards.add(aux);
			}

			orderPossibilities(row, col);

			for (int i = 0; i < boards.size(); i++) {
				if (compute(nextRow, nextCol, boards.get(i))) {
					return true;
				}
			}

		} else {
			if (compute(nextRow, nextCol, board)) {
				return true;
			}
		}

		return false;
	}

	private ArrayList<String[]> copy(ArrayList<String[]> aux) {
		ArrayList<String[]> result = new ArrayList<String[]>();

		for (int row = 0; row < aux.size(); row++) {
			String[] r = new String[aux.get(row).length];
			for (int col = 0; col < r.length; col++) {
				r[col] = aux.get(row)[col];
			}
			result.add(r);
		}

		return result;
	}

	private void orderPossibilities(int row, int col) {
		int pos = 0;
		for (int i = 0; i < boards.size(); i++) {
			if (checkInd(boards.get(i).get(row)) || checkInd(getColumn(col, boards.get(i)))) {
				Collections.swap(boards, i, pos);
				pos++;
			}
		}
	}

	private String[] getColumn(int pos, ArrayList<String[]> square) {
		String[] column = new String[square.size()];

		for (int i = 0; i < square.size(); i++) {
			if (i % 2 != 0 || i == this.size * 2) {
				column[i] = square.get(i)[pos / 2];
			} else {
				column[i] = square.get(i)[pos];
			}
		}

		return column;
	}

	private boolean checkInd(String[] operation) {
		int solution = Integer.parseInt(operation[operation.length - 1]);
		double partial;
		try {
			partial = Double.parseDouble(operation[0]);
		} catch (NumberFormatException e) {
			return false;
		}

		for (int pos = 1; pos < operation.length - 1; pos += 2) {
			int next;
			try {
				next = Integer.parseInt(operation[pos + 1]);
			} catch (NumberFormatException e) {
				return false;
			}
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

	private void showMatrix(ArrayList<String[]> arrayList) {
		for (int i = 0; i < arrayList.size(); i++) {
			for (int j = 0; j < arrayList.get(i).length; j++) {
				if (arrayList.get(i).length != arrayList.get(0).length && j != 0) {
					System.out.print("\t");
				}
				System.out.print(arrayList.get(i)[j] + "\t");
			}
			System.out.println();
			System.out.println();
		}
	}

	private void loadData(String file) {
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			size = Integer.parseInt(reader.readLine());
			while (reader.ready()) {
				String[] parts = reader.readLine().split(" ");
				board.add(parts);
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
