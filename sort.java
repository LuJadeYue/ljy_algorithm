public class sort {
    /*
    各种排序算法&复杂度&稳定性
    模版link： https://www.acwing.com/blog/content/277/
     */
    public static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    public void quick_sort(int[] q, int l, int r) {
        //递归的终止情况
        if (l >= r) return;

        //第一步：分成子问题
        int i = l - 1, j = r + 1, x = q[l + r >> 1];
        while (i < j) {
            do i++; while (q[i] < x);
            do j--; while (q[j] > x);
            if (i < j)
                swap(q[i], q[j]);
        }

        //第二步：递归处理子问题
        quick_sort(q, l, j);
        quick_sort(q, j + 1, r);

        //第三步：子问题合并.快排这一步不需要操作，但归并排序的核心在这一步骤
    }

    public void merge_sort(int[] q, int l, int r) {
        //递归的终止情况
        if (l >= r) return;

        //第一步：分成子问题
        int mid = l + r >> 1;

        //第二步：递归处理子问题
        merge_sort(q, l, mid);
        merge_sort(q, mid + 1, r);

        //第三步：合并子问题
        int k = 0, i = l, j = mid + 1;
        int[] tmp = new int[r - l + 1];
        while (i <= mid && j <= r)
            if (q[i] <= q[j])
                tmp[k++] = q[i++];
            else
                tmp[k++] = q[j++];
        while (i <= mid) tmp[k++] = q[i++];
        while (j <= r) tmp[k++] = q[j++];

        for (k = 0, i = l; i <= r; k++, i++) q[i] = tmp[k];
    }

    public static void main(String[] args) {
        sort obj = new sort();
        int[] arr = {2,3,5,7,2,4,8,4};
        obj. merge_sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


    }


}
