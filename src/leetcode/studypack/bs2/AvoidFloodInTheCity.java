package bs2;

import java.util.ArrayList;
import java.util.HashMap;

public class AvoidFloodInTheCity {
    public static int binarySearchJustGreater(ArrayList<Integer> zerosList, int index) {
        int l = 0, r = zerosList.size(), m;
        while (l < r) {
            m = l + (r - l)/2;
            if(zerosList.get(m) < index) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    public int[] avoidFlood(int[] rains) {
        int[] res = new int[rains.length];
        ArrayList<Integer> zeroesList = new ArrayList<>();
        HashMap<Integer, Integer> lakeMap = new HashMap<>();
        for(int i=0; i<rains.length; i++) {
            if(rains[i] == 0) {
                res[i] = 1;
                zeroesList.add(i);
            } else {
                if(lakeMap.containsKey(rains[i])) {
                    int zeroIndex = binarySearchJustGreater(zeroesList, lakeMap.get(rains[i]));
                    if(zeroIndex == zeroesList.size()) {
                        return new int[] {};
                    }

                    res[zeroesList.get(zeroIndex)] = rains[i];
                    zeroesList.remove(zeroIndex);
                    lakeMap.remove(rains[i]);
                }
                res[i] = -1;
                lakeMap.put(rains[i], i);
            }
        }
        return res;
    }
}
