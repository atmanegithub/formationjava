<!-- @ est la directive de page -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%!// c'est l'attribut de la classe genere
	private int commpteur = 1;
	private String inverse(String message){
		
		StringBuilder sb = new StringBuilder();
		for (int i =message.length()-1;i>=0; i--) {
			
			sb.append(message.charAt(i));
		}
	return sb.toString();	
	}
	%>
	<h2>test jsp</h2>
	
	<h3>Essai avec le init param <%= config.getInitParameter("titre") %></h3>
	<p>
		
		
	<%=new Date()%>

		<%= inverse(new Date().toString()) %>
		<%
			out.println("<ul>");

			for (int i = 0; i < 10; i++) {
				out.println("<li>" + i + "</li>");
			}
			out.println("<ul>");
		%>
	</p>
	<p>
		<%
			commpteur++;
			out.println("compteur =" + commpteur);
		%>
	</p>

</body>
</html>