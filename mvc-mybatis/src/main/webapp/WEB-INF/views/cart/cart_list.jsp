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
<div class="row justify-content-center">
	<div class="col-md-8">
	<h4 class="mb-3" align=center>Cart List</h4>	
	<table class="table">
		<tr>
			<td>카트번호 </td><td>상품번호 </td><td>상품이름 </td><td>상품금액 </td><td>수량 </td><td>선택 </td><td></td>
		</tr>
		<c:if test="${!empty carts}">
			<c:forEach var="cart" items="${carts}">
			<tr>
				<td><c:out value="${cart.cartid}"/></td>
				<td><c:out value="${cart.pnum}"/></td>
				<td><c:out value="${cart.pname}"/></td>
				<td><c:out value="${cart.pprice}"/></td>
				<td><c:out value="${cart.count}"/></td>
				<td>
					<c:url value="/order/?cartid=${cart.cartid}" var="url"/><Button class="btn btn-info" type=button onclick="location.href='${url}'">주문하기 </Button>  
					<c:url value="/order/delete?cartid=${cart.cartid}" var="url"/><Button class="btn btn-info" type=button onclick="location.href='${url}'">삭제 </Button> 
				</td>
			</tr>
		</c:forEach>
		</c:if>
		<c:if test="${empty carts}">
			<tr>
				<td colspan=6>존재하지 않습니다</td>
			</tr>
		</c:if>
	</table>
	</div>
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

  <!-- Contact  JavaScript -->
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/jqBootstrapValidation.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/contact_me.js"></script>

  <!-- Custom scripts for this template -->
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/agency.min.js"></script>

</body>
</html>