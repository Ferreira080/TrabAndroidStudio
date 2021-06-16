package com.exemplo.alomundo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class SqliteProdutoDao implements produtoDao{

    private SqLiteHelper sqliteHelper;

    public SqliteProdutoDao(Context context){
        sqliteHelper = new SqLiteHelper(context);
    }


    @Override
    public void incluir(Produto produto) {
        SQLiteDatabase database = this.sqliteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Nome", produto.getNome());
        values.put("Valor", produto.getValor());
        values.put("Qtde_Estoque", produto.getQtdeProduto());
        database.insert("en_produto",null,values);
        database.close();
    }


    public List<Produto> selectAll(){
        List<Produto> produtos = new ArrayList<>();
        SQLiteDatabase database = this.sqliteHelper.getWritableDatabase();
        Cursor cursor = database.query("en_produto",new String[]{"Id_Produto","Nome","Valor","Qtde_Estoque"},null,null,null,null,null);
        while(cursor.moveToNext()){
            Produto produto =  new Produto(cursor.getString(1), cursor.getDouble(2),cursor.getInt(3));
            produto.setIdProduto(cursor.getInt(0));
            produtos.add(produto);
        }
        database.close();
        return produtos;
    }


    public void excluir(int id) {
        SQLiteDatabase database = this.sqliteHelper.getWritableDatabase();
        database.execSQL("DELETE FROM EN_PRODUTO WHERE ID_PRODUTO = "+id);
        database.close();
    }

}