public class atoi {
    public int myAtoi(String s) {
        // 定义符号，正数为1，负数为-1
        int sign = 1;
        // 结果初始化为0
        int res = 0;
        // 获取字符串长度
        int m = s.length();
        // 初始化索引
        int i = 0;

        // 跳过前导空格
        while (i < m && s.charAt(i) == ' ') {
            i++;
        }

        // 标记开始位置
        int start = i;

        // 遍历字符串
        for (; i < m; i++) {
            char c = s.charAt(i);

            // 检查符号位
            if (i == start && c == '+') {
                sign = 1;
            } else if (i == start && c == '-') {
                sign = -1;
                // 检查数字并进行转换
            } else if (Character.isDigit(c)) {
                int num = c - '0';

                // 检查溢出情况
                if (res > Integer.MAX_VALUE / 10 ||
                        (res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }

                // 检查下溢情况
                if (res < Integer.MIN_VALUE / 10 ||
                        (res == Integer.MIN_VALUE / 10 && -num < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }

                // 累加结果
                res = res * 10 + sign * num;
            } else {
                // 遇到非数字字符时停止处理
                break;
            }
        }
        // 返回结果
        return res;
    }

    public static void main(String[] args) {
        atoi obj = new atoi();
        String s = "42";
        System.out.println(obj.myAtoi(s));
    }
}
