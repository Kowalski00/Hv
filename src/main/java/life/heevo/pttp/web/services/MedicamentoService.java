package life.heevo.pttp.web.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import life.heevo.pttp.web.entities.Medicamento;
import life.heevo.pttp.web.utils.JpaUtils;

public class MedicamentoService {

	public List<Medicamento> listarTodosMdc(){
		List<Medicamento> mdcs = new ArrayList<Medicamento>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			mdcs = em.createQuery("FROM Medicamento",Medicamento.class).getResultList();
		} finally {
			if(em!=null)
				em.close();
		}
		return mdcs;
	}
	
	public List<Medicamento> buscarMdcPorPrcc(Long id){
		List<Medicamento> mdcs = new ArrayList<Medicamento>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			mdcs = em.createQuery("FROM Medicamento mdc WHERE mdc.prescricao = :id",Medicamento.class).setParameter(":id", id).getResultList();
		} finally {
			if(em!=null)
				em.close();
		}
		return mdcs;
	}
	
	public void inserirMdc(Medicamento mdc) {
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			em.getTransaction().begin();
			em.persist(mdc);
			em.getTransaction().commit();
		} finally {
			if(em!=null)
				em.close();
		}
	}
}
