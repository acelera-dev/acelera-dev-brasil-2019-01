package org.acelera.brasil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class Storage {


    @Autowired
    private ProdutoRepository repository;


    public Produto get(long id) {
        return repository.findById(id).get();
    }

    public Produto update(long id, Produto produto) {
        return repository.save(produto);
    }

    public Produto remove(long id) {
        Produto produto = repository.findById(id).get();
        repository.deleteById(id);
        return produto;
    }

    public void put(Produto produto) {
        repository.save(produto);
    }
}
