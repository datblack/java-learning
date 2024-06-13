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
public class OrderProduct {
    @Id
    @Generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long productId;
    Long orderId;
    @Enumerated(EnumType.STRING)
    BaseStatus status;
}
