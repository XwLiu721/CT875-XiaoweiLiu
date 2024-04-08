package dao.Imp;

import dao.basedao.BaseDAO;
import dao.studentDAO;
import pojo.Lecture;
import pojo.Student;
import pojo.Teacher;

import java.util.List;

public class studentDAOImp extends BaseDAO<Student> implements studentDAO {
    private lectureDAOImp lectureDAOImp = new lectureDAOImp();
    @Override
    public Student getStudentByID(Integer ID) {
        return load("select * from assignment3.student where studentID= ?",ID.intValue());
    }

    @Override
    public List<Student> getStudentListByTeacherID(Integer TeacherID) {
        return  executeQuery("SELECT * FROM assignment3.student WHERE studentID IN (SELECT studentID FROM assignment3.student_lecture WHERE lectureID IN (SELECT lectureID FROM assignment3.teacher_lecture WHERE teacherID = ?))",TeacherID.intValue());
    }

    @Override
    public List<Student> getStudentListBylectureID(Integer lectureID) {
        String sqlQuery = "SELECT t1.*, t2.studentQuiz, t2.studentAssignment, t2.studentFinal " +
                "FROM (" +
                "   SELECT * " +
                "   FROM assignment3.student " +
                "   WHERE studentID IN (" +
                "       SELECT studentID " +
                "       FROM assignment3.student_lecture " +
                "       WHERE lectureID = ?" +
                "   )" +
                ") AS t1 " +
                "LEFT JOIN (" +
                "   SELECT * " +
                "   FROM assignment3.student_lecture " +
                "   WHERE lectureID = ?" +
                ") AS t2 ON t1.studentID = t2.studentID;";
        List<Student> studentList = executeQuery(sqlQuery,lectureID.intValue(),lectureID.intValue());
        return studentList;
    }

    @Override
    public Student getStudentByUsernamePassword(String username, String password) {

        return load("select * from assignment3.student where studentUserName = ? and studentPassword = ?",username,password);
    }

    @Override
    public List<Lecture> getLectureListByStudent(Student student) {
        return lectureDAOImp.getLectureByStudentID(student.getStudentID().intValue());
    }

    @Override
    public List<Lecture> getLectureListByStudent_None(Student student) {
        return lectureDAOImp.getLectureByStudentID_None(student.getStudentID().intValue());
    }

    @Override
    public void registerLecture(int studentID, int lectureID) {
        executeUpdate("INSERT INTO assignment3.student_lecture (studentID, lectureID) VALUES (?, ?)",studentID,lectureID);
    }

    @Override
    public Student getStudentByStudentID_LectureID(int studentID, int lectureID) {
        String sqlQuery = "SELECT t1.*, t2.studentQuiz, t2.studentAssignment, t2.studentFinal " +
                "FROM (" +
                "   SELECT * " +
                "   FROM assignment3.student " +
                "   WHERE studentID IN (" +
                "       SELECT studentID " +
                "       FROM assignment3.student_lecture " +
                "       WHERE lectureID = ? and studentID=?" +
                "   )" +
                ") AS t1 " +
                "LEFT JOIN (" +
                "   SELECT * " +
                "   FROM assignment3.student_lecture " +
                "   WHERE lectureID = ? and studentID=?" +
                ") AS t2 ON t1.studentID = t2.studentID;";
        Student student = load(sqlQuery,lectureID,studentID,lectureID,studentID);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        return executeQuery("select * from assignment3.student");
    }

    @Override
    public void addNewStudent(Student student) {
        String sql = "INSERT INTO `assignment3`.`student` (`studentUserName`, `studentPassword`, `studentName`, `studentPhone`, `studentAddress`, `studentAge`) VALUES (?, ?, ?, ?, ?,?);";
        executeUpdate(sql,student.getStudentUserName(),student.getStudentPassword(),student.getStudentName(),student.getStudentPhone(),student.getStudentAddress(),student.getStudentAge());
    }


}
