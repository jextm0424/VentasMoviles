package com.jextm.ventasMoviles.configuration;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.jextm.ventasMoviles")
@EnableTransactionManagement
public class JpaConfig implements DisposableBean{
	 private static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	   	//private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://localhost:3306/ventasmoviles";
	 	private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://mysql26827-env-6491622.jl.serv.net.mx/ventasmoviles";
	    private static final String PROPERTY_NAME_DATABASE_USERNAME = "JEXTM";
	    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "jextm";
	    		
	    
	    @Bean(name="driverDatasource")
	    public DataSource driverDataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER);
	        dataSource.setUrl(PROPERTY_NAME_DATABASE_URL);
	        dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
	        dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);
	        return dataSource;
	    }
	   
	    
	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
	      
		    LocalContainerEntityManagerFactoryBean lcemfb
	            = new LocalContainerEntityManagerFactoryBean();
		   
	        lcemfb.setDataSource(this.driverDataSource());
	        
	        lcemfb.setPackagesToScan(new String[] {"com.jextm.ventasMoviles"});
			lcemfb.setPersistenceUnitName("MyPU");
	      
	        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
			lcemfb.setJpaVendorAdapter(va);
			
			Properties ps = new Properties();
			
			ps.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			//ps.put("hibernate.hbm2ddl.auto", "create-drop");
			
			ps.put("hibernate.show_sql", "true");
			lcemfb.setJpaProperties(ps);
			
			lcemfb.afterPropertiesSet();

	        return lcemfb;
			
	    }
	   
	    @Bean
	    public PlatformTransactionManager transactionManager(){
		   
	        JpaTransactionManager tm = new JpaTransactionManager();
	      
		    tm.setEntityManagerFactory(
	            this.entityManagerFactory().getObject() );
	      
	        return tm;
			
	    }
	   
	    @Bean
	    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	        return new PersistenceExceptionTranslationPostProcessor();
	    }
	    
	    @Override
	    public void destroy() {

	    }
	    
}
