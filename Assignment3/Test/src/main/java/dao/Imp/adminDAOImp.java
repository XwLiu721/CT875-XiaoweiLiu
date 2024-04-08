package dao.Imp;

import dao.basedao.BaseDAO;
import pojo.Admin;
import dao.adminDAO;
import pojo.Lecture;
import pojo.Student;
import pojo.Teacher;

import java.util.List;

public class adminDAOImp extends BaseDAO<Admin> implements adminDAO{
    private studentDAOImp studentDAOImp = new studentDAOImp();
    private teacherDAOImp teacherDAOImp = new teacherDAOImp();
    private lectureDAOImp lectureDAOImp = new lectureDAOImp();
    @Override
    public Admin getStudentByUsernamePassword(String username, String password) {
        return load("select * from assignment3.admin where adminUserName =? and adminPassword=?",username,password);
    }

    @Override
    public List<Student> getStudentList() {
        return studentDAOImp.getAllStudent();
    }

    @Override
    public List<Teacher> getTeacherList() {
        return teacherDAOImp.getAllTeacher();
    }

    @Override
    public List<Lecture> getLectureList() {
        return lectureDAOImp.getAllLecture();
    }
}
