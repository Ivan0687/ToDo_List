<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 21.10.17
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>To Do List</title>
</head>
<body>
<div align="center">

    <h3>Please enter your task</h3>
    <form action="servlet" method="post">
        <input type="text" name="task" placeholder="write your task" autofocus required>
        <input type="submit" value="Add task">
    </form>


    <table border="bold">
        <caption>Tasks</caption>
        <tr>
            <th></th>
            <th>id</th>
            <th>description</th>
            <th>is done</th>
            <th>update</th>
        </tr>

        <c:forEach var="task" items="${tasks}">
            <tr>
                <td>
                    <form action="servlet" method="post">
                        <input type="number" name="taskIdDel" value="${task.id}" hidden>
                        <input type="submit" value="Delete task">
                    </form>
                </td>
                <td>${task.id}</td>
                <td>${task.description}</td>
                <td>${task.isDone()}</td>
                <td>
                    <form action="servlet" method="post">
                        <input type="number" name="taskIdUpd" value="${task.id}" hidden>
                        <input type="submit" value="Complete task">
                    </form>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
</form>
</body>
</html>
