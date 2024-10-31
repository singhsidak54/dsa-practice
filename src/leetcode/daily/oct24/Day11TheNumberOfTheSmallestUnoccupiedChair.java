package daily.oct24;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Day11TheNumberOfTheSmallestUnoccupiedChair {
    class Node {
        int idx;
        int arrivalTime;
        int leavingTime;
        public Node(int idx, int[] time) {
            this.idx = idx;
            this.arrivalTime = time[0];
            this.leavingTime = time[1];
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {
        Node[] nodes = new Node[times.length];
        PriorityQueue<Integer> chairs = new PriorityQueue<>();
        for(int i=0; i<times.length; i++) {
            chairs.add(i);
            nodes[i] = new Node(i, times[i]);
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.arrivalTime, o2.arrivalTime);
            }
        });

        PriorityQueue<int[]> people = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int time, idx = 0;
        while (idx < nodes.length) {
            time = nodes[idx].arrivalTime;

            while (!people.isEmpty() && time >= people.peek()[0]) {
                int[] out = people.poll();
                chairs.add(out[1]);
            }

            if(nodes[idx].idx == targetFriend) return chairs.poll();

            people.add(new int[] {nodes[idx].leavingTime, chairs.poll()});
            idx++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Day11TheNumberOfTheSmallestUnoccupiedChair obj = new Day11TheNumberOfTheSmallestUnoccupiedChair();
        int[][] times = {{78492,88209},{21695,67063},{55011,62821},{55273,81868},{75629,91467}};
        System.out.println(obj.smallestChair(times, 4));
    }
}
