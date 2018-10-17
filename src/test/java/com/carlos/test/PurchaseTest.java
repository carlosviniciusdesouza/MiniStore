package com.carlos.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import javax.transaction.Transactional;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.carlos.entity.Customer;
import com.carlos.entity.Employee;
import com.carlos.entity.Product;
import com.carlos.entity.Purchase;
import com.carlos.entity.PurchaseProduct;
import com.carlos.repository.CustomerRepository;
import com.carlos.repository.EmployeeRepository;
import com.carlos.repository.ProductRepository;
import com.carlos.repository.PurchaseRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:test/spring-context.xml",
		"classpath*:test/spring-security.xml"})
@Rollback
@Transactional
public class PurchaseTest extends AbstractDatabaseTest{

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	private Customer george;
	private Employee memphis;
	private Product bicycle;
	private Product tricycle;
	private Product quadcycle;
	
	//TODO Test Service
	
	@BeforeClass
	public void setup() {
		george = customerRepository.save(new Customer("George", "Lucas", "gmail@george.com"));
		memphis = employeeRepository.save(new Employee("Henrison", "Ford", "yahoo@ford.com", 20000d));
		bicycle = productRepository.save(new Product("Bicycle",25d, 2));
		tricycle = productRepository.save(new Product("Tricycle", 40d, 3));
		quadcycle = productRepository.save(new Product("quadcycle", 50d, 3));
	}

	@Test
	public void connectionDatabaseTest() { //TODO change name
		
		
		Purchase purchase = new Purchase();
		purchase.setCustomerId(george.getId());
		purchase.setEmployeeId(memphis.getId());
		purchase.setPaymentType("Credit Card");
		
		PurchaseProduct bicyclePurchase = new PurchaseProduct(purchase, bicycle, 1);
		PurchaseProduct tricyclePurchase = new PurchaseProduct(purchase, tricycle, 1);
		PurchaseProduct quadcyclePurchase = new PurchaseProduct(purchase, quadcycle, 1);
		
		purchase.setPurchaseProduct(Arrays.asList(bicyclePurchase, tricyclePurchase, quadcyclePurchase));
		purchaseRepository.save(purchase);
		
		Purchase found = purchaseRepository.findByCustomerIdAndEmployeeId(george.getId(), memphis.getId());
		
		assertEquals(found.getPurchaseProduct().size(), 3);
	}

}
