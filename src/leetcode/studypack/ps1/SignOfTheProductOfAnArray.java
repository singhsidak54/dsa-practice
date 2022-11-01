package ps1;

public class SignOfTheProductOfAnArray {
    public int arraySign(int[] nums) {
        int negatives = 0;
        for(int num : nums) {
            if(num == 0) {
                return 0;
            } else if (num < 0) {
                negatives++;
            }
        }

        return negatives % 2 == 0 ? 1 : -1;
    }
}
