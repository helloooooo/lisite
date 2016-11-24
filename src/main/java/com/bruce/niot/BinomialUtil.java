package com.bruce.niot;

import org.junit.Test;

/**
 * Created by wuteng1 on 2016/10/25.
 */
public class BinomialUtil {
    @Test
    public void testBinomial(){
        System.out.println(binomialProbability(100, 60, 0.6));
    }
    public double binomialProbability(int n, int k, double p){
        assert (p < 1);
        long res = 1;
        int minK = n-k;
        int tempK = k;
        for(int i = n; i >= k; i--){
            res *= i;
            while(res > Math.sqrt(Long.MAX_VALUE)){
                if(minK-- > 0)
                    res *= p * (1-p);
                if(tempK > 0){
                    res /= (double)tempK;
                    tempK --;
                }
            }
        }
        for(int i = 1; i <= 2*k-n; i++){
            res *= p;
        }
        System.out.println(res);
        System.out.println(tempK);
        for(int i = tempK; i >= 1; i--){
            res /= (double)i;
        }
        return res;
    }
}
