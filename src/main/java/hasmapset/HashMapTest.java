package hasmapset;

import java.util.*;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String,String> phoneDirectoryMap = new HashMap<>();

        phoneDirectoryMap.put("Test","12345");
        phoneDirectoryMap.put("asdf","23456");
        phoneDirectoryMap.put("qwer","34567");
        phoneDirectoryMap.put("Tezxcvst","45678");
        phoneDirectoryMap.put("parul","56789");
        phoneDirectoryMap.put("lkjhg","67890");

        for(Map.Entry m: phoneDirectoryMap.entrySet()){
            System.out.println("Key: "+ m.getKey() + " Value: "+ m.getValue());
        }

        // when we put something on the map with same key as previous existing one, it overrides that value

        phoneDirectoryMap.put("Test","99999");
        phoneDirectoryMap.remove("parul");
        System.out.println("after change to Test and removed parul");
        Set<String>keyset = phoneDirectoryMap.keySet();
        for(String s: keyset){
            System.out.println("Key: "+ s + " Value: "+ phoneDirectoryMap.get(s));
        }

        Set<String> stringSet = new HashSet<>();

        stringSet.add("a");
        stringSet.add("b");
        stringSet.add("c");
        stringSet.add("d");
        stringSet.add("e");
        stringSet.add("f");

        // we store unique value
        stringSet.add("a");

        System.out.println("My set is: \n" + stringSet);


        if (stringSet.contains("a")){
            System.out.println("Set contains s");
        }
        if(!stringSet.contains("z")){
            System.out.println("Does not contain z");
        }

        stringSet.remove("a");
        System.out.println("My set is: \n" + stringSet);

        var itr = stringSet.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }




    }
}
