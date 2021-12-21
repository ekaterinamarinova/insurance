package com.online.insurance.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfiguration extends MongoAutoConfiguration {

    @Override
    public MongoClient mongo(ObjectProvider<MongoClientSettingsBuilderCustomizer> builderCustomizers, MongoClientSettings settings) {
        String username = System.getProperty("mongoUsername");
        String password = System.getProperty("mongoPassword");
        ConnectionString connectionString =
                new ConnectionString(
                        "mongodb+srv://" + username + ":" + password +
                                "@cluster0.0mgfy.mongodb.net/myFirstDatabase?retryWrites=true&w=majority"
                );
        settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(settings);
    }
}
