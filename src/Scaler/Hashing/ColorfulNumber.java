package Scaler.Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ColorfulNumber {
    public int colorful(int A) {
        List<Integer> list = new ArrayList<>();
        while(A > 0) {
            int rem = A % 10;
            A /= 10;
            list.add(rem);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<list.size(); i++) {
            int currentProduct = list.get(i);

            if(set.contains(currentProduct)) return 0;
            set.add(currentProduct);
            for(int j=i+1; j<list.size(); j++) {
                currentProduct *= list.get(j);
                if(set.contains(currentProduct)) return 0;
                set.add(currentProduct);
            }
        }
        return 1;
    }
}
