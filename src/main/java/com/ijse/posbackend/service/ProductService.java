package com.ijse.posbackend.service;

import com.ijse.posbackend.dto.ProductDTO;
import com.ijse.posbackend.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(ProductDTO productDTO);

    Product updateProduct(Long id, Product product);
}
