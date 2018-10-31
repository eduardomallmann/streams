package com.eduardomallmann.streams.manipulandolistas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReportResponse {

	private String catalogo;
	private List<ProdutoResponse> produtos;

}

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
class ProdutoResponse {

	private String codigoProduto;
	private BigDecimal precoVenda;
}
