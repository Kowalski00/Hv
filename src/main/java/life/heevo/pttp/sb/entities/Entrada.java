package life.heevo.pttp.sb.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "entradas")
public class Entrada {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IDetr")
	private Long id; // ID do Prontuario
	@Column(name = "DTCRIADOetr")
	@Temporal(value = TemporalType.DATE)
	private Date dataCriado; // Data de cria��o da entrada
	@Column(name="DSCR", nullable = false)
	private String descricao; // texto da entrada
	@ManyToOne
	@JoinColumn(name="ptr_id")
	private Prontuario prontuario;
	
	public Entrada() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataCriado() {
		return dataCriado;
	}

	public void setDataCriado(Date dataCriado) {
		this.dataCriado = dataCriado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
