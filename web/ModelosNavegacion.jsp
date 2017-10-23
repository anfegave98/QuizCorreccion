

<%@page import="model.ModeloNavegacionn"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ModeloNavegacion</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body background="fondo.jpg">
        <h1>Inserte el Modelo Navegacion</h1>
        <form action="ModeloNavegacion" method="POST">
            Nombre del Modelo Navegacion:
            <input type="text" name="nombre"/>
            <br>
            <br>  
            <input type="submit" class="btn btn-info" name="enviar"/>
            <a class="btn btn-info" href="ContextoNavegacion" role="button">Crear Contexto Navegacion</a>
            <a class="btn btn-info" href="index.jsp" role="button">Inicio</a>
        </form>

        <h1>Modelos de Navegacion</h1>
        <div class="container">
            <div class="row">  
                <div class="col-sm-12">
                    <table class="table table-hover table-condensed table-bordered">
                        <tr>
                            <td>Id</td>
                            <td>Nombre</td>

                        </tr>
                        <% if (request.getAttribute("listaModelos") != null) {
                                ArrayList<ModeloNavegacionn> list = (ArrayList<ModeloNavegacionn>) request.getAttribute("listaModelos");
                                if (list != null)
                                    for (ModeloNavegacionn mod : list) {


                        %>
                        <tr>
                            <td><%=mod.getId()%></td>
                            <td><%=mod.getNombre_modelo()%></td>
              
                        </tr>
                        <% }
                            }
                        %>

                    </table>

                </div>
            </div>
        </div>

    </body>
</html>
