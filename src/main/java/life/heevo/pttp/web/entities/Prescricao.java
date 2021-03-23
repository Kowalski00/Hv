package life.heevo.pttp.web.entities;

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
 * Representa uma Prescrição
 * 
 * @author hl
 * @author rk
 *
 */
@Entity
@Table(name = "prescricoes")
public class Prescricao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="IDprcc")
	private Long id;
	@Column(name = "DTCRIADOptr")
	@Temporal(value = TemporalType.DATE)
	private Date dataCriado;
	@ManyToOne
	@JoinColumn(name="ptr_id")
	private Prontuario prontuario;
	@OneToMany(mappedBy = "prescricao")
	private List<Medicamento> medicamento;
	
	public Prescricao() {
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

	public Prontuario getProntuario() {
		return prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}

	public List<Medicamento> getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(List<Medicamento> medicamento) {
		this.medicamento = medicamento;
	}

	
	
	
	
}
