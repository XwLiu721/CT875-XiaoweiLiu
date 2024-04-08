<%@ page import="pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="pojo.Lecture" %>
<%@ page import="pojo.Teacher" %>
<%@ page import="pojo.Admin" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teacher Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Custom Styles */
        .container {
            margin-top: 30px;
        }
        .title {
            text-align: center;
            margin-bottom: 30px;
        }
        .btn-back {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="title">Welcome to People Info Page, Admin <%=((Admin)session.getAttribute("currentAdmin")).getAdminName()%></h1> <!-- 添加欢迎标题 -->
    <a href="/test/index.jsp" class="btn btn-secondary btn-back">Log Out</a> <!-- 添加返回按钮 -->
    <div class="mt-5" id="studentPart">
        <%
            List<Student> studentList = (List<Student>)session.getAttribute("admin_studentList");
            List<Teacher> teacherList = (List<Teacher>)session.getAttribute("admin_teacherList");
            List<Lecture> lectureList = (List<Lecture>)session.getAttribute("admin_lectureList");
            if (studentList != null && studentList.isEmpty()) {
        %>
        <p>No Student Now.</p>
        <% } else { %>
        <h2>Students</h2>
        <table class="table table-striped">
            <tr>

                <th>UserName</th>
                <th>Password</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Age</th>
            </tr>
            <%
                if (studentList != null) {
                    for (Student student : studentList) {
            %>
            <tr>

                <td><%= student.getStudentUserName() %></td>
                <td><%= student.getStudentPassword() %></td>
                <td><%= student.getStudentName() %></td>
                <td><%= student.getStudentPhone() %></td>
                <td><%= student.getStudentAddress() %></td>
                <td><%= student.getStudentAge() %></td>
            </tr>
            <%
                    }
                }
            %>
        </table>

        <% } %>
    </div>
    <form id="userForm_student">
<%--        <label for="id_student">ID:</label><br>--%>
<%--        <input type="text" id="id_student" name="id"><br>--%>
        <label for="username_student">UserName:</label><br>
        <input type="text" id="username_student" name="username"><br>
        <label for="password_student">Password:</label><br>
        <input type="password" id="password_student" name="password"><br>
        <label for="name_student">StudentName:</label><br>
        <input type="text" id="name_student" name="name"><br>
        <label for="phone_student">Phone:</label><br>
        <input type="text" id="phone_student" name="name"><br>
        <label for="address_student">Address:</label><br>
        <input type="text" id="address_student" name="address"><br>
        <label for="age_student">Age:</label><br>
        <input type="number" id="age_student" name="age"><br><br>
        <input type="button" value="Submit" onclick="submitStudentForm()">
    </form>
    <script>
        function submitStudentForm(){
            // 获取表单中的值
            // var idValue = document.getElementById("id_student").value;
            var usernameValue = document.getElementById("username_student").value;
            var passwordValue = document.getElementById("password_student").value;
            var nameValue = document.getElementById("name_student").value;
            var phoneValue = document.getElementById("phone_student").value;
            var addressValue = document.getElementById("address_student").value;
            var ageValue = document.getElementById("age_student").value;

            // 构建URL
            var url = "/test/adminAddNewStudent?"; // 用你想要发送数据的URL替换 "your_url"

            // 将表单值添加到URL
            // url += "id=" + encodeURIComponent(idValue);
            url += "&username=" + encodeURIComponent(usernameValue);
            url += "&password=" + encodeURIComponent(passwordValue);
            url += "&name=" + encodeURIComponent(nameValue);
            url += "&phone=" + encodeURIComponent(phoneValue);
            url += "&address=" + encodeURIComponent(addressValue);
            url += "&age=" + encodeURIComponent(ageValue);

            // 发送GET请求
            window.location.href = url;
        }
    </script>

    <div class="mt-5" id="teacherPart">
        <%
            if (teacherList != null && teacherList.isEmpty()) {
        %>
        <p>No Teacher Now.</p>
        <% } else { %>
        <h2>Teachers</h2>
        <table class="table table-striped">
            <tr>

                <th>UserName</th>
                <th>Password</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Age</th>
            </tr>
            <%
                if (teacherList != null) {
                    for (Teacher teacher : teacherList) {
            %>
            <tr>

                <td><%= teacher.getTeacherUserName() %></td>
                <td><%= teacher.getTeacherPassword() %></td>
                <td><%= teacher.getTeacherName() %></td>
                <td><%= teacher.getTeacherPhone() %></td>
                <td><%= teacher.getTeacherAddress() %></td>
                <td><%= teacher.getTeacherAge() %></td>
            </tr>
            <%
                    }
                }
            %>
        </table>

        <% } %>
    </div>
    <form id="userForm_teacher">
        <label for="username_teacher">UserName:</label><br>
        <input type="text" id="username_teacher" name="username"><br>
        <label for="password_teacher">Password:</label><br>
        <input type="password" id="password_teacher" name="password"><br>
        <label for="name_teacher">TeacherName:</label><br>
        <input type="text" id="name_teacher" name="name"><br>
        <label for="phone_teacher">Phone:</label><br>
        <input type="text" id="phone_teacher" name="phone"><br>
        <label for="address_teacher">Address:</label><br>
        <input type="text" id="address_teacher" name="address"><br>
        <label for="age_teacher">Age:</label><br>
        <input type="number" id="age_teacher" name="age"><br><br>
        <input type="button" value="Submit" onclick="submitTeacherForm()">

    </form>
    <script>
        function submitTeacherForm(){
            var usernameValue = document.getElementById("username_teacher").value;
            var passwordValue = document.getElementById("password_teacher").value;
            var nameValue = document.getElementById("name_teacher").value;
            var phoneValue = document.getElementById("phone_teacher").value;
            var addressValue = document.getElementById("address_teacher").value;
            var ageValue = document.getElementById("age_teacher").value;


            // 构建URL
            var url = "/test/adminAddNewTeacher?"; // 用你想要发送数据的URL替换 "your_url"

            // 将表单值添加到URL
            // url += "id=" + encodeURIComponent(idValue);
            url += "&username=" + encodeURIComponent(usernameValue);
            url += "&password=" + encodeURIComponent(passwordValue);
            url += "&name=" + encodeURIComponent(nameValue);
            url += "&phone=" + encodeURIComponent(phoneValue);
            url += "&address=" + encodeURIComponent(addressValue);
            url += "&age=" + encodeURIComponent(ageValue);

            // 发送GET请求
            window.location.href = url;
        }
    </script>

    <div class="mt-5" id="lecturePart">
        <%
            if (lectureList != null && lectureList.isEmpty()) {
        %>
        <p>No Lecture Now.</p>
        <% } else { %>
        <h2>Lectures</h2>
        <table class="table table-striped">
            <tr>

                <th>Name</th>
                <th>Semester</th>

            </tr>
            <%
                if (lectureList != null) {
                    for (Lecture lecture : lectureList) {
            %>
            <tr>

                <td><%= lecture.getLectureName() %></td>
                <td><%= lecture.getLectureSemester() %></td>
            </tr>
            <%
                    }
                }
            %>
        </table>

        <% } %>
    </div>
    <form id="userForm_lecture">
        <label for="name_lecture">LectureName:</label><br>
        <input type="text" id="name_lecture" name="name"><br>
        <label for="semester_lecture">LectureSemester:</label><br>
        <input type="text" id="semester_lecture" name="semester"><br>
        <input type="button" value="Submit" onclick="submitLectureForm()">

    </form>
    <script>
        function submitLectureForm(){

            var nameValue = document.getElementById("name_lecture").value;
            var semesterValue = document.getElementById("semester_lecture").value;


            // 构建URL
            var url = "/test/adminAddNewLecture?"; // 用你想要发送数据的URL替换 "your_url"

            // 将表单值添加到URL
            // url += "id=" + encodeURIComponent(idValue);

            url += "&name=" + encodeURIComponent(nameValue);
            url += "&semester=" + encodeURIComponent(semesterValue);


            // 发送GET请求
            window.location.href = url;
        }
    </script>

</div>
<!-- Bootstrap JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
