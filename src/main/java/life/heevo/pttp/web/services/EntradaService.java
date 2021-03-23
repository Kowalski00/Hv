package life.heevo.pttp.web.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import life.heevo.pttp.web.entities.Entrada;
import life.heevo.pttp.web.utils.JpaUtils;

public class EntradaService {

	public List<Entrada> listarTodasEtrs(){
		List<Entrada> etrs = new ArrayList<Entrada>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			etrs = em.createQuery("FROM Entrada",Entrada.class).getResultList();
		} finally {
			if(em!=null)
				em.close();
		}
		return etrs;
	}
	
	public List<Entrada> buscarEtrsPorPtr(Long id){
		List<Entrada> etrs = new ArrayList<Entrada>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			etrs = em.createQuery("FROM Entrada etr WHERE etr.prontuario = :id",Entrada.class).setParameter(":id", id).getResultList();
		} finally {
			if(em!=null)
				em.close();
		}
		return etrs;
	}
	
	public void inserirEtr(Entrada etr) {
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			em.getTransaction().begin();
			em.persist(etr);
			em.getTransaction().commit();
		} finally {
			if(em!=null)
				em.close();
		}
	}
}
