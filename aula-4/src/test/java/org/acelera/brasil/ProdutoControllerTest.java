package org.acelera.brasil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = ProdutoController.class)
@ContextConfiguration(classes=ProdutoApp.class)
public class ProdutoControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private Storage storage;

	@InjectMocks
	@Autowired
	private ProdutoController produtoController;
	
	@Test
	@DisplayName("Deve receber uma mensagem informando que o produto foi criado com sucesso.")
	public void deveCriarProduto() throws Exception {
		Produto produto = new Produto();
		produto.setNome("Produto");
		
		String mensagemEsperada = String.format("Produto salvo com sucesso - %s", produto.getNome());
		
		ObjectMapper objectMapper = new ObjectMapper();
		String produtoJson = objectMapper.writeValueAsString(produto);

		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.post("/produtos")
						.contentType(MediaType.APPLICATION_JSON)
						.content(produtoJson).accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isCreated()).andReturn();

		assertEquals(mensagemEsperada, mvcResult.getResponse().getContentAsString());
		
		Mockito.verify(storage, Mockito.times(1)).put(Mockito.any(Produto.class));
	}
	
	@Test
	@DisplayName("Deve receber as informações de um produto obtido a partir do seu identificador único")
	public void deveBuscarProduto() throws Exception {
		Long produtoId = 1L;
		
		Produto produto = new Produto();
		produto.setId(produtoId);
		produto.setNome("Produto");
		
		Mockito.when(storage.get(produtoId)).thenReturn(produto);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(
						String.format("/produtos/%s", produtoId))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk()).andReturn();
		
		Produto produtoObtido = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Produto.class);
		
		assertEquals(produto.getId(), produtoObtido.getId());
		assertEquals(produto.getNome(), produtoObtido.getNome());
	}
	
	@Test
	@DisplayName("Deve atualizar as informações de um produto obtido a partir do seu identificador único")
	public void deveAtualizarProduto() throws Exception {
		Long produtoId = 1L;
		
		Produto produto = new Produto();
		produto.setId(produtoId);
		produto.setNome("Produto");
		
		Mockito.when(storage.update(Mockito.anyLong(), Mockito.any(Produto.class))).thenReturn(produto);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String produtoJson = objectMapper.writeValueAsString(produto);
		
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.put(
						String.format("/produtos/%s", produtoId))
						.content(produtoJson)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk()).andReturn();
		
		Produto produtoObtido = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Produto.class);
		
		assertEquals(produto.getId(), produtoObtido.getId());
		assertEquals(produto.getNome(), produtoObtido.getNome());
	}
	
	
	@Test
	@DisplayName("Deve remover um produto cadastrado")
	public void deveRemoverProduto() throws Exception {
		Long produtoId = 1L;
		
		Produto produto = new Produto();
		produto.setId(produtoId);
		produto.setNome("Produto");
		
		Mockito.when(storage.remove(produtoId)).thenReturn(produto);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.delete(
						String.format("/produtos/%s", produtoId))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk()).andReturn();
		
		Produto produtoObtido = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Produto.class);
		
		assertEquals(produto.getId(), produtoObtido.getId());
		assertEquals(produto.getNome(), produtoObtido.getNome());
	}
}
