package domain.attendance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Attendances {
    
    private final List<Attendance> attendances;

    Attendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public static Attendances of(String attendancesString) {
        return new Attendances(convertAttendances(attendancesString));
    }

    private static List<Attendance> convertAttendances(String attendancesString) {
        return attendancesString.chars()
                        .mapToObj(i -> new Attendance((char)i))
                        .collect(Collectors.toList());
    }

    public Map<Attendance, Integer> getStatus() {
        Map<Attendance, Integer> result = new HashMap<>();
        
        for (char type : Attendance.TYPES) {
            result.put(new Attendance(type), countByType(type));
        }
        
        return result;
    }

    private int countByType(char typeName) {
        return (int) attendances.stream()
                    .filter(attendance -> attendance.getType() == typeName)
                    .count();
    }
}
