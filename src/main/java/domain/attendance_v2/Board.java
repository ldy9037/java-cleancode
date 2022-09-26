package domain.attendance_v2;

import java.util.LinkedList;
import java.util.List;

public class Board {
    private LinkedList<Integer> ranking = new LinkedList<>();
    private final AttendanceBook attendanceBook;

    public Board(AttendanceBook attendanceBook) {
        this.attendanceBook = attendanceBook;
    }

    public List<Integer> ranking() {
        for (int i = 0; i < attendanceBook.count(); i++) {
            ranking.add(searchIndex(i), i + 1);
        }

        return ranking;
    }

    private int searchIndex(int newStudent) {
        int result = 0;

        for (int student : ranking) {
            if (!isGreater(newStudent, student - 1)) {
                result++;
            }
        }

        return result;
    }

    private boolean isGreater(int index, int that) {
        return (attendanceBook.getScore(index) > attendanceBook.getScore(that));
    }
}
