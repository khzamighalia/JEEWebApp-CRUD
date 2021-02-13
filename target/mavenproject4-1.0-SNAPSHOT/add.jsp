<%@page import="models.Article"%>
<%@page import="services.SArticleDAO"%>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.DriverManager" %>

<%
     String designation= request.getParameter("designation");
     String prix= request.getParameter("prix");
     String qte= request.getParameter("qte");
     Float price = Float.parseFloat(prix);
     int quantite = Integer.parseInt(qte);
     Article a=new Article(designation,price,quantite);
     SArticleDAO dao= SArticleDAO.getInstance();
     dao.ajouterArticle(a);
     ServletContext context= getServletContext();
     RequestDispatcher rd= context.getRequestDispatcher("/defaultServlet");
     rd.forward(request, response);
    
%>

