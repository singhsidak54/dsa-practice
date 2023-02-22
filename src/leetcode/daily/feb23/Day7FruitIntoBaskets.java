package daily.feb23;

import java.util.HashMap;

public class Day7FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int ans = 0, start = 0;
        HashMap<Integer, Integer> fruitMap = new HashMap<>();

        for(int end=0; end<fruits.length; end++) {
            fruitMap.put(fruits[end], fruitMap.getOrDefault(fruits[end], 0) + 1);

            while (fruitMap.size() > 2) {
                int outgoingFruitCount = fruitMap.get(fruits[start]) - 1;
                if (outgoingFruitCount == 0) {
                    fruitMap.remove(fruits[start]);
                } else {
                    fruitMap.put(fruits[start], outgoingFruitCount);
                }
                start++;
            }

            ans = Math.max(ans, end - start + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        Day7FruitIntoBaskets obj = new Day7FruitIntoBaskets();
        System.out.println(obj.totalFruit(fruits));
    }
}
