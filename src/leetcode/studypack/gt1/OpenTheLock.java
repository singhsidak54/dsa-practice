package gt1;

import java.util.*;

public class OpenTheLock {
    public static int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if(visited.contains("0000")) return -1;

        Queue<String> queue = new ArrayDeque<>();
        queue.add("0000");
        visited.add("0000");
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String curr = queue.poll();
                if(curr.equals(target)) return steps;

                char[] charArray = curr.toCharArray();
                for(int j=0; j<4; j++) {
                    int temp = charArray[j] - '0';
                    charArray[j] = temp == 0 ? '9' : (char) (temp - 1 + '0');
                    String next = new String(charArray);
                    if(!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }

                    charArray[j] = temp == 9 ? '0' : (char) (temp + 1 + '0');
                    next = new String(charArray);
                    if(!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }

                    charArray[j] = (char) (temp + '0');
                }
            }
            steps++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[] {"8888"}, "0009"));
    }
}
