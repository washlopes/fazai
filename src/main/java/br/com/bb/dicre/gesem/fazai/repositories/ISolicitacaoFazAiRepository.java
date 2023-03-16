package br.com.bb.dicre.gesem.fazai.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bb.dicre.gesem.fazai.modelo.SolicitacaoFazAi;

public interface ISolicitacaoFazAiRepository extends JpaRepository<SolicitacaoFazAi, Long> {

	@Query("select s from SolicitacaoFazAi s where s.codigoCliente = :codigoCliente")
	public Optional <SolicitacaoFazAi> findByMci(Long codigoCliente);
	
	@Query("select s from SolicitacaoFazAi s where s.numero = :numero")
	public Optional <SolicitacaoFazAi> findByNumero(String numero);
}
