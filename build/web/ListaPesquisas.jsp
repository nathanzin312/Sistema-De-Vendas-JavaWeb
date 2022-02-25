
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Listagem Registros </title>
    </head>
    <body>
        <h1>Registros Disponíveis </h1>

        <table >
            <tr><th>Produto</th><th>Quantidade</th><th>Valor</th></tr>
                    <c:forEach  var="reg" items="${array}">
                <tr>
                    <td>${reg.nome_prod}</td>
                    <td>${reg.quantP}</td>
                    <td>${reg.valor}</td>

                </tr>     


            </c:forEach>
        </table>
        <br>
        <br>    
        <form action="FecharVendas" method="GET" class="form1" enctype="multipart/form-data">
            <input type="submit" value="Fechar Venda"/>
        </form>

    </body>
</html>