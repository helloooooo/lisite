package com.bruce.niuke.huawei;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        while(scaner.hasNext()){
            String input = scaner.nextLine();
            String name_line = input.substring(input.lastIndexOf('\\') + 1);
            if(map.containsKey(name_line)){
                map.put(name_line, map.get(name_line) + 1);
            }
            else{
                map.put(name_line, 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        if(list.size() > 8)
            list = list.subList(0, 8);
        for(Map.Entry<String, Integer> entry: list){
            String name_line = entry.getKey();
            String[] arr = name_line.split(" ");
            String filename = arr[0];
            String line = arr[1];
            Integer count = entry.getValue();
            if(filename.length() > 16){
                filename = filename.substring(filename.length() - 16);
            }
            System.out.println(filename + " "  + line + " " + count);
        }
    }
}
