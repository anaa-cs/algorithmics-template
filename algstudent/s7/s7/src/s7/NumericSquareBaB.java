package s7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NumericSquareBaB {

	private int size;
	private ArrayList<String[]> result_files = new ArrayList<String[]>();
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
		n.compute();
		System.out.println("Solution: ");
		n.showMatrix();
	}

	private boolean compute() {
		return false;
	}

	private void showMatrix() {
		for (int i = 0; i < this.result_files.size(); i++) {
			for (int j = 0; j < this.result_files.get(i).length; j++) {
				if (this.result_files.get(i).length != this.result_files.get(0).length && j != 0) {
					System.out.print("\t");
				}
				System.out.print(this.result_files.get(i)[j] + "\t");
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
