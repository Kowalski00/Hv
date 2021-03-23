package life.heevo.pttp.web.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import life.heevo.pttp.web.entities.Paciente;
import life.heevo.pttp.web.utils.JpaUtils;

public class PacienteService {

	public List<Paciente> listarTodosPcts(){
		List<Paciente> pacientes = new ArrayList<Paciente>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			pacientes = em.createQuery("from Paciente",Paciente.class).getResultList();
			return pacientes;
		} finally {
			if(em!=null)
				em.close();
		}
	}
	public void inserirPct(Paciente paciente) {
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			em.getTransaction().begin();
			em.persist(paciente);
			em.getTransaction().commit();
		} finally {
			if(em!=null)
				em.close();
		}
	}
	public Paciente buscarPctPorId(Long id) {
		EntityManager em = null;
		Paciente pct = new Paciente();
		try {
			em = JpaUtils.getEntityManager();
			pct = em.find(Paciente.class, id);
			return pct;
		} finally {
			if(em!=null)
				em.close();
		}
	}
	public List<Paciente> pesquisarPctPorNome(String nome){
		List<Paciente> pacientes = new ArrayList<Paciente>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			pacientes = em.createQuery("FROM Paciente pct WHERE LOWER(pct.nome) LIKE LOWER(CONCAT('%',:nome,'%'))",Paciente.class).setParameter("nome", nome).getResultList();
			return pacientes;
		} finally {
			if(em!=null)
				em.close();
		}
	}
	public List<Paciente> pesquisarPctPorCpf(String cpf){
		List<Paciente> pacientes = new ArrayList<Paciente>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			pacientes = em.createQuery("FROM Paciente pct WHERE LOWER(pct.cpf) LIKE LOWER(CONCAT('%',:cpf,'%'))",Paciente.class).setParameter("cpf", cpf).getResultList();
			return pacientes;
		} finally {
			if(em!=null)
				em.close();
		}
	}
}
