package LeetCode.AirBnb;

import java.util.*;
import java.util.stream.Collectors;

public class ReconstructItinerary {
    public static void main(String[] args){
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        String[][] tickets = new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        List<List<String>> listOfLists = Arrays.stream(tickets).map(Arrays::asList).collect(Collectors.toList());
        List<String> res = reconstructItinerary.findItinerary(listOfLists);
        System.out.println(res.toString());

    }
    public List<String> findItinerary(List<List<String>> tickets){
        List<String> itinerary = new ArrayList<>();
        HashMap<String, List<String>> adjacencyMap = new HashMap<>();
        for(int i = 0; i < tickets.size(); i ++){
            List<String> currentTicket = tickets.get(i);
            List<String> destinations = adjacencyMap.getOrDefault(currentTicket.get(0), new ArrayList<String>());
            destinations.add(currentTicket.get(1));
            adjacencyMap.put(currentTicket.get(0), destinations);
        }
        for(List<String> currentList : adjacencyMap.values()){
            Collections.sort(currentList);
        }
        String src="JFK";
        itinerary.add(src);
        findItineraryHelper(adjacencyMap, itinerary, src, tickets.size()+1);
        return itinerary;
    }

    private boolean findItineraryHelper(HashMap<String, List<String>> adjacencyMap, List<String> itinerary, String source, int resultSetSize) {
       // System.out.println("reached");
        if(itinerary.size() == resultSetSize){
            //System.out.println("itinerary processed");
            return true;
        }
        List<String> destinations = adjacencyMap.getOrDefault(source, new ArrayList<>());
        //System.out.println("destinations"+destinations.toString());
        if(destinations.isEmpty()){
            return false;
        }
        ArrayList<String> destinationsCopy = new ArrayList<>(destinations);

        for(int i = 0; i < destinationsCopy.size(); i ++){
            String dest = destinations.get(i);
            itinerary.add(dest);
            destinations.remove(i);
            if(findItineraryHelper(adjacencyMap, itinerary, dest, resultSetSize)){
                return true;
            }
            itinerary.remove(itinerary.size() - 1);
            destinations.add(i, dest);
        }
        return false;
    }
}
