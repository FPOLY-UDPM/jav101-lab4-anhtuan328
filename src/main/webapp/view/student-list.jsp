<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>

<html>
<head>
    <title>Danh sách sinh viên</title>
</head>
<body>

<h2>DANH SÁCH SINH VIÊN</h2>

<a href="students?action=new">Thêm sinh viên</a>

<br><br>

<table border="1" cellpadding="5">

    <tr>
        <th>ID</th>
        <th>Mã SV</th>
        <th>Họ tên</th>
        <th>Action</th>
    </tr>

    <%
        List<Student> list =
                (List<Student>) request.getAttribute("students");

        if(list != null){
            for(Student s : list){
    %>

    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getMasv() %></td>
        <td><%= s.getHoten() %></td>

        <td>
            <a href="students?action=edit&id=<%= s.getId() %>">
                Edit
            </a>

            |

            <a href="students?action=delete&id=<%= s.getId() %>"
               onclick="return confirm('Delete?')">
                Delete
            </a>
        </td>
    </tr>

    <%
            }
        }
    %>

</table>

</body>
</html>