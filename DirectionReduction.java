import java.util.*;

public class DirectionReduction {

    public static String[] dirReduc(String[] arr) {
        // For testing: print out starting array
        System.out.println("Starting Array: " + Arrays.toString(arr));
        for(int i=0; i<arr.length-1; i++) {
            if (arr[i].equalsIgnoreCase("north") && arr[i + 1].equalsIgnoreCase("south") ||
                    (arr[i].equalsIgnoreCase("south") && arr[i + 1].equalsIgnoreCase("north")) ||
                    (arr[i].equalsIgnoreCase("east") && arr[i + 1].equalsIgnoreCase("west")) ||
                    (arr[i].equalsIgnoreCase("west") && arr[i + 1].equalsIgnoreCase("east"))) {
                arr[i] = "";
                arr[i + 1] = "";
            }
        }
        String[] reduced = Arrays.stream(arr).filter(s -> !Objects.equals(s, "")).toArray(String[]::new);
        System.out.println("Reduced Array = " + Arrays.toString(reduced));
        return (reduced.length == arr.length || arr.length<= 1) ? arr: dirReduc(reduced);
    }
}







