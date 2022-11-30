package daily.nov22;

import java.util.HashSet;
import java.util.Set;

public class Day4ReverseVowelsOfAString {
    public static String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');


        char[] sArray = s.toCharArray();
        int left = 0, right = sArray.length - 1;
        while (left < right) {
            while (left < right && !set.contains(sArray[left])) {
                left++;
            }

            while (right > 0 && !set.contains(sArray[right])) {
                right--;
            }

            if(left >= right) {
                break;
            }

            char temp = sArray[left];
            sArray[left] = sArray[right];
            sArray[right] = temp;

            left++;
            right--;
        }

        return new String(sArray);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }
}
