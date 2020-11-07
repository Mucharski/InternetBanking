package igormucharski.banking.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import igormucharski.banking.controller.AdmController;
import igormucharski.banking.view.TelaAdministrador;

public abstract class GenericDAO<T> implements DAO<T> {

	AdmController controller = new AdmController();
	TelaAdministrador view = new TelaAdministrador();
	private Class<T> persistedClass;
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	protected GenericDAO() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		persistedClass = (Class<T>) pt.getActualTypeArguments()[0];
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MucharskiBanking");
		entityManager = emf.createEntityManager();
	}

	public T salvarCliente(T entidade) {
		try {
			EntityTransaction t = entityManager.getTransaction();
			t.begin();
			entityManager.persist(entidade);
			entityManager.flush();
			t.commit();
		} catch (PersistenceException e) {
			System.out.println("O CPF informado já está cadastrado. Tente novamente");
			controller.criarCliente();
		}
		System.out.println("Cadastro realizado com sucesso!\n");
		view.menuAdministracao();
		return entidade;
	}

	public T atualizarCliente(T entidade) {
		EntityTransaction t = entityManager.getTransaction();
		t.begin();
		entityManager.merge(entidade);
		entityManager.flush();
		t.commit();
		return entidade;
	}

	public List<T> listarCliente(T entidade) {
		String query = "select l from " + persistedClass.getName() + " l";
		return entityManager.createQuery(query, persistedClass).getResultList();
	}

	public T buscarPorId(String CPF) {
		return entityManager.find(persistedClass, CPF);
	}

	public void apagar(String CPF) {
		T entidade = buscarPorId(CPF);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		T mergedEntity = entityManager.merge(entidade);
		entityManager.remove(mergedEntity);
		entityManager.flush();
		tx.commit();
	}

}
