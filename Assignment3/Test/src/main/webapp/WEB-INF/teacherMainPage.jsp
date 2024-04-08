<%@ page import="pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="pojo.Lecture" %>
<%@ page import="pojo.Teacher" %>
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
    <h1 class="title">Welcome to Lecture Page, Teacher <%=((Teacher)session.getAttribute("currentTeacher")).getTeacherName()%></h1> <!-- 添加欢迎标题 -->
    <a href="/test/index.jsp" class="btn btn-secondary btn-back">Log Out</a> <!-- 添加返回按钮 -->
    <div class="mt-5">
        <%
            List<Lecture> lectureList = (List<Lecture>)session.getAttribute("teacher_lectureList");
            if (lectureList != null && lectureList.isEmpty()) {
        %>
        <p>No lectures have been registered by you.</p>
        <% } else { %>
        <h2>Chosen Lectures</h2>
        <table class="table table-striped">
            <tr>

                <th>Name</th>
                <th>Semester</th>
                <th>View</th>
            </tr>
            <%
                if (lectureList != null) {
                    for (Lecture lecture : lectureList) {
            %>
            <tr>

                <td><%= lecture.getLectureName() %></td>
                <td><%= lecture.getLectureSemester() %></td>
                <td><a href="/test/StudentOfLecture?lectureID=<%= lecture.getLectureID() %>" class="btn btn-info">View</a></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
        <% } %>
    </div>

    <div class="mt-5">
        <h2>Unchosen Lectures</h2>
        <%
            List<Lecture> lectureList_None = (List<Lecture>)session.getAttribute("teacher_lectureList_None");
            if (lectureList_None != null && lectureList_None.isEmpty()) {
        %>
        <p>You have registered all available lectures.</p>
        <% } else { %>
        <table class="table table-striped">
            <tr>

                <th>Name</th>
                <th>Semester</th>
                <th>Register</th>
            </tr>
            <%
                int teacherID = ((Teacher)session.getAttribute("currentTeacher")).getTeacherID().intValue();
                if (lectureList_None != null) {
                    for (Lecture lecture : lectureList_None) {
            %>
            <tr>

                <td><%= lecture.getLectureName() %></td>
                <td><%= lecture.getLectureSemester() %></td>
                <td><a href="/test/teacherRegisterLecture?teacherID=<%= teacherID %>&lectureID=<%= lecture.getLectureID() %>" class="btn btn-success">Register</a></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
        <% } %>
    </div>
</div>
<!-- Bootstrap JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
