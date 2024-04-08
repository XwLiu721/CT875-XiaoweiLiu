package dao;

import pojo.Admin;
import pojo.Lecture;
import pojo.Student;
import pojo.Teacher;

import java.util.List;

public interface adminDAO {
    Admin getStudentByUsernamePassword(String username, String password);

    List<Student> getStudentList();

    List<Teacher> getTeacherList();

    List<Lecture> getLectureList();
}
