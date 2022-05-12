package Sudoku;

public class SudokuSolver {

    // Main method for tests
    public static void main(String[] args) {
        int[][][] listOfBoards = new int[5][9][9];

        int[][] board1 =   {{0, 0, 6, 1, 0, 0, 0, 0, 8},
                            {0, 8, 0, 0, 9, 0, 0, 3, 0},
                            {2, 0, 0, 0, 0, 5, 4, 0, 0},
                            {4, 0, 0, 0, 0, 1, 8, 0, 0},
                            {0, 3, 0, 0, 7, 0, 0, 4, 0},
                            {0, 0, 7, 9, 0, 0, 0, 0, 3},
                            {0, 0, 8, 4, 0, 0, 0, 0, 6},
                            {0, 2, 0, 0, 5, 0, 0, 8, 0},
                            {1, 0, 0, 0, 0, 2, 5, 0, 0}};

        int[][] board2 =   {{0, 0, 6, 0, 0, 0, 9, 0, 8},
                            {0, 0, 0, 3, 0, 9, 0, 0, 0},
                            {9, 0, 4, 0, 0, 0, 2, 0, 0},
                            {0, 0, 0, 0, 0, 7, 0, 0, 0},
                            {0, 1, 0, 9, 4, 0, 8, 0, 0},
                            {0, 6, 0, 0, 0, 8, 5, 0, 0},
                            {0, 0, 7, 2, 0, 0, 0, 6, 0},
                            {0, 0, 9, 0, 1, 5, 0, 2, 0},
                            {0, 0, 0, 4, 0, 0, 0, 0, 0}};

//        int[][] board3 =   {{0, 5, 7, 2, 0, 0, 0, 10, 0}, // Contains a number over 9: Should return Exception
//                            {0, 0, 0, 0, 9, 0, 8, 1, 0},
//                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                            {9, 0, 0, 0, 3, 0, 0, 0, 0},
//                            {0, 0, 0, 0, 0, 0, 0, 0, 7},
//                            {0, 8, 0, 0, 0, 0, 0, 0, 5},
//                            {0, 0, 0, 0, 0, 0, 0, 9, 4},
//                            {8, 0, 0, 0, 0, 0, 0, 3, 0},
//                            {0, 0, 2, 0, 0, 7, 0, 0, 0}};
        int[][] board3 =    {{1, 1, 3, 4, 5, 6, 7, 8, 9}, // Throws an illegal argument exception???
                            {4, 0, 6, 7, 8, 9, 1, 2, 3},
                            {7, 8, 9, 1, 2, 3, 4, 5, 6},
                            {2, 3, 4, 5, 6, 7, 8, 9, },
                            {5, 6, 7, 8, 9, 1, 2, 3, 4},
                            {8, 9, 1, 2, 3, 4, 5, 6, 7},
                            {3, 4, 5, 6, 7, 8, 9, 1, 2},
                            {6, 7, 8, 9, 1, 2, 3, 4, 5},
                            {9, 1, 2, 3, 4, 5, 6, 7, 8 }};

        int[][] board4 =   {{0, 5, 7, 2, 0, 0, 0, 0, 0}, // Contains too few givens: Should return Exception
                            {0, 0, 0, 0, 9, 0, 8, 1, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {9, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 7},
                            {0, 8, 0, 0, 0, 0, 0, 0, 5},
                            {0, 0, 0, 0, 0, 0, 0, 9, 4},
                            {8, 0, 0, 0, 0, 0, 0, 3, 0},
                            {0, 0, 2, 0, 0, 7, 0, 0, 0}};

        int[][] board5 =   {{0, 0, 6, 0, 0, 0, 9, 0, 8, 1}, // Contains too many columns: Should return Exception
                            {0, 0, 0, 3, 0, 9, 0, 0, 0, 2},
                            {9, 0, 4, 0, 0, 0, 2, 0, 0, 6},
                            {0, 0, 0, 0, 0, 7, 0, 0, 0, 0},
                            {0, 1, 0, 9, 4, 0, 8, 0, 0, 0},
                            {0, 6, 0, 0, 0, 8, 5, 0, 0, 3},
                            {0, 0, 7, 2, 0, 0, 0, 6, 0, 0},
                            {0, 0, 9, 0, 1, 5, 0, 2, 0, 0},
                            {0, 0, 0, 4, 0, 0, 0, 0, 0, 0}};

        listOfBoards[0] = board1;
        listOfBoards[1] = board2;
        listOfBoards[2] = board3;
        listOfBoards[3] = board4;
        listOfBoards[4] = board5;


        for (int[][] listOfBoard : listOfBoards) {
            System.out.println("\n==========================================\n");
            System.out.println("Original: ");
            for (int[] row : listOfBoard) {
                for (int num : row) {
                    System.out.print(num + ", ");
                }
                System.out.println();
            }

            SudokuSolver solver = new SudokuSolver(listOfBoard);
            solver.solve();

            System.out.println("==========================================\n");
            System.out.println("Solved: ");
            for (int[] row : listOfBoard) {
                for (int num : row) {
                    System.out.print(num + ", ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    int[][] board;
    public SudokuSolver(int[][] grid) {

        if(grid.length != 9){
            throw new IllegalArgumentException();
        }

        int givens = 0;
        for(int[] array:grid){
            if(array.length != 9){
                throw new IllegalArgumentException();
            }
            for(int num:array){
                if(num > 9 || num < 0){
                    throw new IllegalArgumentException("Invalid grid");
                } else if (num > 1){
                    givens++;
                }
            }
        }
        if(givens >= 16){
            board = new int[grid.length][];
            for(int i=0;i<grid.length;i++){
                board[i] = grid[i].clone();
            }
        } else {
            throw new IllegalArgumentException("Not Enough Givens");
        }
    }


    public int[][] solve() {
        try{
            if(solveBoard(board) == solveBoard(board)){
                return board;
            } else {
                throw new IllegalArgumentException("Board Unsolvable");
            }
        } catch (Exception e){
            throw new IllegalArgumentException("Something Broke!");
        }
    }


    private static boolean solveBoard(int[][] board){

        for(int row=0; row<9; row++){
            for(int column=0; column<9; column++){
                if(board[row][column]  == 0){
                    for(int tryNum=1; tryNum<=9; tryNum++){
                        if(isValidNum(board, tryNum, row, column)){
                            board[row][column] = tryNum;
                            if(solveBoard(board)){
                                return true;
                            } else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isNumInRow(int[][] board, int row, int number){
        for (int i=0; i<9; i++){
            if(board[row][i] == number){
                return true;
            }
        }
        return false;
    }

    private static boolean isNumInColumn(int[][] board, int column, int number){
        for(int i=0; i<9; i++){
            if(board[i][column] == number){
                return true;
            }
        }
        return false;
    }

    private static boolean isValidNum(int[][] board, int number, int row, int column){
        return !isNumInColumn(board, column, number) && !isNumInRow(board, row, number) && !isNumInBox(board, column, row, number);
    }

    private static boolean isNumInBox(int[][] board, int column, int row, int number){
        int localRow = row - row % 3;
        int localColumn = column - column % 3;
        for (int i=localRow; i<localRow + 3; i++){
            for(int j=localColumn; j< localColumn + 3; j++){
                if(board[i][j] == number){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isBoardValid(int[][] board){ // FIXME - not finished
        for(int i=0; i<9; i++){
            int[] currentRow = board[i];
            for(int j=0; j<9; j++){
                int currentNum = board[i][j];
                if(currentNum != '0'){
                    if(true){

                    }
                }
            }
        }


        return true;
    }
}
