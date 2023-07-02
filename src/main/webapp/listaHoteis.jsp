<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Hotel" %>
<%@ page import="br.ufscar.dc.dsw.dao.HotelDAO" %>



<%
	List<Hotel> lista = (List<Hotel>) request.getAttribute("hoteis");
	if(lista == null)
	{
		HotelDAO hdao = new HotelDAO();
		lista = hdao.getAll();	
	}
%>
<%
    		if(lista == null){
    			response.sendRedirect("inicio.jsp");
    		}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<fmt:bundle basename="br.ufscar.dc.dsw.resources.message">
		<form action="Inicio" method="POST" accept-charset="UTF-8">
                <fieldset >
                	<input type="submit" value="<fmt:message key="hotel_sem_ordem"/>" name="BT2"/><br/>
                    <input type="submit" value="<fmt:message key="hotel_por_cidade"/>" name="BT3"/><br/>
        	    </fieldset>
        </form>
		<table style ="width:75%">			
			<thead>
			<tr>
				<th><fmt:message key="name_hotel"/></th>
				<th><fmt:message key="city"/> </th>
				<th><fmt:message key="CNPJ"/> </th>
			</tr>
			</thead>
			<tbody>
			<%for(int i = 0; i<lista.size();i++) {%>
			<tr>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getCidade()%></td>
				<td><%=lista.get(i).getCNPJ()%></td>
			</tr>
			<%} %>
		</table>
	</fmt:bundle>
</body>
</html>
