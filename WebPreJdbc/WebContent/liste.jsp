<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.loncoto.WebPreJdbc.beans.Client"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List des clients</title>
</head>
<body>
	<table border="1">
		<!--  tr : ligne , th : table header  -->
		<tr>
			<th>nom</th>
			<th>email</th>
			<th>Action</th>
		</tr>
		<%
		
// je recupere la liste des clients 
		List<Client> clients = (List<Client>) request
					.getAttribute("clients");
			
		// specifier le type  dans le foreach
		for (Client c : clients) {
		%>
		<tr>
			<!--  td : colonne  -->
			<td><%=c.getNom()%></td>
			<td><%=c.getEmail()%></td>

			<td>

				<form action="ClientServlet" method="post">
					
					<%-- Commentaire Jsp --%>
					<%--   The action attribute defines the action to be performed when the form is submitted --%>
					<%-- hidden: il s'agit d'un champ caché. --%>
					<input type="hidden" name="id" value='<%=c.getId() %>' /> 
					<input type="hidden" name="action" value='Editer' />
					 <input type="submit"value="Edition" /> 



				</form>

			</td>

			<!--     -->


		</tr>

		<%
			}
		%>

	</table>
		<form action="ClientServlet" method="post">
					<input type="hidden" name="action" value='Creer' />
					 <input type="submit"value="nouveau client" /> 

</body>
</html>