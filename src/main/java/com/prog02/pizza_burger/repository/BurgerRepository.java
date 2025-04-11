package com.prog02.pizza_burger.repository;

import com.prog02.pizza_burger.model.burger.Burger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BurgerRepository extends JpaRepository<Burger, Long> {

}