package life.heevo.pttp.sb.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "expertises")
public class Especialidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	@Column(name="descricao", columnDefinition = "TEXT")
	private String descricao;
	@ManyToMany
	@JoinTable(
			name="pps_expertises",
			joinColumns = {@JoinColumn(name="idExpertise",referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "idPp", referencedColumnName = "id")}
	)
	private List<PP> pps;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<PP> getPps() {
		return pps;
	}
	public void setPps(List<PP> pps) {
		this.pps = pps;
	}
	
	
}
