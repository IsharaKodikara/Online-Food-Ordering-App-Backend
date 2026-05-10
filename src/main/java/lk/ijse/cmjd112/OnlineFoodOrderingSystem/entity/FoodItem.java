package lk.ijse.cmjd112.OnlineFoodOrderingSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "food_items")
@Data
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private double price;

    private String status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
