package br.com.bb.dicre.gesem.fazai.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.bb.dicre.gesem.fazai.dto.SolicitacaoFazAiDto;
import br.com.bb.dicre.gesem.fazai.exceptions.BadRequestException;
import br.com.bb.dicre.gesem.fazai.exceptions.NotFoundException;
import br.com.bb.dicre.gesem.fazai.mapper.SolicitacaoFazAiMapper;
import br.com.bb.dicre.gesem.fazai.modelo.SolicitacaoFazAi;
import br.com.bb.dicre.gesem.fazai.repositories.ISolicitacaoFazAiRepository;
import br.com.bb.dicre.gesem.fazai.services.ISolicitacaoFazAiService;

@Service
public class SolicitacaoFazAiServiceImpl implements ISolicitacaoFazAiService {

	private final ISolicitacaoFazAiRepository repositorio;
	
	public SolicitacaoFazAiServiceImpl(ISolicitacaoFazAiRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	@Override
	public List <SolicitacaoFazAi> findAll() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public SolicitacaoFazAi findById(Long id) {
		// TODO Auto-generated method stub		
		return getSolicitacao(id);
	}

	@Override
	public SolicitacaoFazAi findByMci(Long mci) {
		// TODO Auto-generated method stub
		return getSolicitacaoPeloMci(mci);		
	}
	
	@Override
	public SolicitacaoFazAi findByNumero(String numero) {
		// TODO Auto-generated method stub
		return getSolicitacaoPeloNumero(numero);
	}

	@Override
	public SolicitacaoFazAi criar(SolicitacaoFazAiDto solicitacao) {
		// TODO Auto-generated method stub
		if (Objects.nonNull(solicitacao.getId())) {
			throw new BadRequestException("O id deve ser nulo!");
		}
		
		return repositorio.save(SolicitacaoFazAiMapper.fromDtoToEntity(solicitacao));
	}

	@Override
	public SolicitacaoFazAi atualizar(SolicitacaoFazAiDto solicitacao, Long id) {
		// TODO Auto-generated method stub
		
		getSolicitacao(id);	
		
		solicitacao.setId(id);
		
		return repositorio.save(SolicitacaoFazAiMapper.fromDtoToEntity(solicitacao));
		
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		
		getSolicitacao(id);
		
		repositorio.deleteById(id);
	}

	private SolicitacaoFazAi getSolicitacao(Long id) {
		
		Optional <SolicitacaoFazAi> solicitacao = repositorio.findById(id);
		
		if (solicitacao.isEmpty()) {
			throw new NotFoundException("Solicitacao não encontrada!");
		}
		
		return solicitacao.get();
	}
	
	private SolicitacaoFazAi getSolicitacaoPeloMci(Long mci) {
		
		Optional <SolicitacaoFazAi> solicitacao = repositorio.findByMci(mci);
		
		if (solicitacao.isEmpty()) {
			throw new NotFoundException("Solicitacao não encontrada!");
		}
		
		return solicitacao.get();
	}
	
	private SolicitacaoFazAi getSolicitacaoPeloNumero(String numero) {
		
		Optional <SolicitacaoFazAi> solicitacao = repositorio.findByNumero(numero);
		
		if (solicitacao.isEmpty()) {
			throw new NotFoundException("Solicitacao não encontrada!");
		}
		
		return solicitacao.get();
	}
	
}
