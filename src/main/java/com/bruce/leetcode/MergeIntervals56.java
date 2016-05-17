package com.bruce.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wuteng1 on 2016/5/17.
 */
public class MergeIntervals56 {
    class Interval{
        int start;
        int end;
        Interval(){
            start = 0;
            end = 0;
        }
        Interval(int s, int e){
            start = s;
            end =e;
        }
    }

    class Solution{
        public List<Interval> merge(List<Interval> intervals){
            List<Interval> result = new ArrayList<Interval>();
            int length = intervals.size();
            if(length <= 1)
                return intervals;
            //对list进行分类
            Collections.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval o1, Interval o2) {
                    if (o1.start == o2.start)
                        return o1.end - o2.end;
                    return o1.start - o2.start;
                }
            });
            //将第一个interval直接加入到result中
            result.add(new Interval(intervals.get(0).start, intervals.get(0).end));
            for(int i = 1; i < intervals.size(); i++){
                Interval current = intervals.get(i);
                Interval last = result.get(result.size() - 1);
                //last的end值大于当前的start值时，merge
                if(last.end >= current.start)
                    last.end = Math.max(current.end, last.end);
                else result.add(current);
            }
            return result;
        }
    }
}
