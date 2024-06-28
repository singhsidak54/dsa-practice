package daily.apr23;

import java.util.Arrays;

public class Day3BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0, right = people.length - 1;
        int boats = 0;
        while (left <= right) {
            while (right > left && people[right] + people[left] > limit) {
                right--;
                boats++;
            }

            boats++;
            right--;
            left++;
        }

        return boats;
    }
}
