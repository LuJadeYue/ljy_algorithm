import java.util.Arrays;
import java.util.List;

public class find_minimum_difference {
    public int findMinDifference(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (Math.abs(arr[i] - arr[j]) < min) {
                    min = arr[i] - arr[j];
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        find_minimum_difference obj = new find_minimum_difference();
        int[] arr = {2, 3, 5, 7, 2, 4, 8, 4};
        System.out.println(obj.findMinDifference(arr));
    }
}
