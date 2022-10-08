package daily.oct22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day6TimeBasedKeyValueStore {
    class Node {
        String value;
        int timestamp;
        public Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    HashMap<String, List<Node>> map;
    public Day6TimeBasedKeyValueStore() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!this.map.containsKey(key)) {
            this.map.put(key, new ArrayList<>());
        }

        this.map.get(key).add(new Node(value, timestamp));
    }

    private int binarySearchHelper(List<Node> list, int timestamp) {
        int l = 0, r = list.size(), m;
        while (l < r) {
            m = l + (r - l)/2;
            if(list.get(m).timestamp > timestamp) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public String get(String key, int timestamp) {
        List<Node> keyValueList = this.map.get(key);
        if(keyValueList == null) return "";

        int index = binarySearchHelper(keyValueList, timestamp);

        if(index > 0 && keyValueList.get(index - 1).timestamp < timestamp) {
            return keyValueList.get(index - 1).value;
        } else {
            return "";
        }
    }
}
