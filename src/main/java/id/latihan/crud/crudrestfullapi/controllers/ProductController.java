package id.latihan.crud.crudrestfullapi.controllers;

import id.latihan.crud.crudrestfullapi.dto.ResponseDataDTO;
import id.latihan.crud.crudrestfullapi.entities.Product;
import id.latihan.crud.crudrestfullapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public Iterable<Product> getAllProducts(@RequestParam(required = false, defaultValue = "") String name)
    {
        if(name == null)
        {
            return productService.getAllProducts();
        }
        return productService.findByName(name);
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable("id") Long id)
    {
        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseEntity<ResponseDataDTO<Product>> create(@Valid @RequestBody Product product, Errors errors)
    {
        ResponseDataDTO response = new ResponseDataDTO();
        if(errors.hasErrors())
        {
            for (ObjectError error: errors.getAllErrors()) {
                response.getMessage().add(error.getDefaultMessage());
            }
            response.setStatus(false);
            response.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        response.setStatus(true);
        response.getMessage().add("Data has been saved.");
        response.setPayload(productService.save(product));
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<ResponseDataDTO<Product>> update(@Valid @RequestBody Product product, Errors errors)
    {
        ResponseDataDTO response = new ResponseDataDTO();
        if(errors.hasErrors())
        {
            for (ObjectError error: errors.getAllErrors()) {
                response.getMessage().add(error.getDefaultMessage());
            }
            response.setStatus(false);
            response.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        response.setStatus(true);
        response.getMessage().add("Data has been saved.");
        response.setPayload(productService.save(product));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Long id)
    {
        productService.delete(id);
    }

}
