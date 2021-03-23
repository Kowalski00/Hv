package life.heevo.pttp.web.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import life.heevo.pttp.web.entities.PP;
import life.heevo.pttp.web.utils.JpaUtils;

public class PPService {

	public List<PP> listarTodosPPs(){
		List<PP> pps = new ArrayList<PP>();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			pps = em.createQuery("from PP",PP.class).getResultList();
		} finally {
			if(em!=null)
				em.close();
		}
		return pps;
	}
	public PP buscarPorId(Long id) {
		PP pp = new PP();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			pp = em.find(PP.class, id);
		} finally {
			if(em!=null)
				em.close();
		}
		return pp;
	}
	public void inserirPP(PP pp) {
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			em.getTransaction().begin();
			em.persist(pp);
			em.getTransaction().commit();
		} finally {
			if(em!=null)
				em.close();
		}
	}
	public List<PP> pesquisarPorNomePP(String nome){
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			List<PP> result = em.createQuery("from PP p where lower(p.nome) LIKE lower(concat('%',:nome,'%'))",PP.class).setParameter("nome", nome).getResultList();
			return result;
		} finally {
			if(em!=null)
				em.close();
		}
	}
	public PP pesquisarPpPorCpf(String cpf){
		PP pp = new PP();
		EntityManager em = null;
		try {
			em = JpaUtils.getEntityManager();
			pp = em.createQuery("from PP p where lower(p.cpf) LIKE lower(concat('%',:cpf,'%'))",PP.class).setParameter("cpf", cpf).getSingleResult();
			return pp;
		} finally {
			if(em!=null)
				em.close();
		}
	}
}
