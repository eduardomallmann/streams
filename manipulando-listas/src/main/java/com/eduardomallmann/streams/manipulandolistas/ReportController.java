package com.eduardomallmann.streams.manipulandolistas;

import com.eduardomallmann.streams.manipulandolistas.model.Catalogo;
import com.eduardomallmann.streams.manipulandolistas.model.CatalogoRepository;
import com.eduardomallmann.streams.manipulandolistas.model.Produto;
import com.eduardomallmann.streams.manipulandolistas.model.ProdutoRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RestController
@RequestMapping("/consult")
public class ReportController {

	private CatalogoRepository catalogoRepository;
	private ProdutoRepository produtoRepository;

	public ReportController(CatalogoRepository catalogoRepository,
							ProdutoRepository produtoRepository) {
		this.catalogoRepository = catalogoRepository;
		this.produtoRepository = produtoRepository;
	}

	@GetMapping
	public ResponseEntity<List<ReportResponse>> getReportFrom() {

		Gson jsonConverter = new Gson();

		// Catálogos válidos
		Stream<Catalogo> catalogos = catalogoRepository.findAll().parallelStream()
				.filter(catalogo -> catalogo.getAtivo() && catalogo.getDataValidadeCatalogo().after(new Date()));

		List<String> catalogosIds = catalogos.map(Catalogo::getIdCatalogo).collect(Collectors.toList());

		log.debug("Catalogos Ids: \n {}", jsonConverter.toJson(catalogosIds));

		// Produtos dos catálogos válidos
		Stream<Produto> produtos = produtoRepository.findAll().stream()
				.filter(produto -> produto.getAtivo() && !produto.getPromocional() && catalogosIds.contains(produto.getIdCatalogo()));

		Map<String, List<Produto>> mapaDeProdutos = produtos.collect(Collectors.groupingBy(Produto::getIdCatalogo));

		log.debug("Produtos mapeados: \n {}", jsonConverter.toJson(mapaDeProdutos));

		// Produtos ordenados por menor valor
		List<ReportResponse> responseList = mapaDeProdutos.entrySet().parallelStream()
				.map(mapa -> ReportResponse.builder()
						.catalogo(mapa.getKey())
						.produtos(mapa.getValue().stream().map(produto -> ProdutoResponse.builder()
								.codigoProduto(produto.getCodigoProduto())
								.precoVenda(produto.getPrecoVenda())
								.build())
								.sorted(Comparator.comparing(ProdutoResponse::getPrecoVenda)).collect(Collectors.toList()))
						.build())
				.collect(Collectors.toList());

		log.debug("Resposta da requisição: \n {}", jsonConverter.toJson(responseList));

		return ResponseEntity.ok(responseList);
	}
}
