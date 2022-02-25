
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Comprar Produtos </title>
    </head>
    <body>
        <h1>Compras Adicionadas</h1>
        <table>
            <form method="GET" action="FecharVendas" enctype="multipart/form-data">
                <tr><th>Produto</th><th>quantidade</th><th>valor Produtos</th></tr>
                        <c:forEach  var="prod" items="${oi}">
                    <tr>
                        <td>${prod.nome_prod}</td>
                        <td>${prod.quantP}</td>
                        <td>${prod.valor}</td>
                    </tr>     
                </form>

            </c:forEach>
        </table>
        <h1>Total:</h1>
        <strong>

            <c:out value="${total}"/>


        </strong>
        <br>
        <br>
        <h1>fechar Venda </h1>



        <form method="POST" action="FecharVendas">


            <input type="number" step="any" name= "quantidade" />
            <input type="submit" value="Adicionar"/>    
        </form>

    </ta
    <br>
    <br>    

</body>
</html>