package com.example.coinbackoffice.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.coinbackoffice")
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${mongo.host}")
    private String mongoHost;

    @Override
    protected String getDatabaseName() {
        return "pagacoin";
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(mongoHost, 27017);
    }
}