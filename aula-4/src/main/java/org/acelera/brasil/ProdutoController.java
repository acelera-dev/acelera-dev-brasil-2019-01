package org.acelera.brasil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private Storage storage;


    @PostMapping
    public String save(@RequestBody Produto produto) {
        storage.put(produto);
        return "Produto salvo com sucesso" + produto.getNome();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Produto get(@PathVariable("id") long id) {
        return storage.get(id);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Produto update(@PathVariable("id") long id, @RequestBody Produto produto) {
        return storage.update(id, produto);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public Produto delete(@PathVariable("id") long id) {
        return storage.remove(id);
    }


}
