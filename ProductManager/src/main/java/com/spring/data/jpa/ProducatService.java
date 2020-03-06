package com.spring.data.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class ProducatService {

	@Autowired
	private ProductRepository repo;

//	public List<Product> listAll() {
//		return (List<Product>) repo.findAll();
//	}

	public void saveProduct(Product product) {
		repo.save(product);
	}

	public Product getProduct(long id) {
		return repo.findById(id).get();
	}

	public void deleteProduct(long id) {
		repo.deleteById(id);
	}
//
//	public void createProduct(Product product) {
//		repo.save(product);
//	}
	public List<Product> listAllProduct() {
        return repo.findAll();
    }
}