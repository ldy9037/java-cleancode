package domain.attendance_v2;

import java.util.ArrayList;
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
            ranking.add(search(i), i + 1);
        }

        return ranking;
    }

    private int search(int newStudent) {
        int result = 0;

        for (int student : ranking) {
            if (attendanceBook.getScore(newStudent) <= attendanceBook.getScore(student - 1)) {
                result++;
            }
        }

        return result;
    }
}
