package com.exemplo.alomundo;

import android.content.Context;

public class Vendas {

    private int idVendas;
    private String nomeProdutoVendido;
    private Double valorProdutoVendido;
    private int qtdeProdutosVendidos;



    public Vendas(String nomeProdutoVendido, Double valorProdutoVendido,int qtdeProdutosVendidos){

        this.nomeProdutoVendido = nomeProdutoVendido;
        this.valorProdutoVendido = valorProdutoVendido;
        this.qtdeProdutosVendidos = qtdeProdutosVendidos;
    }

    public void setNomeProdutoVendido(String nomeProdutoVendido) {
        this.nomeProdutoVendido = nomeProdutoVendido;
    }

    public void setQtdeProdutosVendidos(int qtdeProdutosVendidos) {
        this.qtdeProdutosVendidos = qtdeProdutosVendidos;
    }

    public void setValorProdutoVendido(Double valorProdutoVendido) {
        this.valorProdutoVendido = valorProdutoVendido;
    }

    public void setIdVendas(int idVendas) {
        this.idVendas = idVendas;
    }

    public String getNomeProdutoVendido() {
        return nomeProdutoVendido;
    }

    public Double getValorVenda(){
        Double valor = this.valorProdutoVendido * this.qtdeProdutosVendidos;
        return valor;
    }

    public int getQtdeProdutosVendidos() {
        return qtdeProdutosVendidos;
    }

    @Override
    public String toString() {
        return  "Id_Venda=" + idVendas +
                ", Valor da venda = " + getValorVenda() +
                ", Produto Vendido=" + getNomeProdutoVendido();
    }
}
