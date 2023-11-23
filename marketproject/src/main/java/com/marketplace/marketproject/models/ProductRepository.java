package com.marketplace.marketproject.models;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByTitle(String Title);
    Optional<Product> findByAuthor(String Author);
}
