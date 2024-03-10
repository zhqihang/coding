package test;

import java.util.ArrayList;

/**
 * @author: qihang
 * @CreateDate: 2023/12/21/ 14:03
 * @Project: coding
 * @Description: ......
 */
public class Test01 {

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        for (int i = 1; i <= 13; i++) {
            myHashMap.put(i, 1);
        }
        System.out.println(myHashMap.size());
    }
}
