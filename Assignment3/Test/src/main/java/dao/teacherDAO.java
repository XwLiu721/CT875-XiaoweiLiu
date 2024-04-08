package dao;

import pojo.Lecture;
import pojo.Teacher;

import java.util.List;

public interface teacherDAO {
    public Teacher getTeacherByUsernamePassword(String useername, String Password);
    public Teacher getTeacherByID(Integer ID);
    List<Lecture> getLectureListByTeacher(Teacher teacher);
    List<Lecture> getLectureListByTeacher_None(Teacher teacher);


    void registerLecture(int teacherID, int lectureID);

    void updateStudentGrade(Integer studentID, Integer lectureID, Double quiz, Double assignment, Double studentFinal);

    List<Teacher> getAllTeacher();

    void addNewTeacher(Teacher teacher);
}
