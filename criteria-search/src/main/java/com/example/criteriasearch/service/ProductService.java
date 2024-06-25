package com.example.criteriasearch.service;

import com.example.criteriasearch.model.entity.Product;
import com.example.criteriasearch.model.request.GetProductRequest;

import java.util.List;

public interface ProductService {
    List<Product> get(GetProductRequest getProductRequest);
}
