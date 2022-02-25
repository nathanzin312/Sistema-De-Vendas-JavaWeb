package Entidade;

public class Produtos {
    int id;
    String nome;
    int quantidade;
    float preco;
    int id_foto;

    public Produtos(String nome, int quantidade, float preco, int id_foto) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.id_foto = id_foto;
    }

    public int getId_foto() {
        return id_foto;
    }

    public void setId_foto(int id_foto) {
        this.id_foto = id_foto;
    }
    
    public Produtos() {
    }
    public Produtos(int id, String nome, int quantidade, float preco, int id_foto){
        this.id=id;
        this.nome=nome;
        this.quantidade=quantidade;
        this.preco=preco;
        this.id_foto = id_foto;
    }
    
    public Produtos(String nome, int quantidade, float preco){
        this.nome=nome;
        this.quantidade=quantidade;
        this.preco=preco;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
