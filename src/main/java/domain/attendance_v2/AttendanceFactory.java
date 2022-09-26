package domain.attendance_v2;

import java.util.List;
import java.util.stream.Collectors;

public class AttendanceFactory {
    private Type selectType(char typeName) {
        switch (typeName) {
            case Attendance.TYPE:
                return new Attendance();
            case Absence.TYPE:
                return new Absence();
            case Late.TYPE:
                return new Late();
            default :
                throw new IllegalArgumentException("유효하지 않은 출석 유형입니다.");
        }
    }

    public List<Type> createTypeList(String attendances) {
        return attendances.chars()
                    .mapToObj(i -> selectType((char)i))
                    .collect(Collectors.toList());
    }
}
