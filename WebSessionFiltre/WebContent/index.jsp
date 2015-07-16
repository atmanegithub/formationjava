<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="style.jspf" %>
<title>test de la session </title>
</head>
<body>


<jsp:include page="Header.jsp">
<jsp:param value="bonjour" name="message"/>


</jsp:include>

<h2>   compteur de la session <%=session.getAttribute("compteur") %></h2>
<h2>   identifiant  de la session <%=session.getId() %></h2>

<%--envoie vers la methode post de servlet "IndexServlet"   --%>
<form action="IndexServlet" method="post">
<%--  --%>
<input type="hidden" name="action" value="reinitialiser"/>

<%-- bouton permettant la soumission du formulaire  --%>
<input type="submit"  value="reinitialisation de la session"/>



</form>
</body>
</html>