package dao;

import dao.basedao.BaseDAO;
import pojo.Lecture;
import pojo.Student;

import java.util.List;

public interface studentDAO{
    public Student getStudentByID(Integer ID);
    public List<Student> getStudentListByTeacherID(Integer ID);

    List<Student> getStudentListBylectureID(Integer lectureID);

    Student getStudentByUsernamePassword(String username, String password);

    List<Lecture> getLectureListByStudent(Student student);

    List<Lecture> getLectureListByStudent_None(Student student);

    void registerLecture(int studentID, int lectureID);


    Student getStudentByStudentID_LectureID(int studentID, int lectureID);

    List<Student> getAllStudent();

    void addNewStudent(Student student);
}
