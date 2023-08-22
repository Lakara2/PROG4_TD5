package td.example.prog4.dbConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(
        basePackages = "td.example.prog4.employee.repository",
        entityManagerFactoryRef = "employeeEntityManager",
        transactionManagerRef = "employeeTransactionManager")
public class EmployeeDb {

    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource employeeDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean employeeEntityManager(){
        LocalContainerEntityManagerFactoryBean em =  new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(employeeDataSource());
        em.setPackagesToScan(new String[] { "td.example.prog4.employee.repository.entity"});

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter((vendorAdapter));

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }


    @Bean
    public PlatformTransactionManager employeeTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(employeeEntityManager().getObject());
        return transactionManager;
    }

}
