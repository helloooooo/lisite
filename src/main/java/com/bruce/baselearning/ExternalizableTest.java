package com.bruce.baselearning;

import java.io.*;

/**
 * Created by wuteng1 on 2016/7/22.
 */
public class ExternalizableTest implements Externalizable {

    private transient String content = "yes, i will serialize";

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        content = (String) in.readObject();
    }

    public static void main(String[] args) {
        ExternalizableTest et = new ExternalizableTest();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("test")));
            out.writeObject(et);

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("test")));
            try {
                et = (ExternalizableTest) in.readObject();
                System.out.println(et.content);
                out.close();
                in.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
