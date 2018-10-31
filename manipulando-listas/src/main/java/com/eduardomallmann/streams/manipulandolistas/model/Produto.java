package com.eduardomallmann.streams.manipulandolistas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	@Column(name = "id_catalogo", nullable = false)
	private String idCatalogo;
	@Column(name = "codigo_produto", nullable = false)
	private String codigoProduto;
	@Digits(integer = 6, fraction = 4)
	@Column(precision = 10, scale = 4, columnDefinition = "decimal(10, 4)")
	private BigDecimal precoVenda;
	private Boolean ativo;
	private Boolean promocional;

}
