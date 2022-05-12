import java.util.*;

public class RangeExtraction {
    public static String rangeExtraction(Integer[] arr) {
        SortedSet<Integer> sorted = new TreeSet<>(Arrays.asList(arr));


        //for(Integer i:sorted){
            //determine numbers in sequence over 3 and return a range
       // }

        return sorted.toString();
    }



    private static String toStr(SortedSet sorted){
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sorted.forEach(number -> {
            sb.append(number.toString()).append(",");
        });
       return sb.toString();
    }

}
