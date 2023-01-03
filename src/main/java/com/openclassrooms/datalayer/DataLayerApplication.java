package com.openclassrooms.datalayer;

import com.openclassrooms.datalayer.model.Category;
import com.openclassrooms.datalayer.model.Comment;
import com.openclassrooms.datalayer.model.Product;
import com.openclassrooms.datalayer.service.CategoryService;
import com.openclassrooms.datalayer.service.CommentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.openclassrooms.datalayer.service.ProductService;

import java.util.Optional;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private CategoryService categoryService;

	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		/*Iterable<Product> products = productService.getProducts();
		products.forEach(product -> System.out.println(product.getName()));
		System.out.println();*/

		/*Iterable<Comment> comments = commentService.getComments();
		comments.forEach((comment -> System.out.println(comment.getContent())));
		System.out.println();*/

		/*Iterable<Category> categories = categoryService.getCategories();
		categories.forEach(category -> System.out.println(category.getName()));
		System.out.println();*/

		// OneToMany
		Optional<Product> optProduct = productService.getProductById(1);
		Product productId1 = optProduct.get();
		System.out.println(productId1.getName());

		// Affichage des commenataires du produit
		productId1.getComments().forEach(
				comment -> System.out.println(comment.getContent()));
		System.out.println();

		// ManyToMany
		Optional<Category> optCategory = categoryService.getCategoryById(1);
		Category categoryId1 = optCategory.get();

		System.out.println(categoryId1.getName());

		categoryId1.getProducts().forEach(
				product -> System.out.println(product.getName()));
		System.out.println();

		// ManyToMany Bi-directionnel
		Optional<Product> optionalProduct = productService.getProductById(1);
		Product product1 = optionalProduct.get();
		System.out.println(product1.getName());
		product1.getCategories().forEach(
				category -> System.out.println(category.getName())
		);
	}

}
