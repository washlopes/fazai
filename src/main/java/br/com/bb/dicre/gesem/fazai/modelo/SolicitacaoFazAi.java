package br.com.bb.dicre.gesem.fazai.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="solicitacao", schema="fazai")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class SolicitacaoFazAi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "solicitacao_id_seq")
	@SequenceGenerator(name = "solicitacao_id_seq", sequenceName = "solicitacao_id_seq", schema="fazai", allocationSize = 1)
	private Long id;
	
	private String numero;
	
	@Column(name="cd_cli")
	private Long codigoCliente;
	
	

}
