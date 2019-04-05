package org.acelera.brasil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private MongoTemplate template;


    public List<Person> buscar(Filtro filtro) {
        Query query = new Query();

//        if (filtro.isTemFoto()) {
//            query.addCriteria(Criteria.where("foto").ne(null));
//        } else {
//            query.addCriteria(Criteria.where("foto").is(null));
//        }

        query.addCriteria(Criteria.where("nome").is(filtro.getNome()));
        query.addCriteria(Criteria.where("altura").lte(filtro.getAltura()));
        return template.find(query, Person.class);
    }
}