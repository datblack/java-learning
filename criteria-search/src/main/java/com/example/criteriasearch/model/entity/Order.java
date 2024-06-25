package com.example.criteriasearch.model.entity;

import com.example.criteriasearch.model.BaseStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "`order`")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @Generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String userName;
    String phoneNumber;
    String address;
    @Enumerated(EnumType.STRING)
    BaseStatus status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<OrderProduct> orderProducts = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;
}
