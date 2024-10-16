package arrays;

import java.util.*;

public class MeetingRoom3 {
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

        // Map to keep track of the number of times each room has been booked
        Map<Integer, Integer> booked = new HashMap<>();

        // Priority queue to manage rooms by their end time
        PriorityQueue<Room> pq = new PriorityQueue<>(new Comparator<Room>() {
            public int compare(Room a, Room b) {
                if (a.end == b.end) {
                    return Integer.compare(a.id, b.id); // room id in ascending order
                }
                return Long.compare(a.end, b.end); // end time in ascending order
            }
        });

        // Min-heap to manage free rooms
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();

        // Initialize freeRooms with all room ids
        for (int i = 0; i < n; i++) {
            freeRooms.add(i);
        }

        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Long.compare(a[0], b[0]));

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];

            // Free up rooms that have finished their meetings
            while (!pq.isEmpty() && pq.peek().end <= start) {
                freeRooms.add(pq.poll().id);
            }

            if (!freeRooms.isEmpty()) {
                // Assign a free room
                int roomId = freeRooms.poll();
                booked.put(roomId, booked.getOrDefault(roomId, 0) + 1);
                pq.add(new Room(end, roomId));
            } else {
                // No free rooms, find the room with the earliest end time
                Room room = pq.poll();
                booked.put(room.id, booked.getOrDefault(room.id, 0) + 1);
                pq.add(new Room(room.end + (end - start), room.id));
            }
        }

        // Find the room with the maximum number of bookings
        int maxBookings = 0;
        int meetingRoom = -1;
        for (Map.Entry<Integer, Integer> entry : booked.entrySet()) {
            if (entry.getValue() > maxBookings) {
                maxBookings = entry.getValue();
                meetingRoom = entry.getKey();
            }
        }

        return meetingRoom;
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
        new MeetingRoom3().mostBooked(2,new int[][]{{0,10},{1,5},{2,7},{3,4}});
    }

}
