package com.example.criteriasearch.service.impl;

import com.example.criteriasearch.model.entity.Product;
import com.example.criteriasearch.model.request.GetProductRequest;
import com.example.criteriasearch.repository.ProductRepository;
import com.example.criteriasearch.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public Product get(GetProductRequest getProductRequest) {

        return null;
    }
}
