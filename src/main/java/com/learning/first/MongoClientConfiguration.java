package com.learning.first;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;


@Configuration
@EnableMongoRepositories(basePackages = "com.learning.first.repository")
public class MongoClientConfiguration extends AbstractMongoClientConfiguration{
    @Override
    protected String getDatabaseName() {
        return "school";
    }

    // @Override
    protected String getMappingBasePackage() {
        return "com.learning.first.model";
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://mukul:mukul@cluster0.vbpqwhj.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0");
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}