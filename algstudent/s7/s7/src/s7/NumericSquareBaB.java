package s7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NumericSquareBaB {

	private int size;
	private ArrayList<String[]> board = new ArrayList<String[]>();
	private ArrayList<ArrayList<String[]>> boards = new ArrayList<ArrayList<String[]>>();
	private String fileName;

//	public NumericSquareBaB(String file) {
//		fileName = file;
//		this.loadData(fileName);
//		this.showMatrix(this.result_files);
//		System.out.println("First solution");
//		this.showMatrix(this.result_files);
//	}

	public static void main(String[] args) {
		NumericSquareBaB n = new NumericSquareBaB();
		n.loadData("src/files/test00.txt");
		n.showMatrix();
		n.compute(0, 0);
		System.out.println(n.boards.size());
		System.out.println("Solution: ");
		n.showMatrix();
	}

	private boolean compute(int row, int col) {
		int nextRow = row;
		int nextCol = col + 2;

		if (board.get(row)[col].equals("?")) {
			for (int pos = 0; pos <= 9; pos++) {
				board.get(row)[col] = pos + "";
				ArrayList<String[]> aux = copy(board);
				boards.add(aux);
				// orderPossibilities(row, col);
			}

		} else {
			compute(nextRow, nextCol);
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

//	private void orderPossibilities(int row, int col) {
//		ArrayList<ArrayList<String[]>> aux = new ArrayList<ArrayList<String[]>>();
//		for (int i = 0; i < aux.size(); i++) {
//			if()
//		}
//	}

	private boolean check(int pos, boolean column, ArrayList<String[]> square) {
		return true;
	}

	private void showMatrix() {
		for (int i = 0; i < board.size(); i++) {
			for (int j = 0; j < board.get(i).length; j++) {
				if (this.board.get(i).length != board.get(0).length && j != 0) {
					System.out.print("\t");
				}
				System.out.print(board.get(i)[j] + "\t");
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
