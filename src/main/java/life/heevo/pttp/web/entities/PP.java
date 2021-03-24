package life.heevo.pttp.web.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Representa um Profissional Prescritor
 * 
 * @author hl
 * @author rk
 *
 */
@Entity
@Table(name = "pps")
public class PP {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IDpp")
	private long id;
	@Column(name="NOMpp", nullable = false, length = 255)
	private String nome;
	@Column(name="CPFpp", nullable = false, unique = true, length=11)
	private String cpf;
	@Column(name = "CRPpp", nullable = true, length=20)
	private String codRegPro;
	@Column(name = "CRPUFpp", nullable = true, length=2)
	private String crpUf;
	@Column(name = "MAILpp", nullable = true, length=255)
	private String email;
	@Column(name = "DTNASCpp", nullable = true)
	@Temporal(value = TemporalType.DATE)
	private Date DTNASCpp;
	@Column(name = "CEPRESpp", nullable = true, length=8)
	private String CepRes;
	@Column(name = "LGRRESpp", nullable = true, length=10)
	private String LgrRes;
	@Column(name = "RUARESpp", nullable = true, length=255)
	private String RuaRes;
	@Column(name = "BAIRESpp", nullable = true, length=255)
	private String BaiRes;
	@Column(name = "CIDRESpp", nullable = true, length=255)
	private String CidRes;
	@Column(name = "ESTRESpp", nullable = true, length=255)
	private String EstRes;
	@Column(name = "CEPCOMpp", nullable = true, length=8)
	private String CepCom;
	@Column(name = "LGRCOMpp", nullable = true, length=10)
	private String LgrCom;
	@Column(name = "RUACOMpp", nullable = true, length=255)
	private String RuaCom;
	@Column(name = "BAICOMpp", nullable = true, length=255)
	private String BaiCom;
	@Column(name = "CIDCOMpp", nullable = true, length=255)
	private String CidCom;
	@Column(name = "ESTCOMpp", nullable = true, length=255)
	private String EstCom;
	@Column(name = "TELRESpp", nullable = true, length=14)
	private String TelRes;
	@Column(name = "TELCOMpp", nullable = true, length=14)
	private String TelCom;
	@Column(name = "DTCRIADOpp", nullable = true)
	@Temporal(value = TemporalType.DATE)
	private Date DTCRIADOpp;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pp")
	private List<Prontuario> prontuarios;
	
	public PP() {
	}
	
	

	@Override
	public String toString() {
		return "PP [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCodRegPro() {
		return codRegPro;
	}

	public void setCodRegPro(String codRegPro) {
		this.codRegPro = codRegPro;
	}

	public String getCrpUf() {
		return crpUf;
	}

	public void setCrpUf(String crpUf) {
		this.crpUf = crpUf;
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

	public String getCepCom() {
		return CepCom;
	}

	public void setCepCom(String cepCom) {
		CepCom = cepCom;
	}

	public String getLgrCom() {
		return LgrCom;
	}

	public void setLgrCom(String lgrCom) {
		LgrCom = lgrCom;
	}

	public String getRuaCom() {
		return RuaCom;
	}

	public void setRuaCom(String ruaCom) {
		RuaCom = ruaCom;
	}

	public String getBaiCom() {
		return BaiCom;
	}

	public void setBaiCom(String baiCom) {
		BaiCom = baiCom;
	}

	public String getCidCom() {
		return CidCom;
	}

	public void setCidCom(String cidCom) {
		CidCom = cidCom;
	}

	public String getEstCom() {
		return EstCom;
	}

	public void setEstCom(String estCom) {
		EstCom = estCom;
	}

	public String getTelRes() {
		return TelRes;
	}

	public void setTelRes(String telRes) {
		TelRes = telRes;
	}

	public String getTelCom() {
		return TelCom;
	}

	public void setTelCom(String telCom) {
		TelCom = telCom;
	}

	public Date getDTCRIADOpp() {
		return DTCRIADOpp;
	}

	public void setDTCRIADOpp(Date dTCRIADOpp) {
		DTCRIADOpp = dTCRIADOpp;
	}

	public List<Prontuario> getProntuarios() {
		return prontuarios;
	}

	public void setProntuarios(List<Prontuario> prontuarios) {
		this.prontuarios = prontuarios;
	}
	
}
