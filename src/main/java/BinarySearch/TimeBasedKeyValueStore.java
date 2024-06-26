package BinarySearch;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {

    private Map<String, List<Pair<Integer,String>>> timeMap;

    public TimeBasedKeyValueStore() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = timeMap.getOrDefault(key, new ArrayList<>());
        int left = 0;
        int right = values.size() -  1;
        String result = "";

        while(left <= right){
            int mid = left + (right - left)/2;
            if(values.get(mid).getKey() <= timestamp){
                result = values.get(mid).getValue();
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return  result;
    }

    public static void main(String[] args){
        TimeBasedKeyValueStore timeMap = new TimeBasedKeyValueStore();
        timeMap.set("alice", "happy", 1);  // store the key "alice" and value "happy" along with timestamp = 1.
        Assert.assertEquals(timeMap.get("alice", 1), "happy");        // return "happy"
        Assert.assertEquals(timeMap.get("alice", 2), "happy");          // return "happy", there is no value stored for timestamp 2, thus we return the value at timestamp 1.
        timeMap.set("alice", "sad", 3);    // store the key "alice" and value "sad" along with timestamp = 3.
        Assert.assertEquals(timeMap.get("alice", 3),"sad");
    }
}

class Pair<S, V>{
    private final S key;
    private final V value;

    public Pair(S key, V value){
        this.key = key;
        this.value = value;
    }

    public S getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }
}
