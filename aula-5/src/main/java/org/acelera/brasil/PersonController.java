package org.acelera.brasil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/people", produces = "application/json")
    public List<Person> find(@RequestParam Map<String, String> params) {
        Filtro filtro = Filtro.of(params);
        return personService.buscar(filtro);
    }
}
