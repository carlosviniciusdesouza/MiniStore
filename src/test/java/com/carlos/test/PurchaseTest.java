package com.carlos.test;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.carlos.entity.Purchase;
import com.carlos.repository.PurchaseRepository;
import com.carlos.service.PurchaseServiceImpl;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

@RunWith(MockitoJUnitRunner.class)
public class PurchaseTest {

	@InjectMocks
	private PurchaseServiceImpl purchaseService;

	@Mock
	private PurchaseRepository purchaseRepository;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void connectionDatabaseTest() {

		Purchase Purchase1 = new Purchase();
		Purchase Purchase2 = new Purchase();
		Purchase Purchase3 = new Purchase();

		purchaseRepository.save(Purchase1);
		purchaseRepository.save(Purchase2);
		purchaseRepository.save(Purchase3);

		when(purchaseRepository.count()).thenReturn(5l);
		assertEquals(5l, purchaseService.countPurchaseTotal());
	}

}
