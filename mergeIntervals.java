import java.util.Arrays;
public class mergeIntervals {
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        int[][] merge = new int[length][2];
        //按照左端点进行排序
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        merge[0] = intervals[0];
        int idx = 0;
        //遍历数组
        for(int i = 0;i<length;i++){
            //如果当前数组左端点>基准数组的右端点
            if(intervals[i][0]>merge[idx][1]){
                //把当前数组给加进去
                merge[++idx] = intervals[i];
            }else{
                //否则就取这两个区间中右端点最大的哪个进行合并
                merge[idx][1] = Math.max(merge[idx][1],intervals[i][1]);
            }
        }
        return Arrays.copyOf(merge,idx+1);
    }

    public static void main(String[] args) {
        mergeIntervals obj = new mergeIntervals();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = obj.merge(intervals);
        for (int[] re : res) {
            System.out.println(re[0] + " " + re[1]);
        }
    }

}
