package life.heevo.pttp.web.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import life.heevo.pttp.web.entities.Prescricao;
import life.heevo.pttp.web.utils.JpaUtils;

public class PrescricaoService {

	public List<Prescricao> listarTodosPrccs(){
		List<Prescricao> prccs = new ArrayList<Prescricao>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			prccs = em.createQuery("FROM Prescricao",Prescricao.class).getResultList();
		} finally {
			if(em!=null)
				em.close();
		}
		return prccs;
	}
	
	public List<Prescricao> buscarPrccsPorPtr(Long id){
		List<Prescricao> prccs = new ArrayList<Prescricao>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			prccs = em.createQuery("FROM Prescricao prcc WHERE prcc.prontuario = :id",Prescricao.class).setParameter(":id", id).getResultList();
		} finally {
			if(em!=null)
				em.close();
		}
		return prccs;
	}
	
	public void inserirPrcc(Prescricao prcc) {
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			em.getTransaction().begin();
			em.persist(prcc);
			em.getTransaction().commit();
		} finally {
			if(em!=null)
				em.close();
		}
	}
}
