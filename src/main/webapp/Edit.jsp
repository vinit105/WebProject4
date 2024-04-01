<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="Controller.DBHandler , Controller.Student, java.util.ArrayList, Controller.Operation, Controller.EditServlet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit </title>

<link rel="stylesheet" type="text/css" href="style.css" />
<style type="text/css">
td{
height:30px;
width:200px;
}

</style>
</head>
<body>

	<%
	int idStudent = Integer.parseInt(request.getParameter("id"));
	ArrayList<Student> list = DBHandler.findStudent(idStudent);
	%>
	<table>
		<tr>
			<td><b> Id :</b></td>
			<td><b><%=list.get(0).getId()%></b></td>
		</tr>

		<tr>
			<form action="EditServlet?id=<%=list.get(0).getId()%>" method="post">
				<td><b>Enter Name :</b></td>
				<td><input type="text" name="name"
					value="<%=list.get(0).getName()%>"></td>
		</tr>
		<tr>
			<td><b>Enter Branch :</b></td>
			<td><input type="text" name="branch"
				value="<%=list.get(0).getBranch()%>"></td>

		</tr>
		<tr>
			<td><b>Enter Semester:</b></td>
			<td><input type="number" value="<%=list.get(0).getSemester()%>"
				name="semester"></td>

		</tr>
		<tr>
			<td><b>Enter SPI:</b></td>
			<td><input type="number" value="<%=list.get(0).getSpi()%>" step="any" name="spi"></td>

		</tr>
		<tr>
			<td><button>
					<a href="index.jsp">Back</a>
				</button></td>
			<td  colspan="2"><input id="button" type="submit" value="Update">
			</td>
		</tr>
		</form>

	</table>
</body>
</html>