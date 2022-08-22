package bs2;

import java.util.ArrayList;
import java.util.List;

public class SnapshotArray {
    int snapId;
    List<int[]>[] snapArray;
    public SnapshotArray(int length) {
        this.snapId = 0;
        this.snapArray = new List[length];
        for(int i=0; i<length; i++) {
            snapArray[i] = new ArrayList<>();
            snapArray[i].add(new int[] {0, 0});
        }
    }

    public void set(int index, int val) {
        this.snapArray[index].add(new int[] {this.snapId, val});
    }

    public int snap() {
        return this.snapId++;
    }

    private int binarySearchIndex(List<int[]> recordHistory, int snapId) {
        int l = 0, r = recordHistory.size(), m;
        while (l < r) {
            m = l + (r - l)/2;
            if(recordHistory.get(m)[0] > snapId) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public int get(int index, int snap_id) {
        List<int[]> recordList = snapArray[index];
        int snapIndexJustGreater = this.binarySearchIndex(recordList, snap_id);
        return recordList.get(snapIndexJustGreater - 1)[1];
    }
}
