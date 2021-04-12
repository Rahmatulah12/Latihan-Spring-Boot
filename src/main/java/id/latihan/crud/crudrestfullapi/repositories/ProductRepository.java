package id.latihan.crud.crudrestfullapi.repositories;

import id.latihan.crud.crudrestfullapi.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByNameContains(String name);
}
