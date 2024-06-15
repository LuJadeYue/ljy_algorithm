public class findKthLargest {

    /**
     * 215. 数组中的第K个最大元素
     * LCR 076. 数组中的第 K 个最大元素
     * https://leetcode.cn/problems/xx4gT2/description/
     * https://leetcode.cn/problems/kth-largest-element-in-an-array/
     */

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    public int quickSelect(int[] nums, int l, int h, int k) {
        if (l == h) return nums[l];
        int i = l - 1, j = h + 1, m = nums[l + h >> 1];
        while (i < j) {
            while (i < j && nums[--j] > m);
            while (i < j && nums[++i] < m);
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        int cntl = j - l + 1;
        if (cntl >= k) return quickSelect(nums, l, j, k);
        else return quickSelect(nums, j + 1, h, k - cntl);
    }

    public static void main(String[] args) {
        findKthLargest obj = new findKthLargest();
        System.out.println(obj.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        System.out.println(obj.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4
    }
}
