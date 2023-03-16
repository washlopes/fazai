package br.com.bb.dicre.gesem.fazai.exceptions;

public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -7385828648604835306L;

	public NotFoundException(String mensagem) {
		super(mensagem);
	}

}
