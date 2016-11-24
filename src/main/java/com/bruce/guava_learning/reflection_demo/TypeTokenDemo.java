package com.bruce.guava_learning.reflection_demo;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;

import java.util.List;
import java.util.Map;

/**
 * Created by wuteng1 on 2016/9/18.
 */
public class TypeTokenDemo {

    static <K, V> TypeToken<Map<K, V>> mapToken(TypeToken<K> keyToken, TypeToken<V> valueToken){
        return new TypeToken<Map<K, V>>() {}
        .where(new TypeParameter<K>(){}, keyToken).where(new TypeParameter<V>() {}, valueToken);
    }
    public static void main(String[] args) {
        TypeToken<String> stringTok = TypeToken.of(String.class);
        TypeToken<Integer> integerTok = TypeToken.of(Integer.class);

        //to obtain a TypeToken for a type with generics, when you know the generic type at compile time, you use empty anonymous inner class:
        TypeToken<List<String>> stringListTok = new TypeToken<List<String>>() {};
        //deliberately refer to a wildcard
        TypeToken<Map<?, ?>> wildMapTok = new TypeToken<Map<?, ?>>() {};

    }
}
