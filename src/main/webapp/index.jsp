<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 21.10.17
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To Do List</title>
</head>
<body>
<div align="center">

    <h1>Welcome to my To Do List</h1>
    <h3>Please enter your first task</h3>

    <form action="servlet" method="post">
        <input type="text" name="task" placeholder="write your task" autofocus required>
        <input type="submit" value="Add task">
    </form>

    <h3>Or enter list page</h3>
    <form action="servlet" method="get">
        <input type="submit" value="To Do List">
    </form>

</div>
</body>
</html>
