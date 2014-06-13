package assignment4;


public class SudokuSolver {
	
	/**
	 * solves the given riddle
	 * @param sudoku the riddle
	 * @return true if solved, false if not
	 */
	public boolean solve(SudokuBoard sudoku) {
		int row = -1;
		int col = -1;
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				if (!sudoku.isSet(i, j)){
					row = i;
					col = j;
				}
			}
		}
		if (row == -1 && col == -1){
			return true;
		}
		for (int i = 1; i <= 9; i++){
			if (this.column(sudoku, row, col, i) && this.row(sudoku, row, col, i) && this.square(sudoku, row, col, i)){
				sudoku.setCell(i, row, col);
				if (solve(sudoku)){
					return true;
				} else {
					sudoku.removeValue(row, col);
				}
			}
		}
		return false;
	}
	
	private boolean column(SudokuBoard sudoku, int x, int y, int value){
		for (int i = 0; i < sudoku.size(); i++){
			if (sudoku.getCell(x, i) == value) {
				return false;
			}
		}
		return true;
	}
	
	private boolean row(SudokuBoard sudoku, int x, int y, int value){
		for (int i = 0; i < sudoku.size(); i++){
			if (sudoku.getCell(i, y) == value) {
				return false;
			}
		}
		return true;
	}
	
	private boolean square(SudokuBoard sudoku, int x, int y, int value){
		for (int i = x- x%3; i < x-x%3 + 2; i++){
			for (int j = y -y%3; j < y-y%3+2; j++){
				if (sudoku.getCell(i, j) == value){
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * create a new riddle
	 * @param allocations number of allocations in the new riddle
	 * @return the riddle
	 */
	public SudokuBoard createSudokuRiddle(int allocations){
		//TODO
		return null;
	}
}
