package com.eduardomallmann.streams.manipulandolistas;

import com.eduardomallmann.streams.manipulandolistas.model.CatalogoRepository;
import com.eduardomallmann.streams.manipulandolistas.model.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

		// Catálogos válidos

		// Produtos dos catálogos válidos

		// Produtos ordenados por menor valor

		return null;
	}
}
