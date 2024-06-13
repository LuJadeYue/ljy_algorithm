import java.util.Scanner;
import java.util.stream.IntStream;

public class binarySearch {
    /*
     * Binary Search
     * acwing tamplate: https://www.acwing.com/blog/content/31431/
     * acwing problem: https://www.acwing.com/problem/content/description/791/
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 4;
        System.out.println(leftBinarySearch(arr, 0, arr.length - 1));
    }

    // 检查x是否满足某种性质
    private static boolean check(int x) {
        /* ... */
        return true;
    }

    // 区间[left, right]被划分成[left, mid]和[mid + 1, right]时使用：
    // 或者称之为左二分查询，查找左侧第一个满足条件的数
    private static int leftBinarySearch(int[] arr, int left, int right) {
        while (left < right) {
            int mid = arr[left + right >> 1];
            if (check(mid)) {
                right = mid;    // check()判断mid是否满足性质
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 区间[left, right]被划分成[left, mid - 1]和[mid, right]时使用：
    // 或者称之为右二分查询，查找右侧最后一个满足条件的数
    private static int rightBinarySearch(int[] arr, int left, int right) {
        while (left < right) {
            int mid = arr[left + right + 1 >> 1];
            if (check(mid)) {
                left = mid;    // check()判断mid是否满足性质
            } else {
                right = mid - 1;  // 有加必有减
            }
        }
        return left;
    }


    // 二分查找题目
    public static class Main {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int q = in.nextInt();
            int[] arr = IntStream.range(0, n).map(item -> in.nextInt()).toArray();
            while (q-- > 0) {
                int k = in.nextInt();
                int[] ans = binarySearch(arr, k);
                IntStream.range(0, 2).mapToObj(item -> ans[item] + " ").forEach(System.out::print);
                System.out.println();
            }
        }

        private static int[] binarySearch(int[] arr, int target) {
            // 将返回值放到一个长度为2的数组中
            int[] res = new int[2];
            int n = arr.length;
            int left = 0;
            int right = n - 1;
            // 先LBS，找到左边界
            while (left < right) {
                int mid = left + right >> 1;
                if (arr[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // 如果没有找到，则默认-1 -1
            if (arr[left] != target) {
                return new int[]{-1, -1};
            }
            res[0] = left;
            left = 0;
            right = n - 1;
            // 再RBS，找到右边界
            while (left < right) {
                int mid = left + right + 1 >> 1;
                if (arr[mid] <= target) {
                    left = mid;
                } else {
                    right = mid - 1; // 有加必有减
                }
            }
            res[1] = left;
            return res;
        }
    }
}


