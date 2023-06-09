package com.national.guarantee.guarantee.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.national.guarantee.guarantee.entities.Branch;
import com.national.guarantee.guarantee.entities.Order;
import com.national.guarantee.guarantee.entities.OrderItem;
import com.national.guarantee.guarantee.entities.Payment;
import com.national.guarantee.guarantee.entities.Product;
import com.national.guarantee.guarantee.entities.Supplier;
import com.national.guarantee.guarantee.entities.User;
import com.national.guarantee.guarantee.entities.enums.OrderStatus;
import com.national.guarantee.guarantee.repositories.BranchRepository;
import com.national.guarantee.guarantee.repositories.OrderItemRepository;
import com.national.guarantee.guarantee.repositories.OrderRepository;
import com.national.guarantee.guarantee.repositories.ProductRepository;
import com.national.guarantee.guarantee.repositories.SupplierRepository;
import com.national.guarantee.guarantee.repositories.UserRepository;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		

		Branch b1 = new Branch(null, 1, 123456, 5, new Date(), 123, "apresentou falha");
		Branch b2 = new Branch(null, 1, 123456, 5, new Date(), 345, "apresentou falha");
		Branch b3 = new Branch(null, 1, 123456, 5, new Date(), 678, "apresentou falha");
		
		Supplier sp1 = new Supplier(null, "code123", "fornecedor1", "fornecedor1@gmail.com");
		Supplier sp2 = new Supplier(null, "code123", "fornecedor2", "fornecedor2@gmail.com");
		Supplier sp3 = new Supplier(null, "code123", "fornecedor3", "fornecedor3@gmail.com");
			
		Product p1 = new Product(null, "bobina", "110225", 50.50);
		Product p2 = new Product(null, "item2", "110225", 50.50);
		Product p3 = new Product(null, "item3", "110225", 50.50);
		
		branchRepository.saveAll(Arrays.asList(b1, b2, b3));
		supplierRepository.saveAll(Arrays.asList(sp1, sp2, sp3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
	
		p1.getSuppliers().add(sp1);
		p2.getSuppliers().add(sp2);
		p3.getSuppliers().add(sp3);
		
		sp1.getBranchs().add(b1);
		sp2.getBranchs().add(b2);
		sp3.getBranchs().add(b3);
		
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		branchRepository.saveAll(Arrays.asList(b1, b2, b3));
		supplierRepository.saveAll(Arrays.asList(sp1, sp2, sp3));
		
		User u1 = new User(null, "empresa1", "1234567");
		User u2 = new User(null, "empresa2", "1234567");
		User u3 = new User(null, "empresa3", "1234567");
		User u4 = new User(null, "empresa4", "1234567");
		User u5 = new User(null, "empresa5", "1234567");	
		
		
		
		Order o1 = new Order(null, Instant.parse("2023-02-20T19:53:07Z"), OrderStatus.DELIVERED, u1);
		Order o2 = new Order(null, Instant.parse("2023-03-21T03:42:10Z"), OrderStatus.SHIPPED, u2);
		Order o3 = new Order(null, Instant.parse("2023-03-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u3);
		Order o4 = new Order(null, Instant.parse("2023-03-25T18:55:20Z"), OrderStatus.PAID, u4);
		Order o5 = new Order(null, Instant.parse("2023-02-25T18:55:20Z"), OrderStatus.CANCELED, u5);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPriceProduct());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPriceProduct());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPriceProduct());
		OrderItem oi4 = new OrderItem(o3, p2, 2, p2.getPriceProduct());
		OrderItem oi5 = new OrderItem(o3, p3, 2, p2.getPriceProduct());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4, oi5));
		
		Payment pay1 = new Payment(null, Instant.parse("2023-06-01T21:53:07Z"), o1);
		o1.setPayment(pay1);

		orderRepository.save(o1);
	}
	
}
