package com.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//@Transactional
        PlatformTransactionManager platformTransactionManager;
        TransactionDefinition transactionDefinition;
        DispatcherServlet dispatcherServlet;
        ContextLoaderListener contextLoaderListener;
    }

}
