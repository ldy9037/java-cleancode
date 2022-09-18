package domain.attendance;

import java.util.ArrayList;
import java.util.List;

public class AttendanceBook {

    private final List<Attendance> attendanceList;

    AttendanceBook(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }

    public static AttendanceBook of(String history) {
        List<Attendance> attendances = new ArrayList<>();

        for (char attendance : history.toCharArray()) {
            attendances.add(new Attendance(attendance));
        }

        return new AttendanceBook(attendances);
    }

    public int getCountByAttendanceType(char type) {
        return (int)attendanceList.stream().filter(atd -> atd.getType() == type).count();
    }
}
