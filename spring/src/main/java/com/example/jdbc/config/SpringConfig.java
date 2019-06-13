package com.example.jdbc.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**指定该类是一个配置类、等价于一个spring的配置文件*/
@Configuration
/**指定扫包范围*/
@ComponentScan(basePackages="com.example.jdbc")
/**引入JdbcConfig.class文件*/
@Import(JdbcConfig.class)
public class SpringConfig {
}