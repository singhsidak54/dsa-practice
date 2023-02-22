package companies.Bloomberg;

import java.util.HashMap;
import java.util.Stack;

public class MaximumFrequencyStackOptimised {

    HashMap<Integer, Stack<Integer>> stackHashMap;
    HashMap<Integer, Integer> frequencyMap;
    int maxFreq;
    public MaximumFrequencyStackOptimised() {
        stackHashMap = new HashMap<>();
        frequencyMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int newFreq = frequencyMap.getOrDefault(val, 0) + 1;
        maxFreq = Math.max(maxFreq, newFreq);

        Stack<Integer> newFreqStack = stackHashMap.getOrDefault(newFreq, new Stack<>());
        newFreqStack.add(val);
        stackHashMap.put(newFreq, newFreqStack);
        frequencyMap.put(val, newFreq);
    }

    public int pop() {
        Stack<Integer> maxFreqStack = stackHashMap.get(maxFreq);
        int toRemove = maxFreqStack.pop();
        frequencyMap.put(toRemove, maxFreq - 1);
        if(maxFreqStack.size() == 0) {
            maxFreq--;
        }

        return toRemove;
    }

    public static void main(String[] args) {
        MaximumFrequencyStackOptimised obj = new MaximumFrequencyStackOptimised();
        obj.push(5);
        obj.push(7);
        obj.push(5);
        obj.push(7);
        obj.push(4);
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }
}
