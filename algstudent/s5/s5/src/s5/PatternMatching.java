package s5;

public class PatternMatching {
	private String text;
	private boolean[][] matching;
	private String pattern;

	public PatternMatching(String text) {
		this.text = text;
	}

	public boolean checkPattern(String pattern) {
		this.pattern = pattern;
		this.matching = new boolean[text.length() + 1][pattern.length() + 1];
		matching[0][0] = true;
		for (int row = 1; row < matching.length; row++) {
			for (int col = 1; col < matching[row].length; col++) {
				if (pattern.charAt(col-1) == text.charAt(row-1)) {
					matching[row][col] = matching[row - 1][col - 1];
				} else {
					if (pattern.charAt(col-1) == '?') {
						if (matching[row - 1][col - 1]) {
							matching[row][col] = true;
						} else if (matching[row][col - 1]) {
							matching[row][col] = true;
						} else {
							matching[row][col] = false;
						}
					} else if (pattern.charAt(col-1) == '*') {
						if (matching[row - 1][col - 1]) {
							matching[row][col] = true;
						} else if (matching[row][col - 1]) {
							matching[row][col] = true;
						} else if (matching[row - 1][col]) {
							matching[row][col] = true;
						} else {
							matching[row][col] = false;
						}
					} else {
						matching[row][col] = false;
					}
				}
			}
		}
		return matching[text.length()][pattern.length()];
	}

	public void printsTable() {
		System.out.print("\t");
		for (int i = 0; i < pattern.length(); i++) {
			System.out.print("\t" + pattern.charAt(i));
		}
		System.out.println();
		for (int row = 0; row < matching.length; row++) {
			if(row != 0) System.out.print(text.charAt(row-1));
			for (int col = 0; col < matching[row].length; col++) {
				System.out.print("\t" + matching[row][col]);
			}
			System.out.println();
		}
	}

}
