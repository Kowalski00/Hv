package life.heevo.pttp.sb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Representa um Medicamento
 * 
 * @author hl
 * @author rk
 *
 */
@Entity
@Table(name = "medicamentos")
public class Medicamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IDmdc")
	private Long id;
	@Column(name = "NOMEmdc", nullable = true, length=255)
	private String nome;
	@Column(name = "TIPmdc")
	private String tipo;
	@Column(name = "DOSmdc")
	private String dosagem;
	@Column(name = "FRQmdc", length=255)
	private String frequencia;
	@Column(name = "QTDmdc")
	private int qtde;
	@ManyToOne
	@JoinColumn(name="prescricao_id")
	private Prescricao prescricao;
	
	public Medicamento() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}

	public String getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public Prescricao getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(Prescricao prescricao) {
		this.prescricao = prescricao;
	}

	
	
}
