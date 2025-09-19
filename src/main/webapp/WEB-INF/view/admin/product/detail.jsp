<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product Detail ${id}</title>
        <!-- Latest compiled and minified CSS -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet">
        <!-- Latest compiled JavaScript -->
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

        <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <!-- <link rel="stylesheet" href="/css/demo.css"> -->
    </head>
    <body>
        <div class="container mt-5">
            <div class="row">
                <div class="col-12 mx-auto">
                    <div class="d-flex m-2 justify-content-between">
                        <h3>Product Detail  with id = ${id}</h3>
                    </div>
                    <hr/>

                    <div class="card" style="width: 60%;">
                    <img class="card-img-top" src="/images/product/${product.image}" alt="img">
                    <div class="card-header"> 
                    Product information
                    </div> 
                        <ul class="list-group list-group-flush"> 
                            <li class="list-group-item">ID: ${product.id}</li> 

                            <li class="list-group-item">Name: ${product.name}</li> 
                            <li class="list-group-item">Price: ${product.price}</li> 
                        </ul> 
                    </div>
                </div>
            </div>
            <a href="/admin/product" class="btn btn-success">Back</a>
        </div>
    </body>
</html>