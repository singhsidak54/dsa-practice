package companies.Google;

import java.util.*;

public class LoggerRateLimiter {

    /* PQ and Set Solution */
    class Node {
        int timestamp;
        String message;
        public Node(int timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }
    }

    PriorityQueue<Node> pq;
    Set<String> messages;

    /* Hashmap Solution */
    HashMap<String, Integer> messageMap;

    /* Set Solution */
    HashMap<String, Integer> oldMap;
    HashMap<String, Integer> newMap;
    int firstTimestampOfNewMap;

    public LoggerRateLimiter() {
        messageMap = new HashMap<>();
        pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.timestamp, o2.timestamp);
            }
        });
        messages = new HashSet<>();
        newMap = new HashMap<>();
    }

    /* Hashmap Solution */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(messageMap.getOrDefault(message, 0) > timestamp) {
            return false;
        }

        messageMap.put(message, timestamp + 10);
        return true;
    }

    /* PQ and Set Solution */
    public boolean shouldPrintMessagePQ(int timestamp, String message) {
        while (!pq.isEmpty() && pq.peek().timestamp <= timestamp) {
            Node curr = pq.poll();
            messages.remove(curr.message);
        }

        if(messages.contains(message)) {
            return false;
        } else {
            pq.add(new Node(timestamp + 10, message));
            messages.add(message);
            return true;
        }
    }

    public boolean shouldPrintMessageSetSolution(int timestamp, String message) {
        if(firstTimestampOfNewMap + 20 <= timestamp) {
            oldMap.clear();
            newMap.clear();
            firstTimestampOfNewMap = timestamp;
        } else if (firstTimestampOfNewMap + 10 <= timestamp) {
            oldMap = newMap;
            newMap = new HashMap<>();
            firstTimestampOfNewMap = timestamp;
        }

        if(newMap.containsKey(message)) {
            return false;
        } else if (oldMap.getOrDefault(message, 0) < timestamp) {
            return false;
        }

        newMap.put(message, timestamp + 10);
        return true;
    }
}
