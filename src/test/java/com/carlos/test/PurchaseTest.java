package com.carlos.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.carlos.entity.Purchase;
import com.carlos.repository.PurchaseRepository;
import com.carlos.service.PurchaseServiceImpl;

@RunWith(MockitoJUnitRunner.class) 
public class PurchaseTest extends AbstractDatabaseTest{

	@InjectMocks
	private PurchaseServiceImpl purchaseService;

	@Mock
	private PurchaseRepository purchaseRepository;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	//TODO create tests on production too, H2.

	@Test
	public void connectionDatabaseTest() {

		Purchase Purchase1 = new Purchase();
		Purchase Purchase2 = new Purchase();
		Purchase Purchase3 = new Purchase();

		purchaseRepository.save(Purchase1);
		purchaseRepository.save(Purchase2);
		purchaseRepository.save(Purchase3);

		when(purchaseRepository.count()).thenReturn(3l);
		assertEquals(3l, purchaseService.countPurchaseTotal());
	}

}
