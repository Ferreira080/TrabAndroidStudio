package com.exemplo.alomundo;

import java.util.List;

public interface produtoDao {

        public void incluir(Produto produto);
        public void excluir(int id);
        public List<Produto> selectAll();
    
}
