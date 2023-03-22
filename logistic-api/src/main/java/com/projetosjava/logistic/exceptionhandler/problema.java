package com.projetosjava.logistic.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class problema {
	
	private Integer status;
	private LocalDateTime dataHora;
	private String descricao;
	private List<campo> campos;
	
	@AllArgsConstructor
	@Getter
	public static class campo {
		private String nome;
		private String mensagem;
	}
	

}
