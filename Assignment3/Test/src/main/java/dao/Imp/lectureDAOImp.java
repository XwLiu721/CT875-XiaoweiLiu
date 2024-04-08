package dao.Imp;

import dao.basedao.BaseDAO;
import pojo.Lecture;
import dao.lectureDAO;
import pojo.Student;

import java.util.List;

public class lectureDAOImp extends BaseDAO<Lecture> implements lectureDAO {

    @Override
    public Lecture getLectureByID(Integer ID) {
        return load("select * from assignment3.lecture where lectureID = ?",ID.intValue());
    }

    @Override
    public List<Lecture> getLectureByStudentID(Integer ID) {
        return executeQuery("select * from assignment3.lecture where lectureID in (select lectureID from assignment3.student_lecture where studentID = ?)",ID.intValue());

    }

    @Override
    public List<Lecture> getLectureByStudentID_None(Integer ID) {
        return executeQuery("select * from assignment3.lecture where lectureID not in (select lectureID from assignment3.student_lecture where studentID = ?)",ID.intValue());
    }

    @Override
    public List<Lecture> getLectureByTeacherID(Integer ID) {
        return executeQuery("select * from assignment3.lecture where lectureID in (select lectureID from assignment3.teacher_lecture where teacherID = ?)",ID.intValue());
    }

    @Override
    public List<Lecture> getLectureByTeacherID_None(Integer ID) {
        return executeQuery("select * from assignment3.lecture where lectureID not in (select lectureID from assignment3.teacher_lecture where teacherID = ?)",ID.intValue());
    }

    @Override
    public List<Lecture> getAllLecture() {

        return executeQuery("select * from assignment3.lecture");
    }

    @Override
    public void addNewLecture(Lecture lecture) {
        String sql = "INSERT INTO `assignment3`.`lecture` (`lectureName`,`lectureSemester`) VALUES (?,?);";
        executeUpdate(sql,lecture.getLectureName(),lecture.getLectureSemester());
    }
}
