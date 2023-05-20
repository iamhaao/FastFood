<%-- 
    Document   : PreviewProduct
    Created on : May 15, 2023, 4:05:36 AM
    Author     : ACER NITRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp" %>
<body>
     <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
    <link rel="stylesheet" href="./css/stylePreview.css"/>
    <c:set var="p" value="${requestScope.p}"/>
	<div class="container">
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">
						
						<div class="preview-pic tab-content">
						  <div class="tab-pane active w-full h-25  img-responsive" id="pic-1"><img src="${p.image}" /></div>
						</div>
<!--						<ul class="preview-thumbnail nav nav-tabs">
						  <li class="active"><a data-target="#pic-1" data-toggle="tab"><img src="http://placekitten.com/200/126" /></a></li>
						</ul>-->
						
					</div>
					<div class="details col-md-6">
						<h3 class="product-title">${p.name}</h3>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
							</div>
							<span class="review-no">41 reviews</span>
						</div>
						<p class="product-description">${p.description}</p>
                                                <h4 class="price"> price: <span>${p.price}</span></h4>
						<div class="action">
                                                    <button class="add-to-cart btn btn-default" type="button"> <a href="addcart?id=${p.idProduct}">add to cart</a></button>
							<button class="like btn btn-default" type="button"><span class="fa fa-heart"></span></button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
  </body>
  <%@include file="./includes/footer.jsp" %>
