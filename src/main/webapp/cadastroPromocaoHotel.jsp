<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufscar.dc.dsw.domain.Site" %>



<%
	List<Site> lista = (List<Site>) request.getAttribute("sites");
%>

<%
    		if(session.getAttribute("hotel")==null || lista == null){
    			response.sendRedirect("login.jsp");
    		}
%>
<!DOCTYPE html>
<html>
<head>
    	<fmt:bundle basename="br.ufscar.dc.dsw.resources.message">
        	<title><fmt:message key="cadastro_promocao"/></title>
        </fmt:bundle>
    </head>
    <body>
    	
        <fmt:bundle basename="br.ufscar.dc.dsw.resources.message">
            <form action="CadastroPromocaoHotel" method="POST">
                <fieldset >
                    <legend><fmt:message key="cadastro_promocao"/></legend>
                    <select name="site">
                    	<%for(int i = 0; i<lista.size(); i++){ %>
                    		<option value=<%=lista.get(i).getURL() %>>
                    			<%=lista.get(i).getNome()%>
                    		</option>
                    	<%} %>
                    </select> <br/>
                    
                    <fmt:message key="data_inicial"/><input type="date" name="dataIni"/><br/>
                    <fmt:message key="data_final"/><input type="date" name="dataFim"/><br/>
                    <fmt:message key="preco"/><input type="number" name="preco" min="0" step="0.01" /><br/>
                    
                    <input type="submit" value="<fmt:message key="submit_cadastro"/>" />
                </fieldset>
            </form>
        </fmt:bundle>
 		
    
    </body>
</html>