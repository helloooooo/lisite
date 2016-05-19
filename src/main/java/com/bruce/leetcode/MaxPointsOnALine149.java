package com.bruce.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by wuteng1 on 2016/5/18.
 */
public class MaxPointsOnALine149 {
    static class Point{
        int x;
        int y;
        Point(){ x = 0; y = 0;}
        Point(int a, int b){
            x = a;
            y = b;
        }
    }

    static class Solution{
        public int maxPoints(Point[] points){
            int length = points.length;
            if(length <= 1)
                return length;
            int result = 0;
            for(int i = 0; i < length; i++){
                //遍历所有的两两之间的直线
                int same = 0, viticals = 0;
                Map<Float, Integer> slope = new HashMap<Float, Integer>();
                for(int j = i+1; j < length; j++){
                    if(points[i].x == points[j].x){
                        if(points[i].y == points[j].y)
                            same++;
                        else viticals++;
                    }
                    else{
                        float s = (points[j].y - points[i].y) / (float)(points[j].x - points[i].x);
                        if(points[i].y == points[j].y)
                            s = 0;
                        Integer val = slope.get(s);
                        if(val != null){
                            slope.put(s, val+1);
                        }
                        else{
                            slope.put(s, 1);
                        }
                    }
                }
                //找出包含节点数最大的那个直线
                Iterator<Integer> iter = slope.values().iterator();
                int tempCnt = 0;
                while (iter.hasNext()){
                    Integer cnt = iter.next();
                    if(cnt > tempCnt){
                        tempCnt = cnt;
                    }
                }
                //有斜率的点 比垂直线上的点少
                if(tempCnt < viticals)
                    tempCnt = viticals;
                if(result < tempCnt + same)
                    result = tempCnt + same;
            }
            return 1 + result;
        }
    }

    public static void main(String[] args) {
        System.out.println(0/1.0 == 0/-1.0);
        float a = 0/(float)1;
        float b = 0/(float)-1.0;
        System.out.println(a == b);
        Double a1 = 0/1.0;
        Double b1 = 0/-1.0;
        System.out.println(a1 == b1);
        Point p1 = new Point(2,3);
        Point p2 = new Point(3,3);
        Point p3 = new Point(-5,3);
        Point[] ps = {p1,p2,p3};
        System.out.println(ps.length);
        Solution sol = new Solution();
        System.out.println(sol.maxPoints(ps));
    }
}
