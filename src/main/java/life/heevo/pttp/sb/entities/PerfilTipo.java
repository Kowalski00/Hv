package life.heevo.pttp.sb.entities;

public enum PerfilTipo {
	ADMIN(1, "ADMIN"), PROFISSIONAL(2, "PROFISSIONAL"), PACIENTE(3, "PACIENTE");
	
	private long cod;
	private String desc;
	
	private PerfilTipo(long cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public Long getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}
	
	
}
