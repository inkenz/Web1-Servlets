<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Promocao" %>



<%
	List<Promocao> lista = (List<Promocao>) request.getAttribute("promocoes");
%>
<%
    		if(session.getAttribute("hotel")==null || lista == null){
    			response.sendRedirect("login.jsp");
    		}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<fmt:bundle basename="br.ufscar.dc.dsw.resources.message">
		<table style ="width:75%">			
			<thead>
			<tr>
				<th><fmt:message key="URL"/></th>
				<th><fmt:message key="CNPJ"/> </th>
				<th><fmt:message key="preco"/> </th>
				<th><fmt:message key="data_inicial"/></th>
				<th><fmt:message key="data_final"/></th>
			</tr>
			</thead>
			<tbody>
			<%for(int i = 0; i<lista.size();i++) {%>
			<tr>
				<td><%=lista.get(i).getEndereco()%></td>
				<td><%=lista.get(i).getCNPJ()%></td>
				<td><%=lista.get(i).getPreco()%></td>
				<td><%=lista.get(i).getInicio().toString()%></td>
				<td><%=lista.get(i).getFim().toString()%></td>
			</tr>
			
			<%} %>
		
		</table>
	</fmt:bundle>
</body>
</html>