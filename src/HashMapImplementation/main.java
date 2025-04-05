package HashMapImplementation;

import HashMapImplementation.Entity.CustomMap;

public class main {
    public static void main(String []args) {
        CustomMap<String,Integer> customMap = new CustomMap<>(4);
        customMap.put("A",2);
        customMap.put("A",1);
        customMap.put("B",2);
        customMap.put("C",2);
        customMap.put("D",2);
        customMap.put("D",2);
        customMap.put("F",2);
        customMap.put("G",4);
        customMap.printMap();
        System.out.println(customMap.get("C"));
        System.out.println(customMap.get("G"));

        System.out.println("New custom logic");

        CustomMap<String, Integer> map = new CustomMap<>(4);
        String[] input = {"apple", "banana", "apple", "mango", "banana", "banana"};

        for (String word : input) {
            Integer freq = map.get(word);
            if (freq == null) {
                map.put(word, 1); // first time
            } else {
                map.put(word, freq + 1); // increment frequency
            }
        }
        map.printMap();

    }
}
