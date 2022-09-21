package domain.attendance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class AttendanceBook {
    
    private final List<Attendances> attendancesList;

    AttendanceBook(List<Attendances> attendancesList) {
        this.attendancesList = attendancesList;
    }

    public static AttendanceBook of(String... attendancesArr) {
        return new AttendanceBook(convertAttendancesList(attendancesArr));
    }

    private static List<Attendances> convertAttendancesList(String... attendancesArr) {
        List<Attendances> result = new ArrayList<>();

        for (String attendances : attendancesArr) {
            result.add(Attendances.of(attendances));
        }

        return result;
    }

    public List<Integer> ranking() {
        PriorityQueue queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < attendancesList.size(); i++) {
            AttendanceRule attendanceRule = new AttendanceRule();

            attendanceRule.calculate(attendancesList.get(i).getStatus());
            queue.add(new Score(i, attendanceRule.getScore()));
        }

        return toList(queue);
    }

    private List<Integer> toList(PriorityQueue queue) {
        List<Integer> result = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            Score score = (Score) queue.poll();
            result.add(score.getNumber());
        }

        return result;
    }
}
