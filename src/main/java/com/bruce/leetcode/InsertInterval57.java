package com.bruce.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by wuteng1 on 2016/7/7.
 */
public class InsertInterval57 {

    static class Interval{
        int start;
        int end;
        Interval(){ start = 0; end = 0; }
        Interval(int s, int e){
            start = s;
            end = e;
        }
    }
    static class Solution{
        public List<Interval> insert(List<Interval> intervals, Interval newInterval){
            List<Interval> res = new ArrayList<Interval>();
            if(intervals == null || intervals.size() == 0){
                res.add(newInterval);
                return res;
            }
            ListIterator<Interval> iter = intervals.listIterator();
            while(iter.hasNext()){
                Interval current = iter.next();
                if(current.start > newInterval.end){
                    iter.previous();
                    iter.add(newInterval);
                    return intervals;
                }
                else if(current.end < newInterval.start){
                    continue;
                }
                else{
                    int start = Math.min(newInterval.start, current.start);
                    int end = Math.max(newInterval.end, current.end);
                    newInterval = new Interval(start, end);
                    iter.remove();
                }
            }
            intervals.add(newInterval);
            return intervals;
        }
    }
}
