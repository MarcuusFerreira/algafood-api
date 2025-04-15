package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepositoryQueries;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> find(String nome, BigDecimal taxaFreteMinima, BigDecimal taxaFreteMaxima) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
        Root<Restaurante> root = criteria.from(Restaurante.class);
        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.hasText(nome)) {
            predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
        }
        if (taxaFreteMinima != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFreteMinima"), taxaFreteMinima));
        }
        if (taxaFreteMaxima != null) {  
            predicates.add(builder.lessThanOrEqualTo(root.get("taxaFreteMaxima"), taxaFreteMaxima));
        }
        criteria.where(predicates.toArray(new Predicate[0]));
        return manager.createQuery(criteria)
                .getResultList();
    }

/*
    @Override
    public List<Restaurante> find(String nome, BigDecimal taxaFreteMinima, BigDecimal taxaFreteMaxima) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("from Restaurante where 0 = 0 ");

        var parametros = new HashMap<String, Object>();

        if (StringUtils.hasLength(nome)) {
            jpql.append("and lower(nome) like lower(:nome) ");
            parametros.put("nome", "%" + nome + "%");
        }

        if(taxaFreteMinima != null) {
            jpql.append(" and taxaFrete >= :taxaFreteMinima ");
            parametros.put("taxaFreteMinima", taxaFreteMinima);
        }

        if(taxaFreteMaxima != null) {
            jpql.append("and taxaFrete <= :taxaFreteMaxima ");
            parametros.put("taxaFreteMaxima", taxaFreteMaxima);
        }

        TypedQuery<Restaurante> query = manager.createQuery(jpql.toString(), Restaurante.class);
        parametros.forEach(query::setParameter);
        return query.getResultList();
    }

    @Override
    public List<Restaurante> find(String nome, BigDecimal taxaFreteMinima, BigDecimal taxaFreteMaxima) {
        var jpql = "from Restaurante where nome like :nome and taxaFrete between :taxaFreteMinima and :taxaFreteMaxima";
        return manager.createQuery(jpql, Restaurante.class)
                .setParameter("nome", "%" + nome + "%")
                .setParameter("taxaFreteMinima", taxaFreteMinima)
                .setParameter("taxaFreteMaxima", taxaFreteMaxima)
                .getResultList();
    }
*/

}
