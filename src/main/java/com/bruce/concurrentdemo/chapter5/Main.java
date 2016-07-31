package com.bruce.concurrentdemo.chapter5;

import java.util.*;
/**
 * Created by wuteng1 on 2016/7/30.
 */
public class Main {
    public static void main(String[] args){
        /*Scanner scanner = new Scanner(System.in);
        List<TimerElapser> list = new ArrayList<TimerElapser>();
        while(scanner.hasNext()){
            String line = scanner.next();
            if(line.equals("end")){
                if(list.size() > 0){
                    for(TimerElapser t: list){
                        System.out.println(t);
                    }
                }
                else System.out.println("none");
                return;
            }
            int indexColon = line.indexOf(':');
            String operator = line.substring(0, indexColon);
            if(operator.equals("starttimer")){
                int indexComma = line.indexOf(',');
                int timerId = Integer.parseInt(line.substring(indexColon + 1, indexComma));
                int timerLength = Integer.parseInt(line.substring(indexComma + 1));
                TimerElapser timer = new TimerElapser(timerId, timerLength);
                list.add(timer);
            }
            else if(operator.equals("elapse")){
                int elapse = Integer.parseInt(line.substring(indexColon + 1));
                Iterator<TimerElapser> iter = list.iterator();
                while(iter.hasNext()){
                    TimerElapser timer = iter.next();
                    if(timer.removed(elapse)){
                        iter.remove();
                    }
                }
            }
            else if(operator.equals("stoptimer")){
                int id = Integer.parseInt(line.substring(indexColon + 1));
                Iterator<TimerElapser> iter = list.iterator();
                while(iter.hasNext()){
                    TimerElapser timer = iter.next();
                    if(timer.id == id){
                        iter.remove();
                    }
                }
            }


        }
        */
        Object object = new Object(){
            @Override
            public boolean equals(Object obj) {
                return true;
            }
        };

        System.out.println(object.equals("xi"));
    }
}


class A{
    protected int a(){
        return 1;
    }
}
class B extends A{
    public int a(){
        return 1;
    }
}
class TimerElapser{
    int id;
    int lasting;
    public TimerElapser(int id, int lasting){
        this.id = id;
        this.lasting = lasting;
    }

    public boolean removed(int current){
        if(current >= lasting){
            return true;
        }
        else{
            lasting -= current;
            return false;
        }
    }

    public String toString(){
        return "timer:" + this.id + ","+this.lasting;
    }
}
