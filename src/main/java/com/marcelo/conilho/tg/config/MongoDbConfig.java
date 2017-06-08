package com.marcelo.conilho.tg.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.context.annotation.PropertySource;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@PropertySource("classpath:application.properties")

@Configuration
@EnableMongoRepositories(basePackages = { "com.marcelo.conilho.tg.repository" })
public class MongoDbConfig extends AbstractMongoConfiguration {

         @Value("${spring.data.mongodb.host}")
         private String host;
         @Value("${spring.data.mongodb.username}")
         private String user;
         @Value("${spring.data.mongodb.password}")
         private String password;
         @Value("${spring.data.mongodb.database}")
         private String database;
         @Value("${spring.data.mongodb.port}")
         private int port;


         @Autowired
         MongoClient client;

         @Override
         public String getDatabaseName() {
                 return database;
         }

         @Bean
         public MongoClient mongoClient() throws Exception {
                 return new MongoClient(new MongoClientURI( "mongodb://marceloconilhotg:Senhatest1@ds021346.mlab.com:21346/marceloconilhotg" ));
                 /*return new MongoClient(Collections.singletonList(new ServerAddress(host, port)),
                 Collections.singletonList(MongoCredential.createCredential(user,database, password.toCharArray())));*/
         }
         
         @Override
         public Mongo mongo() throws Exception {
                 return mongoClient();
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
