package org.acelera.brasil.pessoa;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(JUnitPlatform.class)
public class PessoaBuilderTest {

  @Test
  void deveCriarUmaPessoaComTodasAsPropriedadesSetadasDuranteAConstrao(){

    Pessoa pessoaConstruidaPeloPessoaBuilder = Pessoa.builder()
      .withNome("pessoa de teste : )")
      .withIdade(33)
      .withCidade("Testopolis")
      .withPais("Testestão")
      .withRg("227605536")
      .withCpf("28808499502")
      .withEmail("test@teeste.com")
      .withSexo(Sexo.MASCULINO)
      .build();

    assertSame(
      "pessoa de teste : )",
      pessoaConstruidaPeloPessoaBuilder.getNome()
    );
    assertSame(
      33,
      pessoaConstruidaPeloPessoaBuilder.getIdade()
    );
    assertSame(
      "Testopolis",
      pessoaConstruidaPeloPessoaBuilder.getCidade()
    );
    assertSame(
      "Testestão",
      pessoaConstruidaPeloPessoaBuilder.getPais()
    );
    assertSame(
      "227605536",
      pessoaConstruidaPeloPessoaBuilder.getRg()
    );
    assertSame(
      "28808499502",
      pessoaConstruidaPeloPessoaBuilder.getCpf()
    );
    assertSame(
      "test@teeste.com",
      pessoaConstruidaPeloPessoaBuilder.getEmail()
    );
    assertSame(
      Sexo.MASCULINO,
      pessoaConstruidaPeloPessoaBuilder.getSexo()
    );
  };

  @Test
  void deveJogarUmaNullPointerExceptionAoTentarCriarUmaPessoaSemNome(){
    PessoaBuilder pessoaBuilder = Pessoa.builder()
      .withIdade(33)
      .withCidade("Testopolis")
      .withPais("Testestão")
      .withRg("227605536")
      .withCpf("28808499502")
      .withEmail("test@teeste.com")
      .withSexo(Sexo.MASCULINO);

      assertThrows(
        NullPointerException.class,
        pessoaBuilder::build
      );
  }

  @Test
  void deveJogarUmaNullPointerExceptionAoTentarCriarUmaPessoaSemCidade(){
    PessoaBuilder pessoaBuilder = Pessoa.builder()
      .withNome("TEEESTE")
      .withIdade(33)
      .withPais("Testestão")
      .withRg("227605536")
      .withCpf("28808499502")
      .withEmail("test@teeste.com")
      .withSexo(Sexo.MASCULINO);

      assertThrows(
        NullPointerException.class,
        pessoaBuilder::build
      );
  }

  @Test
  void deveJogarUmaNullPointerExceptionAoTentarCriarUmaPessoaSemPais(){
    PessoaBuilder pessoaBuilder = Pessoa.builder()
      .withNome("TEEESTE")
      .withIdade(33)
      .withCidade("Testopolis")
      .withRg("227605536")
      .withCpf("28808499502")
      .withEmail("test@teeste.com")
      .withSexo(Sexo.MASCULINO);

      assertThrows(
        NullPointerException.class,
        pessoaBuilder::build
      );
  }
}
