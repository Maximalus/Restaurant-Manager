package com.maximalus.model.product.item;

import com.maximalus.model.Order;
import com.maximalus.model.discount.ItemDiscount;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_generator")
    @SequenceGenerator(allocationSize = 1, name = "order_item_generator")
    private Long id;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    private MenuItem menuItem;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(nullable = false)
    private int orderedAmount;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    private ItemDiscount itemDiscount;

    @ManyToOne
    @JoinColumn(name = "item_type")
    private ItemType itemType;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalCost;

    @Column(nullable = false)
    private boolean isDeleted;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private LocalDateTime changingDate;
}
