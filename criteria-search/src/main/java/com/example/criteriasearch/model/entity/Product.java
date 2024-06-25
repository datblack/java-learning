package com.example.criteriasearch.model.entity;

import com.example.criteriasearch.model.BaseStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @Generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    Integer price;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    Category category;

    @Enumerated(EnumType.STRING)
    BaseStatus status;
}
