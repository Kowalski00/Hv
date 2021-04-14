package life.heevo.pttp.sb.entities;

import java.util.ArrayList;
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

/**
 * Representa um usuário do sistema, podendo ser Paciente ou Profissional.
 * Um Usuário possuirá perfis, de Admin, Profissional ou Paciente.
 * 
 * @author rk
 *
 */
@Entity
@Table(name = "users")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	@Column(name="ATIVO", columnDefinition = "TINYINT(1)")
	private boolean ativo;
	@Column(name="CPF", nullable = false, unique = true, length=11)
	private String cpf;
	@Column(name = "PASSWORD", nullable = false, length=150)
	private String password;
	@Column(name = "CODVER", nullable = true, length=6)
	private String CODVER;
	@ManyToMany
	@JoinTable(
		name="user_profiles",
		joinColumns = {@JoinColumn(name="idUser",referencedColumnName = "id")},
		inverseJoinColumns = {@JoinColumn(name = "idProfile", referencedColumnName = "id")}
	)
	private List<Perfil> perfis;
	
	
	
	public Usuario() {
		super();
	}
	


	public Usuario(long id) {
		this.id = id;
	}
	
	public void addPerfil(PerfilTipo tipo) {
		if(this.perfis == null) {
			this.perfis = new ArrayList<>();
		}
		this.perfis.add(new Perfil(tipo.getCod()));
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCODVER() {
		return CODVER;
	}
	public void setCODVER(String CODVER) {
		this.CODVER = CODVER;
	}
	
	public List<Perfil> getPerfis() {
		return perfis;
	}



	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
	
	
}
