<%@ page language="java" contentType="text/html; charset=utf-8" import="com.iteyedl.alipapa.model.*"
	pageEncoding="utf-8"%>

<%
request.setCharacterEncoding("utf-8");
String action = request.getParameter("action");
if(action != null && action.equals("register")) {
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String phone = request.getParameter("phone");
	String addr = request.getParameter("addr");
	User u = new User();
	u.setUsername(username);
	u.setPassword(password);
	u.setPhone(phone);
	u.setAddr(addr);
	u.setRdate(new java.util.Date(System.currentTimeMillis()));
	u.save();
	%>
	<center>Register Succeed! Thank you!</center>
	<%
	return;
}
%>

<!DOCTYPE head PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Alipapa Registration</title>
<script language=JavaScript src="script/regcheckdata.js"></script>
</head>
<body>
<form name="form" action="register.jsp" method="post"
		onSubmit="return checkdata()">
		<input type="hidden" name="action" value="register">
<table width="750" align="center" border="2">
	<tr>
		<td colspan="2" align="center">Welcome Register in Alipapa</td>
	</tr>

	<tr>
		<td>Input Username</td>
		<td><input type=text name="username" size="30" maxlength="10">
		</td>
	</tr>

	<tr> 
		<td>Input Password</td>
		<td><input type=password name="password" size="15" maxlength="12">
		</td>
	</tr>

	<tr>
		<td>Confirm Password</td>
		<td><input type=password name="password2" size="15" maxlength="12">
		</td>
	</tr>

	<tr>
		<td>Telephone Number</td>
		<td><input type=text name="phone" size="15" maxlength="12">
		</td>
	</tr>

	<tr>
		<td>Address</td>
		<td><textarea rows="12" cols="80" name="addr"></textarea></td>
	</tr>

	<tr>
		<td></td>
		<td>
			<!--  <div class='row tos-row'>
			<p class='tos'>
			I agree to the <ahref=https://info.yahoo.com/legal/us/yahoo/terms/en-us
			target=_blank>Alipapa Terms</a> and <ahref=http://info.yahoo.com/privacy/us/yahoo / target=_blank></a>.
			</p>
			</div> 
			-->
			<input type="submit" value="Submit">
			<input type="reset"	value="Reset">
		</td>
	</tr>

</table>
</form>

</body>
</html>