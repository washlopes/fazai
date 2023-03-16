package br.com.bb.dicre.gesem.fazai.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class SolicitacaoFazAiDto {
	
	private Long id;
	
	private String numero;
	
	private Long codigoCliente;

}
