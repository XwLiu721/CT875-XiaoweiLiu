package pojo;

public class Teacher {
    private Integer teacherID;
    private String teacherName;
    private String teacherPhone;
    private String teacherAddress;
    private Integer teacherAge;
    private String teacherUserName;
    private String teacherPassword;

    public Teacher() {
    }

    public Teacher(Integer teacherID, String teacherName, String teacherPhone, String teacherAddress, Integer teacherAge, String teacherUserName, String teacherPassword) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.teacherPhone = teacherPhone;
        this.teacherAddress = teacherAddress;
        this.teacherAge = teacherAge;
        this.teacherUserName = teacherUserName;
        this.teacherPassword = teacherPassword;
    }

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getTeacherUserName() {
        return teacherUserName;
    }

    public void setTeacherUserName(String teacherUserName) {
        this.teacherUserName = teacherUserName;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }
}
