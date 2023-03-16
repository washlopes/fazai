package br.com.bb.dicre.gesem.fazai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.dicre.gesem.fazai.dto.SolicitacaoFazAiDto;
import br.com.bb.dicre.gesem.fazai.modelo.SolicitacaoFazAi;
import br.com.bb.dicre.gesem.fazai.services.impl.SolicitacaoFazAiServiceImpl;

@RestController
public class SolicitacaoFazAiController {
	
	@Autowired
	private SolicitacaoFazAiServiceImpl servico;
	
	@GetMapping("/solicitacoes")
	public ResponseEntity <List <SolicitacaoFazAi> > buscarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(servico.findAll());
	}
	
	@GetMapping("/solicitacoes/{id}")
	public ResponseEntity <SolicitacaoFazAi> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(servico.findById(id));
	}
	
	@GetMapping("/solicitacaomci/{mci}")
	public ResponseEntity <SolicitacaoFazAi> buscarPorMciLong (@PathVariable Long mci) {
		return ResponseEntity.status(HttpStatus.OK).body(servico.findByMci(mci));
	}
	
	@GetMapping("/solicitacaonumero/{numero}")
	public ResponseEntity <SolicitacaoFazAi> buscarPorMciLong (@PathVariable String numero) {
		return ResponseEntity.status(HttpStatus.OK).body(servico.findByNumero(numero));
	}
	
	@PostMapping("/solicitacoes")
	public ResponseEntity <SolicitacaoFazAi> criar(@RequestBody SolicitacaoFazAiDto solicitacao) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(servico.criar(solicitacao));
		
	}

}
