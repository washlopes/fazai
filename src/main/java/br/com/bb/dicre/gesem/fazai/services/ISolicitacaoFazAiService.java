package br.com.bb.dicre.gesem.fazai.services;

import java.util.List;

import br.com.bb.dicre.gesem.fazai.dto.SolicitacaoFazAiDto;
import br.com.bb.dicre.gesem.fazai.modelo.SolicitacaoFazAi;

public interface ISolicitacaoFazAiService {
	
	List <SolicitacaoFazAi> findAll();
	
	SolicitacaoFazAi findById(Long id);
	
	SolicitacaoFazAi findByMci(Long mci);
	
	SolicitacaoFazAi findByNumero(String numero);
	
	SolicitacaoFazAi criar(SolicitacaoFazAiDto solicitacao);
	
	SolicitacaoFazAi atualizar(SolicitacaoFazAiDto solicitacao, Long id);	
	
	void excluir(Long id);	

}
