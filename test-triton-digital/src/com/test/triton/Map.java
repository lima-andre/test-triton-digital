package com.test.triton;

import java.util.HashMap;

public class Map<K, V> extends HashMap<K, V> {

    
	private static final long serialVersionUID = -6426718775340094669L;

	private int numberOfGets = 0;
    private int numberOfPuts = 0;

    @Override
    public synchronized V put(K key, V value) {
            numberOfPuts++;
            return super.put(key, value);
    }

    @Override
    public synchronized V get(Object key) {
            numberOfGets++;
            return super.get(key);
    }        

    public int getNumberOfGets() {
            return numberOfGets;
    }

    public int getNumberOfPuts() {
            return numberOfPuts;
    }

    public static void main(String[] args) {
            Map<String, String> mapToTest = new Map<String, String>();
            
            mapToTest.put("A", "Montreal Canadiens");
            mapToTest.put("B", "Vancouver Canucks");
            mapToTest.put("C", "Ottawa Senators");
            mapToTest.put("D", "Toronto Maple Leafs");
            mapToTest.put("E", "Pittsburgh Penguins");
            mapToTest.put("F", "New York Rangers");
            mapToTest.put("G", "Boston Bruins");
            
            mapToTest.get("A");
            mapToTest.get("D");
            mapToTest.get("F");
            mapToTest.get("G");
            
            System.out.println("Number of Puts : " + mapToTest.getNumberOfPuts());
            System.out.print("Numer of Gets : " + mapToTest.getNumberOfGets());          

    }
}
