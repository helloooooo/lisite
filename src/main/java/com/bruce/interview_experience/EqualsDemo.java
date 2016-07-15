package com.bruce.interview_experience;

/**
 * Created by 腾 on 2016/7/11.
 */
public class EqualsDemo {
    public static void main(String[] args) {
        Person p1 = new Person("hello");
        Person p2 = new Person("hello");
        System.out.println(p1.equals(p2));
        System.out.println(p1==p2);
    }
    static class Person{
        private String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj)
                return true;
            if(! (obj instanceof Person)){
                return false;
            }
            final Person p = (Person)obj;
            return p.name.equals(this.name);
        }
    }
}
