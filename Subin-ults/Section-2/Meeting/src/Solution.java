import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int maxMeetings(MeetTime[] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(m->m.endTime));
        int max=1;
        int last=meetings[0].endTime;

        for(int i=1; i<meetings.length; i++){
            if(meetings[i].startTime>=last){
                max++;
                last=meetings[i].endTime;
            }
        }
        return max;
    }
}
