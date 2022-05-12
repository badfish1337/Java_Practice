package Sudoku;

import java.util.ArrayList;

public class SudokuSolutionChecker {
    public static void main(String[] args) {
        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 9, 6, 1, 7, 8}
        };

        System.out.println(check(sudoku));
    }
    public static boolean check(int[][] sudoku) {
        ArrayList<ArrayList<Integer>> boxes = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i=0;i<9;i++){
            boxes.add(new ArrayList<>());
        }

        for(int i=0; i<9; i++){
            numbers.add(i+1);

            for(int j=0; j<9; j++){


                // Box total counter
                int currentElement = sudoku[i][j];
                if(i < 3){ // first row
                    if(j < 3){ // left box
                        boxes.get(0).add(currentElement);
                    } else if(j<6){ // middle box
                        boxes.get(1).add(sudoku[i][j]);
                    } else if (j<9){ // right box
                        boxes.get(2).add(sudoku[i][j]);
                    }
                } else if (i<6){ // middle row
                    if(j < 3){ // left box
                        boxes.get(3).add(sudoku[i][j]);
                    } else if(j<6){ // middle box
                        boxes.get(4).add(sudoku[i][j]);
                    } else if (j<9){ // right box
                        boxes.get(5).add(sudoku[i][j]);
                    }
                } else if (i<9){ // bottom row
                    if(j < 3){ // left box
                        boxes.get(6).add(sudoku[i][j]);
                    } else if(j<6){ // middle box
                        boxes.get(7).add(sudoku[i][j]);
                    } else if (j<9){ // right box
                        boxes.get(8).add(sudoku[i][j]);
                    }
                }
            }

        }

        // Check box values (sub 3x3 grids)
        for(ArrayList<Integer> values:boxes){
            System.out.println(values);
            if(!values.containsAll(numbers) && !values.isEmpty()){
                return false;
            }
        }

        // If all tests pass, answer is valid
        return true;
    }
}
