import java.util.List;

//凸包极点问题
public class points {
    int x, y;

    public points(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static int cross(points a, points b, points c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    public static List<points> brute_force_convex_hull(List<points> ponints) {
        int n = ponints.size();
        if (n < 3) {
            return ponints;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int left = 0;
                int right = 0;
                for (int k = 0; k < n; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
//                    int cp = cross(points[i], points[j], points[k]) {
//                        if (cp < 0) {
//                            left++;
//                        } else if (cp > 0) {
//                            right++;
//                        }
//                    }
                }
//                if (right == 0 || left == 0) {
//                    if (
//                }
            }
        }
    return ponints;}

}
