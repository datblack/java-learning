package com.example.criteriasearch.service;

import com.example.criteriasearch.model.entity.Product;
import com.example.criteriasearch.model.request.GetProductRequest;

public interface ProductService {
    Product get(GetProductRequest getProductRequest);
}
