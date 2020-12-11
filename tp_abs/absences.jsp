<%@page import="java.sql.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
<div class="container">

<h1>Liste des absences</h1>

<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Date</th>
      <th scope="col">Prenom</th>
    </tr>
  </thead>
  <tbody>
<%
Class.forName("org.h2.Driver");
try (Connection c = DriverManager.getConnection("jdbc:h2:~/dev/ens_prog_web/tp_abs/WEB-INF/absences", "sa", "")) {
  PreparedStatement ps = c.prepareStatement("select * from absence as abs left join personne as etu on abs.etudiant = etu.pno");
  ResultSet rs = ps.executeQuery();
  while (rs.next()) {
%>
    <tr>
      <th scope="row"><%= rs.getString("ano") %></th>
      <td><%= rs.getString("jour") %></td>
      <td><%= rs.getString("prenom") %></td>
    </tr>
<%    
  } // --while
} // --try
%>
  </tbody>
</table> 

</div>
</body>
</html>