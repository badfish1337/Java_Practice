import java.util.Arrays;

public class MaxSubarraySum {

    public static int sequence(int[] arr){
        System.out.println(Arrays.toString(arr));
        int biggest = 0;
        for(int i=0; i<arr.length; i++) { // Iterate forwards through whole array
            if(arr[i] > 0)
            for (int j = arr.length - 1; j >= i; j--) { //Iterate backwards through whole array
                int current = 0;
                if(arr[j] > 0)
                for(int y=i; y<=j; y++){ // Sum subarray
                    current += arr[y];
                }
                if (current > biggest) {
                    System.out.println("Found biggest: " + biggest);
                    biggest = current;
                }
            }
        }
        return biggest;
    }
}
