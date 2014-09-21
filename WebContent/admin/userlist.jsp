<%@ page language="java" contentType="text/html; charset=utf-8" import="com.iteyedl.alipapa.model.*"
	pageEncoding="utf-8"%>
<%@ page import="com.iteyedl.alipapa.model.*, java.sql.*, java.util.*" %>

<%
//get all the users
List<User> users = User.getUsers();
%>

<!DOCTYPE head PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Alipapa Registration</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<td>ID</td>
			<td>Username</td>
			<td>Phone</td>
			<td>Addr</td>
			<td>RDate</td>
			<td>Operate</td>
			</tr>
		<%
		for(Iterator<User> it = users.iterator(); it.hasNext();) {
			User u = it.next();
		%>
			<td><%=u.getId() %></td>
			<td><%=u.getUsername() %></td>
			<td><%=u.getPhone() %></td>
			<td><%=u.getAddr() %></td>
			<td><%=u.getRdate() %></td>
			<td><a href="userdelete.jsp?id=<%=u.getId()%>">Delete</a>
			</tr>
		<%
		}
		%>
	</table>
</body>
</html>