package bs1;

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length, mid;
        while (low < high) {
            mid = low + (high - low)/2;
            if(letters[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return letters[low % letters.length];
    }
}
