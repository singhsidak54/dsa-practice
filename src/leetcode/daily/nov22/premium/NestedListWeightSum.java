package daily.nov22.premium;

import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
    // Constructor initializes an empty nested list.
    // public NestedInteger();
    // Constructor initializes a single integer.
    // public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedListWeightSum {
    int ans = 0;
    public void depthSum(List<NestedInteger> nestedList, int depth) {
        for(NestedInteger nestedInteger : nestedList) {
            if(nestedInteger.isInteger()) {
                ans += (nestedInteger.getInteger() * depth);
            } else {
                depthSum(nestedInteger.getList(), depth + 1);
            }
        }
    }

    public int depthSum(List<NestedInteger> nestedList) {
        depthSum(nestedList, 1);
        return ans;
    }
}
