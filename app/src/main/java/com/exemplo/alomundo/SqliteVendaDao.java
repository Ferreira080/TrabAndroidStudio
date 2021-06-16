package com.exemplo.alomundo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class SqliteVendaDao implements vendaDao{

    private SqLiteHelper sqliteHelper;

    public SqliteVendaDao(Context context){
        sqliteHelper = new SqLiteHelper(context);
    }



    @Override
    public void incluir(Vendas venda) {
        SQLiteDatabase database = this.sqliteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Nome_Produto", venda.getNomeProdutoVendido());
        values.put("Valor", venda.getValorVenda());
        values.put("Qtde_Vendido", venda.getQtdeProdutosVendidos());
        database.insert("en_venda",null,values);
        database.close();
    }

    public List<Vendas> selectAll(){
        List<Vendas> vendas = new ArrayList<>();
        SQLiteDatabase database = this.sqliteHelper.getWritableDatabase();
        Cursor cursor = database.query("en_venda",new String[]{"Id_Venda","Nome_Produto","Valor","Qtde_Vendido"},null,null,null,null,null);
        while(cursor.moveToNext()){
            Vendas venda =  new Vendas(cursor.getString(1),cursor.getDouble(2),cursor.getInt(3));
            venda.setIdVendas(cursor.getInt(0));
            vendas.add(venda);
        }
        database.close();
        return vendas;
    }

    @Override
    public void excluir(int id) {
        SQLiteDatabase database = this.sqliteHelper.getWritableDatabase();
        database.execSQL("DELETE FROM en_Venda WHERE ID_Venda = "+id);
        database.close();
    }

    public void edit(String nome, double valor, int qtde) {
        SQLiteDatabase database = this.sqliteHelper.getWritableDatabase();
        database.rawQuery("UPDATE en_venda SET Nome_Produto = "+nome+",Valor = "+valor+",Qtde_Vendido = "+qtde,new String[] {"Id_Venda"});
        database.close();
    }


}