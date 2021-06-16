package com.exemplo.alomundo;

import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private Button botao2;
    private Button buttonCadastrarVenda;
    private Button btn_deleteVenda;
    private Button btn_editVenda;
    private EditText TB_ValorProdutoVendido;
    private EditText TB_produtoVendido;
    private EditText TB_qtdeProdVend;
    private ListView list_vendas;
    private EditText idVendaTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_vendas);

        //Associa o componente da tela a propriedade
        botao2 = findViewById(R.id.botao2);
        TB_ValorProdutoVendido = findViewById(R.id.TB_ValorProdutoVendido);
        TB_produtoVendido = findViewById(R.id.TB_produtoVendido);
        TB_qtdeProdVend = findViewById(R.id.TB_qtdeProdVend);
        list_vendas = findViewById(R.id.list_vendas);
        buttonCadastrarVenda = findViewById(R.id.buttonCadastrarVenda);
        btn_deleteVenda = findViewById(R.id.btn_deleteVenda);
        btn_editVenda = findViewById(R.id.btn_editVenda);
        idVendaTxt = findViewById(R.id.idVendaTxt);

        SqliteVendaDao vendaDao = new SqliteVendaDao(this);
        List<Vendas> vendas = vendaDao.selectAll();
        ArrayAdapter<Vendas> adapter = new ArrayAdapter<Vendas>(this, android.R.layout.simple_list_item_1,vendas);
        list_vendas.setAdapter(adapter);
    }

    // Evento dos botões
    public void onClickButtonCadastrarVenda(View v){

        Vendas venda = new Vendas("Arroz",5.0,5);
        SqliteVendaDao vendaDao = new SqliteVendaDao(this);



        venda.setNomeProdutoVendido(TB_produtoVendido.getText().toString());
        venda.setQtdeProdutosVendidos(Integer.parseInt(TB_qtdeProdVend.getText().toString()));
        venda.setValorProdutoVendido(Double.parseDouble(TB_ValorProdutoVendido.getText().toString()));


        vendaDao.incluir(venda);

        Toast.makeText(MainActivity2.this,"Venda cadastrada!",Toast.LENGTH_SHORT).show();
    }

    // Evento dos botões
    public void onClickBotao2(View v) {
        finish();
    }

    public void onClickBtn_deleteVenda(View v){
        SqliteVendaDao vendaDao = new SqliteVendaDao(this);
        vendaDao.excluir(Integer.parseInt(idVendaTxt.getText().toString()));

    }

    public void onClickBtn_editVenda(View v){
        SqliteVendaDao vendaDao = new SqliteVendaDao(this);
        vendaDao.excluir(Integer.parseInt(idVendaTxt.getText().toString()));

    }
}