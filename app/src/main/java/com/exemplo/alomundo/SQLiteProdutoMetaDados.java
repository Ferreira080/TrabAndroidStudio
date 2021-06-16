package com.exemplo.alomundo;

public class SQLiteProdutoMetaDados {
    /**
     * Armazena os metadados para a implementação em SQLite.
     *
     */
    public interface SQLiteClienteMetaDados {
        /**
         * string com o nome da tabela usada no banco
         */
        public static final String TABLE = "en_produto";
        /**
         * vetor de string com as chaves da tabela
         */
        public static final String[] PK = {"Id_Produto"};
        /**
         * string com os campos para serem utilizados com insert
         */
        public static String METADADOSINSERT = "Id_Produto, Nome, Valor, Qtde_Estoque";
        /**
         * Retorna uma string com os campos para serem utilizados com select
         */
        public static String METADADOSSELECT
                = TABLE + ".Id_Produto, "
                + TABLE + ".Nome, "
                + TABLE + ".Valor, "
                + TABLE + ".Qtde_Estoque";
    }
}
