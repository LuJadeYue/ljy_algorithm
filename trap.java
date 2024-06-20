public class trap {
    public int trap(int[] height){
        int n = height.length;
        //双指针
        int l = 0;
        int res = 0;
        int r = n-1;
        //左右两边的最大值
        int pre_max = 0;
        int suf_max = 0;
        while(l<r){
            pre_max = Math.max(pre_max,height[l]);
            suf_max = Math.max(suf_max,height[r]);
            //如果左边的最大值小于右边的最大值，那么就把左边的最大值减去当前高度，然后左指针右移
            if(pre_max<suf_max){
                res += pre_max-height[l];
                l++;
            }else{
                res += suf_max-height[r];
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        trap obj = new trap();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(obj.trap(height));
    }
}
