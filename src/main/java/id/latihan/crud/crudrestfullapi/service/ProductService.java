package id.latihan.crud.crudrestfullapi.service;

import id.latihan.crud.crudrestfullapi.entities.Product;
import id.latihan.crud.crudrestfullapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> findByName(String name)
    {
        return productRepository.findByNameContains(name);
    }

    public Product getProductById(Long id)
    {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent())
        {
            return null;
        }
        return product.get();
    }

    public Product save(Product product)
    {
        return productRepository.save(product);
    }

    public void delete(Long id)
    {
        productRepository.deleteById(id);
    }

}
