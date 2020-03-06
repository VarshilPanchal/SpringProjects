package com.spring.data.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class AppController {

	@Autowired
	private ProducatService service;
//	Product product;

	@GetMapping("/list")
	public String viewHomePage(Model model) {
		List<Product> listProducts = service.listAllProduct();
		model.addAttribute("listProducts", listProducts);
		return "index";
	}

	//Add new Product
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	}
	
	//Save Product
	@PostMapping(value = "/save")
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.saveProduct(product);
		return "redirect:/list";
	}
	
	//Get by id
	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable("id") Long id){
		Product entity = service.getProduct(id);
		return new ResponseEntity<Product>( entity, new HttpHeaders(), HttpStatus.OK);
	}

	//Edit product
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable (name="id")Long id) {
		ModelAndView modelAndView = new ModelAndView("edit_product");
		Product product = service.getProduct(id);
		modelAndView.addObject("product",product);
		return modelAndView;
	}

	//Delete product 
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable( name="id" ) Long id) {
		service.deleteProduct(id);
		return "redirect:/list";
		
	}
	
//	@DeleteMapping("/delete/{id}")
//	public String deleteUser(@PathVariable Long id) {
//		service.delete(id);
//		return "redirect:/list";
//	}
	
}
