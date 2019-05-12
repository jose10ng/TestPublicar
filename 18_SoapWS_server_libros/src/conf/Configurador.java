package conf;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages="modelo.dao,modelo.service")
public class Configurador {

	@Bean
	public DataSource ds() {
		JndiDataSourceLookup jdsl=new JndiDataSourceLookup();
		return jdsl.getDataSource("jdbc/librosds");
	}

	@Bean
	public HibernateJpaVendorAdapter adaptador() {
		HibernateJpaVendorAdapter hjva=new HibernateJpaVendorAdapter();
		hjva.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return hjva;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean factory() {
		LocalContainerEntityManagerFactoryBean lcemfb=new LocalContainerEntityManagerFactoryBean();
		lcemfb.setDataSource(ds());
		lcemfb.setPersistenceUnitName("librosName");
		lcemfb.setJpaVendorAdapter(adaptador());
		lcemfb.setPackagesToScan("entidades");
		return lcemfb;
	}

	@Bean
	public JpaTransactionManager transaction() {
		 return new JpaTransactionManager(factory().getNativeEntityManagerFactory());
	}
}
