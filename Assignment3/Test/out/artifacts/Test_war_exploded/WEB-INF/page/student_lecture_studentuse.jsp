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
      margin-top: 50px;
    }
    h1 {
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
  <h1>Welcome to Student Grade Page, Student <%=((Student)session.getAttribute("currentStudent")).getStudentName()%></h1>
  <p class="text-muted">Note: Score of -1 indicates that the teacher has not yet graded.</p>

  <a href="/test/studentMainPage" class="btn btn-secondary btn-back">Return to Lecture Page</a>
  <%
    Lecture lecture = (Lecture)session.getAttribute("currentLecture");
    Student student = (Student)session.getAttribute("lecture_student");


  %>
  <h2>Grade of Lecture <%= lecture.getLectureName() %></h2>
  <table class="table table-striped">
    <tr>
      <th>Quiz</th>
      <th>Assignment</th>
      <th>Final</th>
      <th>Overall Grade</th>
    </tr>
    <%

        double quiz = student.getStudentQuiz() == -1 ? -1 : student.getStudentQuiz();
        double assignment = student.getStudentAssignment() == -1 ? -1 : student.getStudentAssignment();
        double studentFinal = student.getStudentFinal() == -1 ? -1 : student.getStudentFinal();
        String overall = (quiz != -1 && assignment != -1 && studentFinal != -1) ? ("" + String.format("%.1f", (student.getStudentQuiz() + student.getStudentAssignment() + student.getStudentFinal()) / 3)) : "NA";
    %>
    <tr>
      <td><%= quiz %> </td>
      <td><%= assignment %> </td>
      <td><%= studentFinal %> </td>
      <td><%= overall %></td>

    </tr>

  </table>

</div>
<!-- Bootstrap JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
