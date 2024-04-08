package pojo;

public class Lecture {
    private Integer lectureID;
    private String lectureName;
    private String lectureSemester;

    public Lecture() {
    }

    public Lecture(Integer lectureID, String lectureName,String lectureSemester) {
        this.lectureID = lectureID;
        this.lectureName = lectureName;
        this.lectureSemester = lectureSemester;
    }

    public Integer getLectureID() {
        return lectureID;
    }

    public void setLectureID(Integer lectureID) {
        this.lectureID = lectureID;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getLectureSemester() {
        return lectureSemester;
    }

    public void setLectureSemester(String lectureSemester) {
        this.lectureSemester = lectureSemester;
    }
}
