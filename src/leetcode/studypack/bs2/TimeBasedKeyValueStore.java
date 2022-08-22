package bs2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeBasedKeyValueStore {
    class KeyValue {
        String value;
        int timeStamp;
        public KeyValue(String value, int timeStamp) {
            this.value = value;
            this.timeStamp = timeStamp;
        }
    }

    HashMap<String, List<KeyValue>> timeBasedMap;
    public TimeBasedKeyValueStore() {
        this.timeBasedMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!timeBasedMap.containsKey(key)) {
            timeBasedMap.put(key, new ArrayList<>());
        }

        timeBasedMap.get(key).add(new KeyValue(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<KeyValue> valuesList = timeBasedMap.get(key);
        if(valuesList == null) return "";

        int l = 1, r = valuesList.size(), m;
        while (l < r) {
            m = l + (r - l)/2;
            if(valuesList.get(m).timeStamp > timestamp) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        if(l > 0 && valuesList.get(l - 1).timeStamp <= timestamp) {
            return valuesList.get(l - 1).value;
        } else {
            return "";
        }
    }
}
