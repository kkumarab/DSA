package arrays;

import java.util.*;

public class MeetingRoom3Me {
    /**
     * You are given an integer n. There are n rooms numbered from 0 to n - 1.
     * You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will be held during the half-closed time interval [starti, endi). All the values of starti are unique.
     * Meetings are allocated to rooms in the following manner:
     * Each meeting will take place in the unused room with the lowest number.
     * If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
     * When a room becomes unused, meetings that have an earlier original start time should be given the room.
     * Return the number of the room that held the most meetings. If there are multiple rooms, return the room with the lowest number.
     * A half-closed interval [a, b) is the interval between a and b including a and not including b.
     * Example 1:
     *
     * Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
     * Output: 0
     * Explanation:
     * - At time 0, both rooms are not being used. The first meeting starts in room 0.
     * - At time 1, only room 1 is not being used. The second meeting starts in room 1.
     * - At time 2, both rooms are being used. The third meeting is delayed.
     * - At time 3, both rooms are being used. The fourth meeting is delayed.
     * - At time 5, the meeting in room 1 finishes. The third meeting starts in room 1 for the time period [5,10).
     * - At time 10, the meetings in both rooms finish. The fourth meeting starts in room 0 for the time period [10,11).
     * Both rooms 0 and 1 held 2 meetings, so we return 0.
     */
    public int mostBooked(int n, int[][] meetings) {
        Map<Integer, Integer> booked = new HashMap<>();
        PriorityQueue<Room> occupied = new PriorityQueue<>((r1,r2) -> r1.end==r2.end ? Integer.compare(r1.id,r2.id) : Long.compare(r1.end,r2.end));
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            rooms.add(i);
        }
        Arrays.sort(meetings,(m1,m2) -> Integer.compare(m1[0],m2[0]));
        for(int[] meeting: meetings){
            int start = meeting[0];
            int end = meeting[1];
            while (!occupied.isEmpty() && occupied.peek().end<=start){
                rooms.add(occupied.poll().id);
            }
            while(!rooms.isEmpty()){

            }

        }
        return -1;
    }

    class Room {
        long end;
        int id;

        Room(long end, int id) {
            this.end = end;
            this.id = id;
        }
    }

    public static void main(String[] args){
        new MeetingRoom3Me().mostBooked(2,new int[][]{{0,10},{1,5},{2,7},{3,4}});
    }

}
