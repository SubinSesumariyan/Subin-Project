public class Meeting {
    public static void main(String[] args) {

        MeetTime[] meetings= {
                new MeetTime(30, 75),   // 00:30 - 01:15
                new MeetTime(0, 50),    // 00:00 - 00:50
                new MeetTime(60, 150),  // 01:00 - 02:30
                new MeetTime(140, 210), // 02:20 - 03:30
                new MeetTime(160, 220)  // 02:40 - 03:40

        };

        Solution solution=new Solution();
        System.out.println(solution.maxMeetings(meetings));
    }
}