package Iban;

import java.util.HashMap;

public class MapImplementation {

    /* Creating HashTable for keymapping */
    public static int HashMapMethod(String Value) {
        HashMap<String, Integer> ConCodeMap = new HashMap<String, Integer>();
        ConCodeMap.put("A", 10);
        ConCodeMap.put("B", 11);
        ConCodeMap.put("C", 12);
        ConCodeMap.put("D", 13);
        ConCodeMap.put("E", 14);
        ConCodeMap.put("F", 15);
        ConCodeMap.put("G", 16);
        ConCodeMap.put("H", 17);
        ConCodeMap.put("I", 18);
        ConCodeMap.put("J", 19);
        ConCodeMap.put("K", 20);
        ConCodeMap.put("L", 21);
        ConCodeMap.put("M", 22);
        ConCodeMap.put("N", 23);
        ConCodeMap.put("O", 24);
        ConCodeMap.put("P", 25);
        ConCodeMap.put("Q", 26);
        ConCodeMap.put("R", 27);
        ConCodeMap.put("T", 28);
        ConCodeMap.put("S", 29);
        ConCodeMap.put("U", 30);
        ConCodeMap.put("V", 31);
        ConCodeMap.put("W", 32);
        ConCodeMap.put("X", 33);
        ConCodeMap.put("Y", 34);
        ConCodeMap.put("Z", 35);
        int Mapvalue = ConCodeMap.get(Value);
        return Mapvalue;
    }
}
