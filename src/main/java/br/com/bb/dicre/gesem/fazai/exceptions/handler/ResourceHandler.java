package br.com.bb.dicre.gesem.fazai.exceptions.handler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.bb.dicre.gesem.fazai.dto.error.ErrorResponseDto;
import br.com.bb.dicre.gesem.fazai.exceptions.BadRequestException;
import br.com.bb.dicre.gesem.fazai.exceptions.NotFoundException;

@RestControllerAdvice
public class ResourceHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity <ErrorResponseDto> notFoundException(NotFoundException nfe) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
			ErrorResponseDto.builder()
				.mensagem(nfe.getLocalizedMessage())
				.status(HttpStatus.NOT_FOUND)
				.codigo(HttpStatus.NOT_FOUND.value())
				.build()
		);
		
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity <ErrorResponseDto> badRequestException(BadRequestException bre) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
			ErrorResponseDto.builder()
				.mensagem(bre.getLocalizedMessage())
				.status(HttpStatus.BAD_REQUEST)
				.codigo(HttpStatus.BAD_REQUEST.value())
				.build()
		);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity <ErrorResponseDto> methodArgumentNotValidException(MethodArgumentNotValidException manve) {
		
		Map <String, String> mensagens = new HashMap <> ();
		
		manve.getBindingResult().getAllErrors().forEach(erro -> {
			String campo = ((FieldError) erro).getField();
			String mensagemPadrao = erro.getDefaultMessage();
			mensagens.put(campo, mensagemPadrao);
		});		
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				ErrorResponseDto.builder()
					.mensagem(Arrays.toString(mensagens.entrySet().toArray()))
					.status(HttpStatus.BAD_REQUEST)
					.codigo(HttpStatus.BAD_REQUEST.value())
					.build()
		);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity <ErrorResponseDto> dataIntegrityViolationException(DataIntegrityViolationException dive) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
			ErrorResponseDto.builder()
				.mensagem(dive.getLocalizedMessage())
				.status(HttpStatus.BAD_REQUEST)
				.codigo(HttpStatus.BAD_REQUEST.value())
				.build()
		);
	}

}
