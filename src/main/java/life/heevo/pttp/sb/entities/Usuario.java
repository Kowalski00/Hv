package life.heevo.pttp.sb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	@Column(name="ATIVO")
	private boolean ativo;
	@Column(name="CPF", nullable = false, unique = true, length=11)
	private String cpf;
	@Column(name = "PASSWORD", nullable = false, length=150)
	private String password;
	@Column(name = "ROLE", nullable = true, length=14)
	private String role;
	@Column(name = "CODVER", nullable = true, length=6)
	private String CODVER;
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pp_id")
	private PP pp;
	
	
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCODVER() {
		return CODVER;
	}
	public void setCODVER(String CODVER) {
		this.CODVER = CODVER;
	}
	
	
}
