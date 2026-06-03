<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Student" %>

<%
    Student s = (Student) request.getAttribute("student");

    boolean edit = s != null;
%>

<html>
<head>
    <title>Student Form</title>
</head>
<body>

<h2>
    <%= edit ? "Update Student" : "Add Student" %>
</h2>

<form action="students" method="post">

    <input type="hidden"
           name="action"
           value="<%= edit ? "update" : "insert" %>">

    <% if(edit){ %>
    <input type="hidden"
           name="id"
           value="<%= s.getId() %>">
    <% } %>

    Mã SV:
    <input type="text"
           name="masv"
           value="<%= edit ? s.getMasv() : "" %>">

    <br><br>

    Họ tên:
    <input type="text"
           name="hoten"
           value="<%= edit ? s.getHoten() : "" %>">

    <br><br>

    <button type="submit">
        Save
    </button>

</form>

<br>

<a href="students">
    Back
</a>

</body>
</html>