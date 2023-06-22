package com.thiagodd.godelivery.infrastructure.repository;

import com.thiagodd.godelivery.domain.model.Restaurant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class RestaurantRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Restaurant> findByName3(String name, BigDecimal startingFee, BigDecimal endingFee) {
        var jpql = "from Restaurant where name like :name and deliveryFee between :startingFee and :endingFee";
        return entityManager.createQuery(jpql, Restaurant.class)
                .setParameter("name", "%" + name + "%")
                .setParameter("startingFee", startingFee)
                .setParameter("endingFee", endingFee)
                .getResultList();
    }

    public List<Restaurant> findByName4(String name, BigDecimal startingFee, BigDecimal endingFee) {
        var jpql = new StringBuilder();
        jpql.append("from Restaurant where 0 = 0 ");

        var parameters = new HashMap<String, Object>();

        if (StringUtils.hasLength(name)) {
            jpql.append("and name like :name ");
            parameters.put("name", "%" + name + "%");
        }
        if (startingFee != null) {
            jpql.append("and deliveryFee >= :startingFee ");
            parameters.put("startingFee", startingFee);
        }
        if (endingFee != null) {
            jpql.append("and deliveryFee <= :endingFee ");
            parameters.put("endingFee", endingFee);
        }


        TypedQuery<Restaurant> query = entityManager.createQuery(jpql.toString(), Restaurant.class);

        parameters.forEach(query::setParameter);

        return query.getResultList();
    }

    public List<Restaurant> findByName5(String name, BigDecimal startingFee, BigDecimal endingFee) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Restaurant> criteriaQuery = criteriaBuilder.createQuery(Restaurant.class);
        Root<Restaurant> restaurantRoot = criteriaQuery.from(Restaurant.class);

        var predicates = new ArrayList<Predicate>();
        if (StringUtils.hasText(name)) {
            Predicate predicateName = criteriaBuilder.like(restaurantRoot.get("name"), "%" + name + "%");
            predicates.add(predicateName);
        }

        if (startingFee != null) {
            Predicate predicateStartingFee = criteriaBuilder.greaterThanOrEqualTo(restaurantRoot.get("deliveryFee"), startingFee);
            predicates.add(predicateStartingFee);
        }

        if (endingFee != null) {
            Predicate predicateEndingFee = criteriaBuilder.lessThanOrEqualTo(restaurantRoot.get("deliveryFee"), endingFee);
            predicates.add(predicateEndingFee);
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Restaurant> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
