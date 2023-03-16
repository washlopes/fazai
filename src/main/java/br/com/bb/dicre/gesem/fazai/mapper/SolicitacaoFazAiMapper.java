package br.com.bb.dicre.gesem.fazai.mapper;

import br.com.bb.dicre.gesem.fazai.dto.SolicitacaoFazAiDto;
import br.com.bb.dicre.gesem.fazai.modelo.SolicitacaoFazAi;

public class SolicitacaoFazAiMapper {
	
	public static SolicitacaoFazAi fromDtoToEntity(SolicitacaoFazAiDto dto) {
		return SolicitacaoFazAi.builder()
			.id(dto.getId())
			.numero(dto.getNumero())
			.codigoCliente(dto.getCodigoCliente())
			.build();
	}

}
