package com.carlos.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.BeforeClass;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.core.H2Database;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;

/**
 * @author Carlos
 *
 * Before every test that may inlude a setup connection with a database, the test class must extend this Abstract Class
 */
public abstract class AbstractDatabaseTest {
	
	private static final String JBDC_DRIVER = "org.h2.Driver";
	private static final String CHANGE_LOG = "WEB-INF/classes/liquibase/dbChangelog-master.xml";
    private static final String CONNECTION_STRING = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;INIT=CREATE SCHEMA IF NOT EXISTS ministore\\;SET SCHEMA ministore;DATABASE_TO_UPPER=false";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    
    private static Connection holdingConnection;
    private static Liquibase liquibase;
    private static Database database;
    
    private static boolean isDatabaseUpdated = false;

	/**
	 * Setup made with Liquibase
	 */
    @BeforeClass
	public static void runLiquibase() {
        if(!isDatabaseUpdated)try {
        	ResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor();
        	Class.forName(JBDC_DRIVER);
        	holdingConnection = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
        	database = new H2Database();
        	database.setConnection(new JdbcConnection(holdingConnection));
            liquibase = new Liquibase(CHANGE_LOG, resourceAccessor, database);
            liquibase.update("test");
            database.close();
            isDatabaseUpdated = true;
        } catch (Exception ex) {
            throw new RuntimeException("Error during database initialization", ex);
        }
	}
}
