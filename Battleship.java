
import java.util.ArrayList;

public class Battleship {
    final static int GRID_SIZE = 10;
    static ArrayList<String> ships = new ArrayList<>();
    public static void main(String[] args) {
//        int[][] field = {{1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
//                {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
//                {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int[][] field = {{1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                {0, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1 },
                {1, 1, 1, 1, 0, 1, 0, 0, 0, 0 },
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }};
        System.out.println(fieldValidator(field));
    }
    /*
            Goal: Validate the field following the initial placement a player's ships.
            Rules: No ships can overlap and all ships must be placed.
                   Ships may only be placed within the 10x10 grid.
                   Ships must be placed without modifying their shape.
                   Ships cannot touch each other, including diagonally

            Ships: (1) 4x1 Battleship
                   (2) 3x1 Cruisers
                   (3) 2x1 Destroyers
                   (4) 1x1 Submarines

            Note: The battlefield will always be a 10x10 grid.
                  Ships will be marked within a 2-D 10x10 int array.
                  Empty spaces will appear as 0.
                  Ships will appear with a 1. e.g. A battleship may be shown as 1, 1, 1, 1.

     */


    public static boolean fieldValidator(int[][] field){
        ships.clear();

        ships.add("Battleship"); // One Battleship
        ships.add("Cruiser"); // Two Cruisers
        ships.add("Cruiser");
        ships.add("Destroyer"); // Three Destroyers
        ships.add("Destroyer");
        ships.add("Destroyer");
        ships.add("Submarine"); // Four Submarines
        ships.add("Submarine");
        ships.add("Submarine");
        ships.add("Submarine");
        return traverseField(field);
    }

    public static boolean shipRemover(int shipSize, ArrayList<String> ships, int[][] field){
        if(ships.size() > 0) {
            switch (shipSize) {
                case 4:
                    ships.remove("Battleship");
                    break;
                case 3:
                    ships.remove("Cruiser");
                    break;
                case 2:
                    ships.remove("Destroyer");
                    break;
                case 1:
                    ships.remove("Submarine");
                    break;
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean traverseField(int[][] field){
        int shipSize = 0;// Moved this from line 81 - changed result
        for(int i=0; i<GRID_SIZE; i++){
            if(shipSize != 0){
                if(!shipRemover(shipSize, ships,field)){
                    return false;
                }
            }
            shipSize = 0;
            for(int j=0; j<GRID_SIZE; j++){
                if(shipSize >= 1 && field[i][j] == 0){
                    if(!shipRemover(shipSize, ships, field)){
                        return false;
                    }
                    shipSize = 0; // Reset ship size.
                }
                if (field[i][j] == 1) {
                    shipSize++;
                    field[i][j] = 2; // Mark hit ship
                    if (i < GRID_SIZE - 1 && field[i + 1][j] == 1) { // Ship is not a submarine
                        shipSize++;
                        field[i + 1][j] = 2;
                        if (i < GRID_SIZE - 2 && field[i + 2][j] == 1) { // Ship is not a Destroyer
                            shipSize++;
                            field[i + 2][j] = 2;
                            if (i < GRID_SIZE - 3 && field[i + 3][j] == 1) { // Battleship Hit!
                                shipSize++;
                                field[i + 3][j] = 2; // Mark a hit ship
                            }
                        }
                    }
                }
            }

        }
        return ships.size() == 0; // If extra ships were placed on the board or not enough, return false.
    }

    public static void printField(int[][] field){
        System.out.println("\n-------------------\nCurrent Field");
        for(int[] row:field){
            for(int cell:row){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.print("-------------------\n");
    }
}