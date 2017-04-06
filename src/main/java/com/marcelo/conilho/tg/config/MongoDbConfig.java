package com.marcelo.conilho.tg.config;

import java.net.UnknownHostException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@EnableMongoRepositories(basePackages = { "com.marcelo.conilho.tg.repository" })
public class MongoDbConfig extends AbstractMongoConfiguration {

         @Value(System.getenv("OPENSHIFT_MONGODB_DB_HOST"))
         protected String host;
         @Value(System.getenv("OPENSHIFT_MONGODB_DB_USERNAME"))
         protected String user;
         @Value(System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD"))
         protected String password;
         @Value("mongodbtg"))
         protected String database;

         @Value(System.getenv("OPENSHIFT_MONGODB_DB_PORT"))
         protected int port;

         @Autowired
         protected MongoClient client;

         @Override
         protected String getDatabaseName() {
                 return database;
         }

         @Bean
         public MongoClient getClient() throws UnknownHostException {
                 return new MongoClient(Collections.singletonList(new ServerAddress(host, port)),
                                   Collections.singletonList(MongoCredential.createCredential(user, database, password.toCharArray())));
         }

         @Override
         public Mongo mongo() throws Exception {
                 return client;
         }

         @Bean
         public MongoTemplate mongoTemplate() throws Exception {

                 @SuppressWarnings("deprecation")
                 MappingMongoConverter converter = new MappingMongoConverter(mongoDbFactory(), new MongoMappingContext());
                 converter.setTypeMapper(new DefaultMongoTypeMapper(null));

                 MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);

                 return mongoTemplate;

         }

}
