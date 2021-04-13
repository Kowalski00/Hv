package life.heevo.pttp.sb.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Representa um prontu�rio
 * 
 * @author hl
 * @author rk
 *
 */
@Entity
@Table(name = "prontuarios")
public class Prontuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IDptr")
	private Long id;
	@Column(name = "DTCRIADOptr")
	@Temporal(value = TemporalType.DATE)
	private Date dataCriado; // Data de cria��o do prontu�rio (n�o da entrada)
	@ManyToOne
	@JoinColumn(name="pp_id")
	private PP pp;
	@ManyToOne
	@JoinColumn(name="pct_id")
	private Paciente paciente;
	@OneToMany(mappedBy = "prontuario")
	private List<Prescricao> prcc;
	@OneToMany(mappedBy = "prontuario")
	private List<Entrada> entrada;
	
	public Prontuario() {
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

	public PP getPp() {
		return pp;
	}

	public void setPp(PP pp) {
		this.pp = pp;
	}

	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Prescricao> getPrcc() {
		return prcc;
	}

	public void setPrcc(List<Prescricao> prcc) {
		this.prcc = prcc;
	}

	public List<Entrada> getEntrada() {
		return entrada;
	}

	public void setEntrada(List<Entrada> entrada) {
		this.entrada = entrada;
	}
	
	
}
