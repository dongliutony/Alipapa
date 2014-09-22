<%@ page language="java" contentType="text/html; charset=utf-8" import="com.iteyedl.alipapa.model.*"
	pageEncoding="utf-8"%>
<%@ page import="com.iteyedl.alipapa.model.*, java.sql.*, java.util.*,com.iteyedl.alipapa.DAO.*" %>

<%@ include file="_session.jsp" %>

<%
	//TODO should check the id valadation status
int id = Integer.parseInt(request.getParameter("id"));
UserDAO.deleteUser(id);
%>

<!DOCTYPE head PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>User Delete</title>
</head>
<body>
A customer removed from list.
<script language="javascript">
	window.parent.main.document.location.reload();
</script>
</body>
</html> 