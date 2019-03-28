package org.acelera.brasil;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class Storage {

    private Map<Long, Produto> data = new HashMap<>();


    public Produto get(long id) {
        return data.get(id);
    }

    public Produto update(long id, Produto produto) {
        return data.computeIfPresent(id, (k, v) -> produto);
    }

    public Produto remove(long id) {
        return data.remove(id);
    }

    public void put(Produto produto) {
        data.put(produto.getId(), produto);
    }
}
