package com.exemplo.alomundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button botaoVendas;
    private Button botaoProdutos;
    private Button botao2;
    private ListView list_Vendas;
    private ListView list_Produtos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Associa o componente da tela a propriedade
        botaoVendas = findViewById(R.id.botaoVendas);
        botaoProdutos = findViewById(R.id.botaoProdutos);
        botao2 = findViewById(R.id.botao2);
        list_Vendas = findViewById(R.id.lista_vendas);
        list_Produtos = findViewById(R.id.lista_produtos);

        SqliteProdutoDao produtoDao = new SqliteProdutoDao(this);
        List<Produto> produtos = produtoDao.selectAll();
        ArrayAdapter<Produto> adapter = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1,produtos);
        list_Produtos.setAdapter(adapter);

        SqliteVendaDao vendaDao = new SqliteVendaDao(this);
        List<Vendas> vendas = vendaDao.selectAll();
        ArrayAdapter<Vendas> adapterVendas = new ArrayAdapter<Vendas>(this, android.R.layout.simple_list_item_1,vendas);
        list_Vendas.setAdapter(adapterVendas);


        }

    // Evento dos botões
    public void onClickBotao1(View v) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void onClickBotaoProdutos(View v) {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    // Evento dos botões
    public void onClickBotao2(View v) {
        System.exit(0);
    }

}