package edu.miu.product.service;

import edu.miu.product.dto.request.ProductDTO;
import edu.miu.product.dto.response.StockResponseDTO;
import edu.miu.product.entity.Product;
import edu.miu.product.exception.BusinessException;

import java.util.List;

/**
 * CustomerService
 *
 * @author Tushig Battumur
 **/

public interface ProductService {

    Product add(ProductDTO productDTO);

    void remove(String productNumber);

    Product get(String productNumber) throws BusinessException;

    List<Product> getAll();

    Product update(String productNumber, ProductDTO productDTO) throws BusinessException;

    StockResponseDTO check(String productNumber, int quantity) throws BusinessException;

    void decreaseStock(String productNumber, int quantity) throws BusinessException;

}
