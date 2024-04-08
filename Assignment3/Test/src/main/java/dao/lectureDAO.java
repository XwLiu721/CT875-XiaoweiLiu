package dao;

import pojo.Lecture;
import pojo.Student;

import java.util.List;

public interface lectureDAO {
    public Lecture getLectureByID(Integer ID);
    public List<Lecture> getLectureByStudentID(Integer ID);
    public List<Lecture> getLectureByStudentID_None(Integer ID);
    public List<Lecture> getLectureByTeacherID(Integer ID);
    public List<Lecture> getLectureByTeacherID_None(Integer ID);
    public List<Lecture> getAllLecture();

    void addNewLecture(Lecture lecture);
}
