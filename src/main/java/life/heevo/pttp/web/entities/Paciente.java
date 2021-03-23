package life.heevo.pttp.web.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Representa um Paciente
 * 
 * @author hl
 * @author rk
 *
 */
@Entity
@Table(name = "pacientes")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="IDpct")
	private Long id;
	@Column(name="CPFpct", nullable = false, unique = true, length=11)
	private String cpf;
	@Column(name="NOMpct", nullable = false, length = 255)
	private String Nome;
	@Column(name = "MAILpct", nullable = true, length=255)
	private String email;
	@Column(name = "DTNASCpct", nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date DTNASCpp;
	@Column(name = "CEPRESpct", nullable = true, length=8)
	private String CepRes;
	@Column(name = "LGRRESpct", nullable = false, length=10)
	private String LgrRes;
	@Column(name = "RUARESpct", nullable = false, length=255)
	private String RuaRes;
	@Column(name = "BAIRESpct", nullable = false, length=255)
	private String BaiRes;
	@Column(name = "CIDRESpct", nullable = false, length=255)
	private String CidRes;
	@Column(name = "ESTRESpct", nullable = false, length=255)
	private String EstRes;
	@Column(name = "TELRESpct", nullable = true, length=14)
	private String TelRes;
	@Column(name = "DTCRIADOpct", nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date dataCriado;
	@OneToMany(mappedBy = "paciente")
	private List<Prontuario> prontuarios;
	
	public Paciente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDTNASCpp() {
		return DTNASCpp;
	}

	public void setDTNASCpp(Date dTNASCpp) {
		DTNASCpp = dTNASCpp;
	}

	public String getCepRes() {
		return CepRes;
	}

	public void setCepRes(String cepRes) {
		CepRes = cepRes;
	}

	public String getLgrRes() {
		return LgrRes;
	}

	public void setLgrRes(String lgrRes) {
		LgrRes = lgrRes;
	}

	public String getRuaRes() {
		return RuaRes;
	}

	public void setRuaRes(String ruaRes) {
		RuaRes = ruaRes;
	}

	public String getBaiRes() {
		return BaiRes;
	}

	public void setBaiRes(String baiRes) {
		BaiRes = baiRes;
	}

	public String getCidRes() {
		return CidRes;
	}

	public void setCidRes(String cidRes) {
		CidRes = cidRes;
	}

	public String getEstRes() {
		return EstRes;
	}

	public void setEstRes(String estRes) {
		EstRes = estRes;
	}

	public String getTelRes() {
		return TelRes;
	}

	public void setTelRes(String telRes) {
		TelRes = telRes;
	}

	public Date getDataCriado() {
		return dataCriado;
	}

	public void setDataCriado(Date dataCriado) {
		this.dataCriado = dataCriado;
	}

	public List<Prontuario> getProntuarios() {
		return prontuarios;
	}

	public void setProntuarios(List<Prontuario> prontuarios) {
		this.prontuarios = prontuarios;
	}

}
