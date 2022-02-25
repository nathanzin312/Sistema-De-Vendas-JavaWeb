
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link href="CSS/cadastroProdutos.css" rel="stylesheet">
    <title>Cadastro Produtos</title>
  </head>
  <body>
    <div class="total">
      <h2>Cadastro de Produtos</h2>
        <form action="AdicionarProduto" method="POST" class="form1" enctype="multipart/form-data">
         <div class="itens">
           <div class="nome">
            <label>Nome: <label><input type="text"  placeholder="Nome Produto"  name="nomeProduto" >
           <br>
           </div>
           <div class="preco">
            <label>Preço: </label><input type="text" placeholder="Preço Produto" name="preco">
           <br>
           </div>
           <div class="quantidade">
               <label>Quantidade: </label><input type="number" placeholder="Quantidade" name="quantidade">
           <br>
           </div>
           <div class="form2">
              Escolha um arquivo: <input type="file" name="upload"/>
             <br><br>         
           </div>
          <br>
          <div class="posicaobotao">
           <input type="submit" class="botao" value="enviar" name="enviar">
          </div>
        </div>
      </form>
    </div>
  </body>
</html>
