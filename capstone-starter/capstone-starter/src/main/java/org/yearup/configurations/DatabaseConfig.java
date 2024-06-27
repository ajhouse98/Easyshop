package org.yearup.configurations;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig
{
    private BasicDataSource basicDataSource;

    @Bean
    public BasicDataSource dataSource()
    {
        return basicDataSource;
    }

    @Autowired
    public DatabaseConfig(@Value("${datasource.url}") String url,
                          @Value("${datasource.username}") String username,
                          @Value("${datasource.password}") String password)
    {
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
    }
}



//package org.yearup.configurations;
//
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.yearup.data.ProductDao;
//import org.yearup.data.mysql.MySqlProductDao;
//
//import javax.sql.DataSource;
//
//// data source is going to be injected ( beans )
//@Configuration
//public class DatabaseConfig
//{
//    private BasicDataSource basicDataSource;
//
//    @Bean
//    public BasicDataSource dataSource()
//    {
//        return basicDataSource;
//    }
//
//    @Bean
//    public ProductDao productDao(DataSource dataSource){
//        return new MySqlProductDao(dataSource);
//        // create an  instance of a class/ completed
//    }
//
//    @Autowired
//    public DatabaseConfig(@Value("${datasource.url}") String url,
//                          @Value("${datasource.username}") String username,
//                          @Value("${datasource.password}") String password)
//    {
//        basicDataSource = new BasicDataSource();
//        basicDataSource.setUrl(url);
//        basicDataSource.setUsername(username);
//        basicDataSource.setPassword(password);
//    }
//
//}