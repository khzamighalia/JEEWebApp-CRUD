<%@page import="services.SArticleDAO"%>
<%@page import="models.Article"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produits</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> </head>
    
        
          <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a class="navbar-brand" href="#" data-abc="true">PEPINIERE</a> <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
    <div class="collapse navbar-collapse" id="navbarColor02">
        <ul class="navbar-nav mr-auto" >
            <li class="nav-item active"> <a class="nav-link" href="#" data-abc="true">Home <span class="sr-only">(current)</span></a> </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="chercher.do" method="get" > 
            
           <input class="form-control mr-sm-2" type="text" name="motcle" placeholder="Enter un mot cle">
           <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button> 
        </form>
    </div>
</nav>
  <div class="container">
      <form action="/mavenproject4/add.jsp" method="get">
          
  <div class="form-group">
    <label> Designation </label>
    <input type="text" class="form-control" id="designation" name="designation" aria-describedby="emailHelp" placeholder="Enter la d�signation">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Prix</label>
    <input type="text" class="form-control" id="prix" name="prix" placeholder="Enter le prix">
  </div>
             <div class="form-group">
    <label for="exampleInputPassword1">Quantit�</label>
    <input type="number" class="form-control" id="qte" name="qte" placeholder="Enter la quantit�">
  </div>
 
  <button type="submit" class="btn btn-primary">Valider </button>
</form>
  </div>

    
</html>

