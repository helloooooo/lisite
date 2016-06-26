package com.bruce.clonedemo.demo1;

/**
 * Created by wuteng1 on 2016/6/22.
 */
public class ShallowClone {
    static class Body implements Cloneable{
        public Head head;

        public Body(){}

        public Body(Head head){
            this.head = head;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
    static class Head implements Cloneable{
        public Head(){}
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        Body body = new Body(new Head());

        Body body1 = (Body)body.clone();

        System.out.println("body == body1: " + (body == body1));

        System.out.println("body.head == body1.head: " + (body.head == body1.head));


    }
}
