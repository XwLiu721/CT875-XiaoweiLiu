<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>noMemberFound</title>
  <!-- 引入 Bootstrap 样式 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container">
  <div class="row mt-5">
    <div class="col-md-6 offset-md-3">
      <div class="card">
        <div class="card-header">
          <h5 class="card-title">Member Not Found</h5>
        </div>
        <div class="card-body">
          <% String username = request.getParameter("username");
            String role = request.getParameter("role");
          %>
          <p class="card-text">
            Username: <b><%= username %></b> is not found in the System with the role of <b><%= role %></b>

          </p>
          <p class="card-text">
            please re-check your username and password
          </p>
          <a href="/test/index.jsp" class="btn btn-secondary">Return to HomePage</a>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- 引入 Bootstrap JavaScript 插件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
