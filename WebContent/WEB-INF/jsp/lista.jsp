<%@page import="br.com.caelum.exemplo.Transacao"%>
<%@page import="java.util.List"%>
<html>
	<body>
		<% List<Transacao> txs =   (List<Transacao>)request.getAttribute("txs");%>
		<%for(Transacao tx : txs) {%>			
			<%=tx.getValor()%><br>	
		<%}%>
	</body>
</html>