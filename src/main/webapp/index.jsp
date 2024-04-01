<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="Error.jsp"%>
<%@page import="java.sql.* "%>
<%@page
	import="Controller.DBHandler , Controller.Student, java.util.ArrayList, Controller.Operation"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="style.css" />

</head>

<body>

	<h1 align="center">Student Details</h1>
	<table>


		<thead>

			<tr>
				<th>No.</th>
				<th>Id</th>
				<th>Name</th>
				<th>Semester</th>
				<th>Branch</th>
				<th>SPI</th>
				<th colspan="2">
					<form action="ListServlet" method="post">
						<!-- <input type="number" placeholder="Enter Id to Search" name="id">-->
						<button type="submit">🔍</button>
					</form>
				</th>
			</tr>
		</thead>

		<tr>

			<td colspan="8" id="add"><a href="insert.html">Register
					Student</a></td>
		</tr>
		<tr>
			<%
				ArrayList<Student> list = DBHandler.list();
				for(int i=0; i<list.size()-1; i++){
				
		    %>


			<td><%=i+1 %></td>
			<td><%=list.get(i).getId() %></td>
			<td><%=list.get(i).getName() %></td>
			<td><%=list.get(i).getSemester()%></td>
			<td><%=list.get(i).getBranch()%></td>
			<td><%=list.get(i).getSpi()%></td>

			<td>

				<form action="DeleteServlet?id=<%=list.get(i).getId() %>"
					method="post">
					<button type="submit">❌</button>
				</form>

			</td>
			<td>
				<form action="Edit.jsp?id=<%=list.get(i).getId() %>" method="post">
					<button type="submit" id="edit">Edit</button>
				</form>

			</td>

		</tr>
		<%
			}
			%>
		<tr>
	</table>

</body>
</html>