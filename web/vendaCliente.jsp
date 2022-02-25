<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Produtos</title>
    <link href="./CSS/venda.css" rel="stylesheet">
 </head>
 <body>
     <div class="quadrado">
          <h3>Produtos Cadastrados</h3>
          <div class="corpo">
            <div class="cabecalho">
             <div>Nome</div>
             <div>Preço</div>
             <div>Quantidade</div>
             <div>Foto</div>
            </div>
            <c:forEach  var="livro" items="${oi}">
            <div class="tabela">            
             <div>${livro.titulo}</div>
             <div class="preco">50</div>
             <div class="Quantidade">40</div>
             <div>FOTO.PNG</div> 
             <div><a href="">Comprar</a></div>
            </div>      
        </div>
             </c:forEach>
 </body>
</html>