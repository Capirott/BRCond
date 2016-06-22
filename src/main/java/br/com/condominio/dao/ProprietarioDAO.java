package br.com.condominio.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.condominio.model.Entidade;
import br.com.condominio.model.Proprietario;

public class ProprietarioDAO extends GenericDao{

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<Proprietario> listarPorNome(String nome) {
		Session session = this.getManager().unwrap(Session.class);
		Criteria criteria = session.createCriteria(Entidade.class);
		if (!nome.isEmpty()){
			criteria.add(Restrictions.ilike("pr_nome", nome.toUpperCase(), MatchMode.ANYWHERE));
		}
		return criteria.list();
	}
}
