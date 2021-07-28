package com.example.shoppinglist.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Long> {
}
