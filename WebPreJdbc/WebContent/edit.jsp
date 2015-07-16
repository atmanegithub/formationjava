<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>editon client </title>
</head>
<body>
<h2> edtion client</h2>
<%--recup un objet et met a disposition     --%>
<jsp:useBean id="client" type="com.loncoto.WebPreJdbc.beans.Client" scope="request">
</jsp:useBean>


<form action="ClientServlet" method="post">
<input type="hidden" name="id" value='<jsp:getProperty property="id" name="client"/>'>
<input type="hidden" name="action" value="sauver">

nom: <input type="text" name="nom" value='<jsp:getProperty property="nom" name="client"/>'> <br/>
email: <input type="text" name="email" value='<jsp:getProperty property="email" name="client"/>'><br/>
solde: <input type="text" name="solde" value='<jsp:getProperty property="solde" name="client"/>'><br/>
<input type="submit" value="sauver"><br/>

</form>
</body>
</html>