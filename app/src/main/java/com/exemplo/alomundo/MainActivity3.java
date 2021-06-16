package com.exemplo.alomundo;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private Button botao2;
    private Button buttonCadastrarProduto;
    private Button btn_deleteProduto;
    private Button btn_editProduto;
    private EditText tB_idProduto;
    private EditText tB_produtoVendido;
    private EditText tB_valorProduto;
    private EditText tB_qtdeProdVend;
    private ListView lista_produtos;
    private EditText TB_ValorProdutoVendido;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produtos);

        //Associa o componente da tela a propriedade
        botao2 = findViewById(R.id.botao2);
        buttonCadastrarProduto = findViewById(R.id.buttonCadastrarProduto);
        tB_produtoVendido = findViewById(R.id.TB_produtoVendido);
        tB_valorProduto = findViewById(R.id.TB_valorProduto);
        tB_qtdeProdVend = findViewById(R.id.TB_qtdeProdVend);
        tB_idProduto = findViewById(R.id.TB_ValorProdutoVendido);
        lista_produtos = findViewById(R.id.lista_produtos);
        btn_deleteProduto = findViewById(R.id.btn_deleteProduto);
        btn_editProduto= findViewById(R.id.btn_editVenda);
        TB_ValorProdutoVendido= findViewById(R.id.TB_ValorProdutoVendido);




        SqliteProdutoDao produtoDao = new SqliteProdutoDao(this);
        List<Produto> produtos = produtoDao.selectAll();
        ArrayAdapter<Produto> adapter = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1,produtos);
        lista_produtos.setAdapter(adapter);

    }

    // Evento dos botões
    public void onClickButtonCadastrarProduto(View v){


        Produto produto = new Produto("Produto1",5.0,5);
        SqliteProdutoDao produtoDao = new SqliteProdutoDao(this);


        produto.setIdProduto(Integer.parseInt(tB_idProduto.getText().toString()));
        produto.setNome(tB_produtoVendido.getText().toString());
        produto.setQtdeProduto(Integer.parseInt(tB_qtdeProdVend.getText().toString()));
        produto.setValor(Double.parseDouble(tB_valorProduto.getText().toString()));


         produtoDao.incluir(produto);

        Toast.makeText(MainActivity3.this,"Produto cadastrado!",Toast.LENGTH_SHORT).show();


    }


    // Evento dos botões
    public void onClickBotao2(View v) {
        finish();
    }



    public void onClickBtn_deleteProduto(View v){
        SqliteProdutoDao produtoDao = new SqliteProdutoDao(this);
        produtoDao.excluir(Integer.parseInt(TB_ValorProdutoVendido.getText().toString()));

    }

}