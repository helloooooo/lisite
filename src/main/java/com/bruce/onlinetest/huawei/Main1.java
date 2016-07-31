package com.bruce.onlinetest.huawei;

/**
 * Created by wuteng1 on 2016/7/10.
 */
public class Main1 {
    public static void main(String[] args) {

    }

    class Node{
        int l, r, value, add;
        public Node(){

        }
    }
    private final int MAXN = 30010;
    void update(int v, int l, int r, int m, Node[] nodes){
        if(nodes[v].l == l && nodes[v].r == r){
            nodes[v].value = Math.max(nodes[v].value, nodes[v].value);
            return;
        }

        int mid = (nodes[v].l + nodes[v].r) / 2;
        if(r <= mid){   //locate is the left side
            update(v*2, l, r, m, nodes);
        }
        else{
            if(l > mid){
                update(v*2 + 1, l, r, m, nodes);
            }
            else{
                update(v*2, l, mid, m, nodes);
                update(v*2 + 1, mid+1, r, m, nodes);
            }
        }
    }

    void query(int v, int l, int r){

    }
}
