package com.exemplo.alomundo;

public class Produto {

    private int idProduto;
    private String nome;
    private Double valor;
    private int qtdeProduto;


    public Produto(String nome,Double valor,int qtdeProduto){
        this.nome = nome;
        this.valor = valor;
        this.qtdeProduto = qtdeProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQtdeProduto(int qtdeProduto) {
        this.qtdeProduto = qtdeProduto;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getQtdeProduto() {
        return qtdeProduto;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return
                "ID do Produto=" + idProduto +
                ", Nome='" + nome + '\'' +
                ", Valor=" + valor +
                ", Qtde Produto no estoque=" + qtdeProduto;
    }
}
