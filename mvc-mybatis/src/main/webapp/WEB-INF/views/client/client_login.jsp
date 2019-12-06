<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>현블링 </title>

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="${pageContext.request.contextPath}/resources/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/bootstrap/css/agency.min.css" rel="stylesheet">

</head>

<body id="page-top">
<header>
  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
      <c:url value="/" var="url"/><a class="navbar-brand js-scroll-trigger" href="${url}">Hyunbling</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav text-uppercase ml-auto">
          <li class="nav-item">
          	<c:if test="${empty loginVO}">
          		<c:url value="/login/" var="url"/><a class="nav-link js-scroll-trigger" href="${url}">Login</a>
          	</c:if>
          	<c:if test="${!empty loginVO}">
          		<c:url value="/logout/" var="url"/><a class="nav-link js-scroll-trigger" href="${url}">Logout</a>
          	</c:if>
          </li>
          <li class="nav-item">
            <c:url value="/join/" var="url"/><a class="nav-link js-scroll-trigger" href="${url}">Join</a>
          </li>
          <li class="nav-item">
          	<c:if test="${empty loginVO}">
          		<c:url value="/login/fail" var="url"/><a class="nav-link js-scroll-trigger" href="${url}">Cart</a>
          	</c:if>
          	<c:if test="${!empty loginVO}">
          		<c:url value="/cart/" var="url"/><a class="nav-link js-scroll-trigger" href="${url}">Cart</a>
          	</c:if>
          </li>
          <li class="nav-item">
          	<c:if test="${empty loginVO}">
          		<c:url value="/login/fail" var="url"/><a class="nav-link js-scroll-trigger" href="${url}">Order</a>
          	</c:if>
          	<c:if test="${!empty loginVO}">
          		<c:url value="/order/list" var="url"/><a class="nav-link js-scroll-trigger" href="${url}">Order</a>
          	</c:if>
          </li>
          <li class="nav-item">
          	<c:if test="${empty loginVO}">
          		<c:url value="/login/fail" var="url"/><a class="nav-link js-scroll-trigger" href="${url}">My Page</a>
          	</c:if>
          	<c:if test="${!empty loginVO}">
          		<c:url value="/client/list" var="url"/><a class="nav-link js-scroll-trigger" href="${url}">My Page</a>
          	</c:if>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</header>

  <!--  Menu -->
  <section class="page-section-top" id="services">
  <hr>
    <div class="container">
      <div class="row text-center">
        <div class="margin">
          <p class="margin"><c:url value="/product/best" var="url"/><a class="menu" href="${url}">BEST</a></p>
        </div>
        <div class="margin">
          <p class="margin"><c:url value="/product/earing" var="url"/><a class="menu" href="${url}">귀걸이 </a></p>
        </div>
        <div class="margin">
          <p class="margin"><c:url value="/product/ring" var="url"/><a class="menu" href="${url}">반지 </a></p>
        </div>
        <div class="margin">
          <p class="margin"><c:url value="/product/etc" var="url"/><a class="menu" href="${url}">기타 </a></p>
        </div>
         <div class="margin">
          <p class="margin"><c:url value="" var="url"/><a class="menu" href="${url}">Q&A</a></p>
        </div>
      </div>
    </div>
    <hr>
  </section>
  
 <br>
 <h3 align=center>LOGIN</h3>
 <div align=center>                                             
 <form method=POST action="http://www.hyunbling.cf/mvc-mybatis/login/">
 <table id="login">
	<tr>
		<td style="font-size : 12px;">아이디</td>
		<td><input type="text" size=20 name=id></td>
		<td rowspan=2>&nbsp&nbsp&nbsp&nbsp<input type=submit value="Login"></td>
	</tr>
	<tr>
		<td style="font-size : 12px;">비밀번호&nbsp&nbsp&nbsp&nbsp</td>
		<td><input type="text" size=20 name=passwd></td>
	</tr>
 </table>
 </form>
 </div>

<br><br>
<!-- Footer -->
  <footer class="footer">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-md-4">
          <span class="copyright">Copyright &copy; Your Website 2019</span>
        </div>
        <div class="col-md-4">
          <ul class="list-inline social-buttons">
            <li class="list-inline-item">
              <a href="#">
                <i class="fab fa-twitter"></i>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <i class="fab fa-facebook-f"></i>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <i class="fab fa-linkedin-in"></i>
              </a>
            </li>
          </ul>
        </div>
        <div class="col-md-4">
          <ul class="list-inline quicklinks">
            <li class="list-inline-item">
              <a href="#">Privacy Policy</a>
            </li>
            <li class="list-inline-item">
              <a href="#">Terms of Use</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="${pageContext.request.contextPath}/resources/bootstrap/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="${pageContext.request.contextPath}/resources/bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Contact form JavaScript -->
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/jqBootstrapValidation.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/contact_me.js"></script>

  <!-- Custom scripts for this template -->
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/agency.min.js"></script>

</body>
</html>