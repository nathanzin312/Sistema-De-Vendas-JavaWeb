
package Entidade;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Registros {
    int id;
    int id_usuario;
    int produto;
    LocalDate data;
    int quantP;
    float valor;
    String nome_prod;

    public Registros(int id, LocalDate data, int quantP, float valor, String nome_prod) {
        this.id = id;
        this.data = data;
        this.quantP = quantP;
        this.valor = valor;
        this.nome_prod = nome_prod;
    }

    
    

    public float getValor() {
        return valor;
    }

    public String getNome_prod() {
        return nome_prod;
    }

    public void setNome_prod(String nome_prod) {
        this.nome_prod = nome_prod;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    

    public Registros(int id_usuario, int produto, LocalDate data, int quantP, float valor, String nome) {
        this.id_usuario = id_usuario;
        this.produto = produto;
        this.data = data;
        this.quantP = quantP;
        this.valor = valor;
        this.nome_prod = nome;
    }

    public Registros(int id, int id_usuario, int produto, LocalDate data) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.produto = produto;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getQuantP() {
        return quantP;
    }

    public void setQuantP(int quantP) {
        this.quantP = quantP;
    }

    
    
    
    
    public Registros(){
        
    }
    
 
    
}
