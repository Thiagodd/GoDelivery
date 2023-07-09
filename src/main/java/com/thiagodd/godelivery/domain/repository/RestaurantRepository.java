package com.thiagodd.godelivery.domain.repository;

import com.thiagodd.godelivery.domain.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

 //    @Query("from Restaurant where name like %:name% and cookery.id = :id")
 List<Restaurant> buscarPorNome(String name, @Param("id") Long id);

 List<Restaurant> findByDeliveryFeeBetween(BigDecimal startingFee, BigDecimal endingFee);

 List<Restaurant> findByNameContainingAndCookeryId(String name, Long id);

 Optional<Restaurant> findFirstByNameContaining(String name);

 List<Restaurant> findTop2ByNameContaining(String name);

 int countByCookeryId(Long id);

 List<Restaurant> findByName3(String name, BigDecimal startingFee, BigDecimal endingFee);

 List<Restaurant> findByName4(String name, BigDecimal startingFee, BigDecimal endingFee);

 List<Restaurant> findByName5(String name, BigDecimal startingFee, BigDecimal endingFee);
}
