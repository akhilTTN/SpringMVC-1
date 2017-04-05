<%--
  Created by IntelliJ IDEA.
  User: akhil
  Date: 3/4/17
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%! static int i = 1; %>
<html>
<head>
    <title>Show Managers</title>
</head>
<body>
<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
        <form role="form" action="/addEmployee" method="post">
            <table class="table table-striped custab">
                <thead>
                <tr>
                    <td><b>ID</b></td>
                    <td><b>Manager Name</b></td>
                    <td><b>Employee name</b></td>
                    <td><b>Add Employee</b></td>
                    <td><b>Show Employee</b></td>
                </tr>
                </thead>
                <tbody>

                <%--<c:forEach var="manager" items="${managers}">--%>
                <%
                    List list= (ArrayList)request.getAttribute("managers");

                    ListIterator itr=list.listIterator();
                    while(itr.hasNext())
                    {
                %>

                <form action="/addEmployee" method="post">
                <tr>
                    <td>
                        <%--<c:out value="${manager}"></c:out>--%>
                        <%= itr.next()%>
                    </td>
                    <td>
                        <input type="text" value="<%= itr.next()%>" name="ManagerName" contenteditable="false"/>
                    </td>
                    <td><input type="text" name="EmployeeName">
                    </td>
                    <td>
                        <input type="submit" value="Add" onclick="form.action='/addEmployee'">
                    </td>
                    <td>
                        <input type="submit" value="Show" onclick="form.action='/showEmployee'">
                    </td>
                </tr>
                </form>
                <%
                    }
                %>
                <%--</c:forEach>--%>
                </tbody>
            </table>
        </form>
    </div>
</div>
<div>
    <%
        String msg1=(String)request.getAttribute("msg1");
        if(msg1!=null && !msg1.equals(""))
        {
    %>
    <script>
        alert(${msg1})
    </script>
    <%
        }
    %>
</div>
</body>
</html>
