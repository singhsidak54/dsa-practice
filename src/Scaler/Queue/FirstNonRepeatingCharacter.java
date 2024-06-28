package Scaler.Queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FirstNonRepeatingCharacter {
    public String solve(String A) {
        StringBuilder res = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        Set<Character> inQueue = new HashSet<>();
        Set<Character> toRemove = new HashSet<>();

        for(char c : A.toCharArray()) {
            if (!queue.isEmpty() && queue.peek() == c) {
                queue.poll();
            } else {
                if(inQueue.contains(c)) {
                    toRemove.add(c);
                } else {
                    inQueue.add(c);
                    queue.add(c);
                }
            }

            while (!queue.isEmpty() && toRemove.contains(queue.peek())) {
                queue.poll();
            }

            res.append(queue.isEmpty() ? "#" : queue.peek());
        }

        return res.toString();
    }

    public static void main(String[] args) {
        FirstNonRepeatingCharacter obj = new FirstNonRepeatingCharacter();
        System.out.println(obj.solve("wbtvqwblyaqpwguxbvrvntsrwfgkjvjnwpkauifymvxkllfeurhbww"));
    }
}
