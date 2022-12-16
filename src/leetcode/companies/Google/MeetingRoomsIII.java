package companies.Google;

import java.util.*;

public class MeetingRoomsIII {
    public static int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> availableRoomPq = new PriorityQueue<>();
        PriorityQueue<long[]> meetingsPq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[0] == o2[0]) {
                    return Long.compare(o1[1], o2[1]);
                }
                return Long.compare(o1[0], o2[0]);
            }
        });
        int[] roomMeetingCount = new int[n];
        int meetingPtr = 0;
        long t = 0;

        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for(int i=0; i<n; i++) {
            availableRoomPq.add(i);
        }

        while (meetingPtr < meetings.length) {
            if(availableRoomPq.isEmpty() && !meetingsPq.isEmpty()) {
                t = meetingsPq.peek()[0];
            }

            if(!availableRoomPq.isEmpty() && t < meetings[meetingPtr][0]) {
                t = meetings[meetingPtr][0];
            }

            while (!meetingsPq.isEmpty() && meetingsPq.peek()[0] <= t) {
                long[] meeting = meetingsPq.poll();
                availableRoomPq.add((int) meeting[1]);
            }

            while (!availableRoomPq.isEmpty() && meetingPtr < meetings.length && t >= meetings[meetingPtr][0]) {
                int room = availableRoomPq.poll();
                int duration = meetings[meetingPtr][1] - meetings[meetingPtr][0];
                meetingsPq.add(new long[] {t + duration, room});
                roomMeetingCount[room]++;
                meetingPtr++;
            }

            t++;
        }

        int maxRoomIdx = 0;
        for(int i=1; i<n; i++) {
            if(roomMeetingCount[i] > roomMeetingCount[maxRoomIdx]) {
                maxRoomIdx = i;
            }
        }

        return maxRoomIdx;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] meetings = {{43,44},{34,36},{11,47},{1,8},{30,33},{45,48},{23,41},{29,30}};

        System.out.println(mostBooked(n, meetings));
    }
}
