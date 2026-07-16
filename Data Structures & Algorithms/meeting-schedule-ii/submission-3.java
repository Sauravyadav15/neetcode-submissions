class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> roomEnd = new PriorityQueue<>();
        int maxRooms = 0;

        for (Interval in : intervals) {

            // free rooms that have ended
            if (!roomEnd.isEmpty() && roomEnd.peek() <= in.start) {
                roomEnd.poll();
            }

            // allocate room
            roomEnd.add(in.end);

            // track maximum rooms used
            maxRooms = Math.max(maxRooms, roomEnd.size());
        }

        return maxRooms;
    }
}
