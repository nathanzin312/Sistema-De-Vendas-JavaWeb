
package Entidade;


public class Arquivo {
    
    int id;
    String nome;
    String contentType;

    public Arquivo() {
    }

    public Arquivo(int id, String nome, String contentType) {
        this.id = id;
        this.nome = nome;
        this.contentType = contentType;
    }

    public Arquivo(String nome, String contentType) {
        this.nome = nome;
        this.contentType = contentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
    
    
}
