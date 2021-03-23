package life.heevo.pttp.web.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import life.heevo.pttp.web.entities.Prontuario;
import life.heevo.pttp.web.utils.JpaUtils;

public class ProntuarioService {

	public List<Prontuario> listarTodosPtrs(){
		List<Prontuario> ptrs = new ArrayList<Prontuario>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			ptrs = em.createQuery("FROM Prontuario",Prontuario.class).getResultList();
		} finally {
			if(em!=null)
				em.close();
		}
		return ptrs;
	}
	
	public Prontuario buscarPtrPorId(Long id) {
		Prontuario ptr = new Prontuario();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			ptr = em.find(Prontuario.class, id);
		} finally {
			if(em!=null)
				em.close();
		}
		return ptr;
	}
	
	public List<Prontuario> buscarPtrPorPP(Long id) {
		List<Prontuario> ptrs = new ArrayList<Prontuario>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			ptrs = em.createQuery("FROM Prontuario ptr WHERE ptr.pp = :id",Prontuario.class).setParameter(":id", id).getResultList();
		} finally {
			if(em!=null)
				em.close();
		}
		return ptrs;
	}
	
	public List<Prontuario> buscarPtrPorPct(Long id){
		List<Prontuario> ptrs = new ArrayList<Prontuario>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			ptrs = em.createQuery("FROM Prontuario ptr WHERE ptr.paciente = :id",Prontuario.class).setParameter(":id", id).getResultList();
		} finally {
			if(em!=null)
				em.close();
		}
		return ptrs;
	}
	
	public Prontuario buscarPtrPorPPePct(Long idPP, Long idPct){
		Prontuario ptr = new Prontuario();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			ptr = em.createQuery("FROM Prontuario ptr WHERE ptr.pp = :idPP AND ptr.paciente = :idPct",Prontuario.class).setParameter(":idPP", idPP).setParameter(":idPct", idPct).getSingleResult();
		} finally {
			if(em!=null)
				em.close();
		}
		return ptr;
	}
	
	public void inserirPtr(Prontuario ptr) {
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			em.getTransaction().begin();
			em.persist(ptr);
			em.getTransaction().commit();
		} finally {
			if(em!=null)
				em.close();
		}
	}
}
