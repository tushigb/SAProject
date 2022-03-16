package edu.miu.product.serviceImpl;

import edu.miu.product.dto.request.ProductDTO;
import edu.miu.product.dto.response.StockResponseDTO;
import edu.miu.product.entity.Product;
import edu.miu.product.exception.BusinessException;
import edu.miu.product.repository.ProductRepository;
import edu.miu.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CustomerServiceImpl
 *
 * @author Tushig Battumur
 **/

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    public Product add(ProductDTO productDTO) {
        Product product = new Product();
        product.fill(productDTO);
        repository.save(product);
        return product;
    }

    public void remove(String productNumber) {
        repository.deleteById(productNumber);
    }

    public Product get(String productNumber) throws BusinessException {
        return repository.findById(productNumber).orElseThrow(() -> new BusinessException("Product not found"));
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product update(String productNumber, ProductDTO productDTO) throws BusinessException {
        Product product = get(productNumber);
        product.fill(productDTO);
        repository.save(product);
        return product;
    }

    public StockResponseDTO check(String productNumber, int quantity) throws BusinessException {
        return new StockResponseDTO(get(productNumber).getStock() >= quantity);
    }

    public void decreaseStock(String productNumber, int quantity) throws BusinessException {
        Product product = get(productNumber);
        product.setStock(product.getStock() - quantity);
        repository.save(product);
    }

}
