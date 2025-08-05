package com.web.expensetracker.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code; // e.g., "INR", "USD"
    private String name; // e.g., "Indian Rupee"
    private String symbol; // e.g., "₹", "$"
}
