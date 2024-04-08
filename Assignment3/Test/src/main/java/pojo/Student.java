package pojo;

public class Student {
    private Integer studentID;
    private String studentUserName;
    private String studentPassword;
    private String studentName;
    private String studentPhone;
    private String studentAddress;
    private Integer studentAge;
    private Double studentQuiz = null;
    private Double studentAssignment = null;
    private Double studentFinal = null;

    public Student() {

    }

    public Student(int studentID, String studentUserName, String studentPassword) {
        this.studentID = studentID;
        this.studentUserName = studentUserName;
        this.studentPassword = studentPassword;
    }

    public Student(Integer studentID, String studentUserName, String studentPassword, String studentName, String studentPhone, String studentAddress, Integer studentAge) {
        this.studentID = studentID;
        this.studentUserName = studentUserName;
        this.studentPassword = studentPassword;
        this.studentName = studentName;
        this.studentPhone = studentPhone;
        this.studentAddress = studentAddress;
        this.studentAge = studentAge;
    }

    public String getStudentUserName() {
        return studentUserName;
    }

    public void setStudentUserName(String studentUserName) {
        this.studentUserName = studentUserName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public Double getStudentQuiz() {
        return studentQuiz;
    }

    public void setStudentQuiz(Double studentQuiz) {
        this.studentQuiz = studentQuiz;
    }

    public Double getStudentAssignment() {
        return studentAssignment;
    }

    public void setStudentAssignment(Double studentAssignment) {
        this.studentAssignment = studentAssignment;
    }

    public Double getStudentFinal() {
        return studentFinal;
    }

    public void setStudentFinal(Double studentFinal) {
        this.studentFinal = studentFinal;
    }

    public Student(Integer studentID, String studentUserName, String studentPassword, String studentName, String studentPhone, String studentAddress, Integer studentAge, Double studentQuiz, Double studentAssignment, Double studentFinal) {
        this.studentID = studentID;
        this.studentUserName = studentUserName;
        this.studentPassword = studentPassword;
        this.studentName = studentName;
        this.studentPhone = studentPhone;
        this.studentAddress = studentAddress;
        this.studentAge = studentAge;
        this.studentQuiz = studentQuiz;
        this.studentAssignment = studentAssignment;
        this.studentFinal = studentFinal;
    }
}
