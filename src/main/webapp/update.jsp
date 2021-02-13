<%@page import="services.SArticleDAO"%>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.DriverManager" %>

<%
     String id= request.getParameter("id");
     String designation= request.getParameter("designation");
     String prix= request.getParameter("prix");
     String qte= request.getParameter("qte");
     int no = Integer.parseInt(id);
     Float price = Float.parseFloat(prix);
     int quantite = Integer.parseInt(id);
     SArticleDAO dao= SArticleDAO.getInstance();
     dao.ModifierArticle(no,designation,price,quantite);
     //response.sendRedirect("/ControleurServlet");
     ServletContext context= getServletContext();
RequestDispatcher rd= context.getRequestDispatcher("/defaultServlet");
rd.forward(request, response);
    
%>

