
package com.sinfolix.Sai_Samartha.Repository;

import com.sinfolix.Sai_Samartha.Entities.ProductCatalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCatalogueRepo extends JpaRepository<ProductCatalogue,Integer> {


    @Query("SELECT p FROM ProductCatalogue p WHERE p.category = :category")
    List<ProductCatalogue> findByCategory(@Param("category") String category);
}
