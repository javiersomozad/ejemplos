package es.anaya.spring.data.s03.jpamultisource.h2source;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(
  entityManagerFactoryRef = "h2EntityManagerFactory", 
  transactionManagerRef = "h2TransactionManager", 
  basePackages = {"es.anaya.spring.data.s03.jpamultisource.h2source" })
public class H2DbConfig {
 @Autowired
 private Environment env;

 @Bean(name = "h2DataSource")
 public DataSource dataSource() {
  DriverManagerDataSource dataSource = new DriverManagerDataSource();
  dataSource.setDriverClassName(env.getProperty("source2.datasource.driverClassName"));
  dataSource.setUrl(env.getProperty("source2.datasource.url"));
  dataSource.setUsername(env.getProperty("source2.datasource.username"));
  dataSource.setPassword(env.getProperty("source2.datasource.password"));

  return dataSource;
 }

 @Bean(name = "h2EntityManagerFactory")
 public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory(EntityManagerFactoryBuilder builder,
   @Qualifier("h2DataSource") DataSource dataSource) {

     HashMap<String, Object> properties = new HashMap<>();
     properties.put("hibernate.hbm2ddl.auto","create-drop");
     
     LocalContainerEntityManagerFactoryBean em = 
       builder.dataSource(dataSource)
       .packages("es.anaya.spring.data.s03.jpamultisource.h2source")
       .build(); 
     em.setJpaPropertyMap(properties);
     
     return em;
 }

 @Bean(name = "h2TransactionManager")
 public PlatformTransactionManager h2TransactionManager(
   @Qualifier("h2EntityManagerFactory") EntityManagerFactory h2EntityManagerFactory) {
  return new JpaTransactionManager(h2EntityManagerFactory);
 }
}
