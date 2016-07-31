package com.bruce.concurrentdemo.demo;


import java.util.*;

/**
 * Created by wuteng1 on 2016/7/30.
 *
 2
 3
 mike 3
 andrew 5
 mike 2
 3
 andrew 3
 andrew 2
 mike 5
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int t = scanner.nextInt();
            while(t-- > 0){
                int n = scanner.nextInt();
                Queue<Node> nodeQueue = new PriorityQueue<Node>();
                for(int i = 0; i < n; i++){
                    String name = scanner.next().trim();
                    int score = scanner.nextInt();
                    Iterator<Node> iterator = nodeQueue.iterator();
                    int oldScore = 0;
                    while(iterator.hasNext()){
                        Node node = iterator.next();
                        if(node.name.equals(name)){
                            iterator.remove();
                            oldScore = node.count;
                            break;
                        }
                    }
                    nodeQueue.add(new Node(name, oldScore + score));
                }
                Node res = nodeQueue.peek();
                System.out.println(res.name);

            }
        }
    }
}

class Node implements Comparable<Node>{
    String name;
    int count;

    public Node(String name, int count) {
        this.name = name;
        this.count = count;
    }


    public int compareTo(Node o) {
        return o.count - count;
    }
}