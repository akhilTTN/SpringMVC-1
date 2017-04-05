<%--
  Created by IntelliJ IDEA.
  User: akhil
  Date: 3/4/17
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%! static int i = 1; %>
<html>
<head>
    <title>Show Employee</title>
</head>
<body>
<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
        <table class="table table-striped custab">
            <thead>
            <tr>
                <td><b>ID</b></td>
                <td><b>Manager Name</b></td>
                <td><b>Employee name</b></td>
            </tr>
            </thead>
            <tbody>
            <%Iterator itr;%>
            <%
                List list1 = (List) request.getAttribute("employees");
                for (itr = list1.iterator(); itr.hasNext(); ) {
            %>
            <tr>
                <td><%=itr.next()%>
                </td>
                <td>
                    <%=itr.next()%>
                </td>
                <td>
                    <%=itr.next()%>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
