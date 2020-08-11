package com.yangshm.leecode;

public class _461_hammingDistance {
    private int hammingDistance1(int x, int y) {
        // 不同的位置标记为1
        x ^= y;
        //计算1的个数
        //巧用 n&(n-1) 会把最右边的1变为0
        int ans = 0;
        while (x != 0) {
            System.out.println("x:" + x);
            ans++;
            x &= (x - 1);
            System.out.println("x &= (x - 1):" + x);
        }
        return ans;
    }

    private int hammingDistance2(int x, int y) {
        int count = 0;

        //获取x、y的字符串
        String xStr = Integer.toBinaryString(x);
        String yStr = Integer.toBinaryString(y);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.abs(xStr.length() - yStr.length()); i++) {
            sb.append('0');
        }

        if (xStr.length() > yStr.length()) {
            yStr = sb.toString() + yStr;
        } else {
            xStr = sb.toString() + xStr;
        }

        System.out.println("xStr:" + xStr);
        System.out.println("yStr:" + yStr);

        //字符串比较
        for (int i = xStr.length(), j = yStr.length(); i > 0 && j > 0; i--, j--) {
            if (xStr.charAt(i - 1) != yStr.charAt(j - 1)) {
                count++;
            }
        }

        return count;
    }
}
