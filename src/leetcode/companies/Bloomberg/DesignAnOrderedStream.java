package companies.Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class DesignAnOrderedStream {
    String[] stream;
    int ptr;
    public DesignAnOrderedStream(int n) {
        stream = new String[n];
        ptr = 0;
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey] = value;
        List<String> result = new ArrayList<>();
        while (ptr < stream.length && stream[ptr] != null) {
            result.add(stream[ptr]);
            ptr++;
        }
        return result;
    }
}
