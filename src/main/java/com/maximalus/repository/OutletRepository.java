package com.maximalus.repository;

import com.maximalus.model.Order;
import com.maximalus.model.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OutletRepository extends JpaRepository<Outlet, Long> {
    @Transactional(readOnly = true)
//    @Query("select orderList from Outlet outlet join fetch outlet.orderList orderList where outlet.id=:id")
//    List<Order> getAllOrdersByIdOfOutlet(long id);
    List<Order> getAllById(Long id);
}
