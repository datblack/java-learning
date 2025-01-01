package com.example.criteriasearch.service.impl;

import com.example.criteriasearch.model.entity.Product;
import com.example.criteriasearch.model.request.GetProductRequest;
import com.example.criteriasearch.repository.ProductRepository;
import com.example.criteriasearch.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> get(GetProductRequest getProductRequest) {
        Specification<Product> spec = Specification.where(null);
        productRepository.findAll(spec);
        return null;
    }

}
