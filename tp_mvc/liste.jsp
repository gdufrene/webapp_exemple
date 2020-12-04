<%@page import="java.util.*" %>
<h1>Liste</h1>


<ul>
<% 
  List<String> elements = (List<String>) request.getAttribute("elements");
  for ( String elm : elements ) {
%>

	<li><%= elm %></li>

<% } %>
</ul>
