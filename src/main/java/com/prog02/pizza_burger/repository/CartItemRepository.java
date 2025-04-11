package com.prog02.pizza_burger.repository;

import com.prog02.pizza_burger.model.order.CartItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM CartItem")
    void clearCart();

    @Query("SELECT c FROM CartItem c")
    List<CartItem> findAllCartItems();
    // You can add custom query methods here if needed (e.g., findByItemType, etc.)

}