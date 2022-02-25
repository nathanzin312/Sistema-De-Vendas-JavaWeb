
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Comprar Produtos </title>
    </head>
    <body>
        <h1>Produtos Disponíveis </h1>
       
        <table >
            <tr><th>Produto</th><th>Quantidade</th><th>Preço</th><th>FOTO</th><th> Quantidade Desejada </th><th> Adicionar ao carrinho</th></tr>
            <c:forEach  var="prod" items="${oi}">
              <form action="AdicionarCarrinho" method="GET" class="form1" enctype="multipart/form-data">
                <tr>
                    <td>${prod.nome}</td>
                    <td>${prod.quantidade}</td>
                    <td>${prod.preco}</td>
                    <td><img src="C:/Users/PADRAO/Pictures/uploads_curriculos/SOL.jpg" ></td>
                    <td><input type="number" step="any" name= "quantidade" /></td>
                    <td><input type="hidden" name="id" value="${prod.id}"/><input type="hidden" name="nome" value="${prod.nome}"/><input type="hidden" name="valor" value="${prod.preco}"/><input type="submit" value="Adicionar"/></td>

                </tr>     
              </form>

            </c:forEach>
        </table>
        <br>
        <br>    
       <form action="FecharVendas" method="GET" class="form1" enctype="multipart/form-data">
           <input type="submit" value="Fechar Venda"/>
       </form>

    </body>
</html>