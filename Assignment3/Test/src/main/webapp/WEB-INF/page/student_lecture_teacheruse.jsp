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
  <script>
    function submitForm(studentID, lectureID) {
      var quizInput = document.getElementById("quizInput" + studentID);
      var assignmentInput = document.getElementById("assignmentInput" + studentID);
      var finalInput = document.getElementById("finalInput" + studentID);

      var quiz = quizInput.value !== "" ? quizInput.value : quizInput.placeholder;
      var assignment = assignmentInput.value !== "" ? assignmentInput.value : assignmentInput.placeholder;
      var final = finalInput.value !== "" ? finalInput.value : finalInput.placeholder;
      if (quiz > 100) { quiz = -1; }
      if (quiz < 0) { quiz = -1; }
      if (assignment > 100) { assignment = -1; }
      if (assignment < 0) { assignment = -1; }
      if (final > 100) { final = -1; }
      if (final < 0) { final = -1; }

      var url = "/test/student_update_lecture_grade?studentID=" + studentID + "&lectureID=" + lectureID + "&quiz=" + quiz + "&assignment=" + assignment + "&final=" + final;

      window.location.href = url;
    }
  </script>
</head>
<body>
<div class="container">
  <h1>Welcome to Student Grade Page, Teacher <%=((Teacher)session.getAttribute("currentTeacher")).getTeacherName()%></h1>
  <p class="text-muted">Note: Score of -1 indicates that the teacher has not yet graded.</p>
  <a href="/test/teacherMainPage" class="btn btn-secondary btn-back">Return to Lecture Page</a>
  <%
    Lecture lecture = (Lecture)session.getAttribute("currentLecture");
    List<Student> studentList = (List<Student>)session.getAttribute("lecture_studentList");

    if(studentList != null && !studentList.isEmpty()) {
  %>
  <h2>Students of Lecture <%= lecture.getLectureName() %></h2>
  <table class="table table-striped">
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Quiz</th>
      <th>Assignment</th>
      <th>Final</th>
      <th>Overall Grade</th>
    </tr>
    <%
      for(Student student : studentList) {
        double quiz = student.getStudentQuiz() == -1 ? -1 : student.getStudentQuiz();
        double assignment = student.getStudentAssignment() == -1 ? -1 : student.getStudentAssignment();
        double studentFinal = student.getStudentFinal() == -1 ? -1 : student.getStudentFinal();
        String overall = (quiz != -1 && assignment != -1 && studentFinal != -1) ? ("" + String.format("%.1f", (student.getStudentQuiz() + student.getStudentAssignment() + student.getStudentFinal()) / 3)) : "NA";
    %>
    <tr>
      <td><%= student.getStudentID() %></td>
      <td><%= student.getStudentName() %></td>
      <td><input type="number" min="0" max="100" placeholder=<%= quiz %> id="quizInput<%= student.getStudentID() %>"></td>
      <td><input type="number" min="0" max="100" placeholder=<%= assignment %> id="assignmentInput<%= student.getStudentID() %>"></td>
      <td><input type="number" min="0" max="100" placeholder=<%= studentFinal %> id="finalInput<%= student.getStudentID() %>"></td>
      <td><%= overall %></td>
      <td><a href="#" class="btn btn-info" onclick="submitForm(<%= student.getStudentID() %>,<%= lecture.getLectureID() %>)">Submit</a></td>
    </tr>
    <%
      }
    %>
  </table>
  <% } else { %>
  <p>No students are enrolled in this lecture.</p>
  <% } %>
</div>
<!-- Bootstrap JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
