package dao.Imp;

import dao.basedao.BaseDAO;
import dao.teacherDAO;
import pojo.Lecture;
import pojo.Teacher;

import java.util.List;

public class teacherDAOImp extends BaseDAO<Teacher> implements teacherDAO {
    private lectureDAOImp lectureDAOImp = new lectureDAOImp();

    @Override
    public Teacher getTeacherByUsernamePassword(String username, String Password) {
        Teacher teacher = load("select * from assignment3.teacher where teacherUserName = ? and teacherPassword = ?",username,Password);
        return teacher;
    }

    @Override
    public Teacher getTeacherByID(Integer ID) {
        return load("select * from assignment3.teacher where teacherID= ?",ID.intValue());
    }

    @Override
    public List<Lecture> getLectureListByTeacher(Teacher teacher) {
        return lectureDAOImp.getLectureByTeacherID(teacher.getTeacherID());
    }

    @Override
    public List<Lecture> getLectureListByTeacher_None(Teacher teacher) {
        return lectureDAOImp.getLectureByTeacherID_None(teacher.getTeacherID());
    }

    @Override
    public void registerLecture(int teacherID, int lectureID) {
        executeUpdate("INSERT INTO assignment3.teacher_lecture (teacherID, lectureID) VALUES (?, ?)",teacherID,lectureID);

    }

    @Override
    public void updateStudentGrade(Integer studentID, Integer lectureID, Double quiz, Double assignment, Double studentFinal) {
        String sqlQuey = "UPDATE assignment3.student_lecture SET studentQuiz = ?, studentAssignment = ?, studentFinal = ? WHERE studentID = ? and lectureID = ?";
        executeUpdate(sqlQuey,quiz.doubleValue(),assignment.doubleValue(),studentFinal.doubleValue(),studentID,lectureID);

    }

    @Override
    public List<Teacher> getAllTeacher() {
        return executeQuery("select * from assignment3.teacher");
    }

    @Override
    public void addNewTeacher(Teacher teacher) {
        String sql = "INSERT INTO `assignment3`.`teacher` (`teacherName`, `teacherPhone`, `teacherAddress`, `teacherAge`, `teacherUserName`, `teacherPassword`) VALUES (?, ?, ?, ?, ?, ?);";
        executeUpdate(sql,teacher.getTeacherName(),teacher.getTeacherPhone(),teacher.getTeacherAddress(),teacher.getTeacherAge(),teacher.getTeacherUserName(),teacher.getTeacherPassword());

    }
}
