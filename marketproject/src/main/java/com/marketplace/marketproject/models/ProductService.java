package com.marketplace.marketproject.models;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private static ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public static Product createProduct(Product product) {
        return productRepository.save(product);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    public static Optional<Product> getProductByTitle(String title) {return productRepository.findByTitle(title);}
    public static Optional<Product> getProductByAuthor(String author) {
        return productRepository.findByAuthor(author);
    }
    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product existingProduct = product.get();
            existingProduct.setTitle(productDetails.getTitle());
            existingProduct.setDescription(productDetails.getDescription());
            existingProduct.setPrice(productDetails.getPrice());
            return productRepository.save(existingProduct);
        }
        return null;
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
