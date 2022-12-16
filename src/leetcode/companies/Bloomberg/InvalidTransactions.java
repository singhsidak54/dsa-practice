package companies.Bloomberg;

import java.util.*;

public class InvalidTransactions {
    static class Node {
        int index;
        int time;
        String city;
        public Node(int index, int time, String city) {
            this.index = index;
            this.time = time;
            this.city = city;
        }
    }

    public static List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        HashMap<String, List<Node>> nameMap = new HashMap<>();
        boolean[] valid = new boolean[n];

        for(int i=0; i<n; i++) {
            String[] transaction = transactions[i].split(",");

            String name = transaction[0], city = transaction[3];
            int time = Integer.parseInt(transaction[1]), amount = Integer.parseInt(transaction[2]);

            List<Node> currentList = nameMap.getOrDefault(name, new ArrayList<>());
            boolean isValid = true;

            if(amount > 1000) {
                isValid = false;
            }

            int startTime = time - 60, endTime = time + 60;
            for(Node node : currentList) {
                if(node.time < startTime || node.time > endTime) continue;

                if(!node.city.equals(city)) {
                    isValid = false;
                    valid[node.index] = false;
                }
            }

            currentList.add(new Node(i, time, city));
            nameMap.put(name, currentList);
            if(isValid) {
                valid[i] = true;
            }
        }

        List<String> result = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(!valid[i]) {
                result.add(transactions[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] query = {"alice,20,800,mtv","bob,50,1200,mtv","alice,20,800,mtv","alice,50,1200,mtv","alice,20,800,mtv","alice,50,100,beijing"};

        System.out.println(invalidTransactions(query));
    }
}
