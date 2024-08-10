package hasmapset;

import java.util.HashMap;
import java.util.Map;

public class Itinerary {

    public static String getStart(Map<String,String > ticket){

        Map<String,String> reverseMap = new HashMap<>();

        for(var entry:ticket.entrySet()){
            reverseMap.put(entry.getValue(), entry.getKey());
        }

        System.out.println("ticket: " + ticket);

        System.out.println("reverse map: " + reverseMap);


        for(var entry:ticket.entrySet()){
            if(!reverseMap.containsKey(entry.getKey())){
                return entry.getKey();
            }
        }
        return null;

    }

    public static void main(String[] args) {
        Map<String,String> itinerary = new HashMap<>();
        itinerary.put("Chennai", "Bengaluru");
        itinerary.put("Mumbai", "Delhi");
        itinerary.put("Goa", "Chennai");
        itinerary.put("Delhi", "Goa");

        String start = getStart(itinerary);

        System.out.println("Starting Point is : " + start);
        System.out.println("Complete itinerary is :");

        while (itinerary.containsKey(start)){
            System.out.print(start+"->");
            start = itinerary.get(start);
        }
        System.out.print(start);


    }
}
