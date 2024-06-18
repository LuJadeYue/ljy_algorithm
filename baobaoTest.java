import java.util.Scanner;

public class baobaoTest {
    private void mergeSort(int[] arr, int l, int r) {
        // 终止情况
        if (l >= r) {
            return;
        }

        //divide
        int mid = l + r >> 1;

        //process
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        //merge
        int k = 0;
        int i = l;
        int j = mid + 1;
        int[] temp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }
        for (k = 0, i = l; i < r + 1; k++, i++) {
            arr[i] = temp[k];
        }

    }


    private void quickSort(int[] arr, int l, int r) {
        // 终止情况
        if (l >= r) {
            return;
        }
        // 分成子问题
        int i = l - 1;
        int j = r + 1;
        int p = arr[l + r >> 1];
        while (i < j) {
            do {
                i++;
            } while (arr[i] < p);
            do {
                j--;
            } while (arr[j] > p);
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 递归处理子问题
        quickSort(arr, l, j);
        quickSort(arr, j + 1, r);
    }


    private boolean check(int i) {
        return true;
    }

    private int leftBinarySearch(int[] arr, int l, int r) {
        while (l < r) {
            int mid = arr[l + r >> 1];
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int rightBinarySearch(int[] arr, int l, int r) {
        while (l < r) {
            int mid = arr[l + r + 1 >> 1];
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }



}
