package org.acelera.brasil;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PersonControllerTest {


    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;


    @Test
    public void deveRetornarErroQuandoForMuitoGrande() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(getUrl())
                .queryParam("nome", "Val")
                .queryParam("altura", 500)
                .queryParam("foto", "url");

        ResponseEntity<?> entity = template.exchange(builder.toUriString(),
                HttpMethod.GET,
                new HttpEntity<>(headers),
                (Class<Object>) null);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, entity.getStatusCode());

    }


    @Test
    public void deveRetornarABuscaPeloNome() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(getUrl())
                .queryParam("nome", "Val")
                .queryParam("altura", 190)
                .queryParam("foto", "url");

        ResponseEntity<List<Person>> entity = template.exchange(builder.toUriString(),
                HttpMethod.GET,
                new HttpEntity<>(headers),
                new ParameterizedTypeReference<List<Person>>() {
                });

        Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());

        List<Person> pessoas = entity.getBody();
        Assertions.assertEquals(1, pessoas.size());
        List<String> nomes = pessoas.stream().map(Person::getNome).collect(Collectors.toList());

        MatcherAssert.assertThat(nomes, Matchers.contains("Val"));


    }

    public String getUrl() {
        return "http://localhost:" + port + "/people";
    }
}