package br.com.bb.dicre.gesem.fazai.dto.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponseDto {
	
	private String mensagem;
	
	private HttpStatus status;
	
	private Integer codigo;

}
