package com.algos.practice.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
    
    int hitCounter = 0;
    
    private static final Map<Integer, String> decodeMap = new HashMap<>();
    static {
        char initialCharacter = 'A';
        for(int i = 1; i <= 26; i++) {
            decodeMap.put(i, String.valueOf(initialCharacter++));
        }
    }

    public int numDecodings(final String s) {
        final Map<String, Integer> counterMap = new HashMap<>();
        
        int result = numDecodings(s, counterMap);
        
        counterMap.entrySet().stream().forEach(entry -> System.out.println("key is " + entry.getKey() 
                + " value is " + entry.getValue()));
        
        return result;
    }
    
    public int numDecodings(final String s, final Map<String, Integer> counterMap) {
        System.out.println("Input string is " + s);
        if(s == null || s.isEmpty()) {
            return 0;
        }
        int counter1 = 0, counter2 = 0;
        
        if(counterMap.containsKey(s)) {
            hitCounter++;
            return counterMap.get(s);
        }
        if (decodeMap.containsKey(Integer.valueOf(s.substring(0,1)))) {
            if(s.length() > 1) {
                final String substring = s.substring(1, s.length());
                // System.out.println("Sub string " + substring);
                counter1 =  numDecodings(substring, counterMap);
            } else {
                return 1;
            }
        } else {
            counter1 = 0;
        }
        
        if (decodeMap.containsKey(Integer.valueOf(s.substring(0,2)))) {
            if(s.length() > 2) {
                final String substring = s.substring(2, s.length());
                // System.out.println("Sub string " + substring);
                counter2 =  numDecodings(substring, counterMap);
            } else {
                counter2 = 1;
            }
        } else {
            counter2 = 0;
        }
        counterMap.put(s, counter1 + counter2);
        return counter1 + counter2;
    }
    
    public void printMap(Map<String, Integer> map) {
        map.entrySet().stream().forEach(entry -> 
        System.out.println("Mapping is " + entry.getKey() + " " + entry.getValue()));
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();

        
        System.out.println("Counter is " + 
        solution.numDecodings("11"));
        System.out.println("Hit counter is " + solution.hitCounter);
        
    }
}
