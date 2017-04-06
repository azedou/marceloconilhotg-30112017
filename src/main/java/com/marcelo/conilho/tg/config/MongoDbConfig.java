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

         @Autowired
         MongoClient client;

         @Override
         public String getDatabaseName() {
                 return "mongodbtg";
         }

         @Override
         public Mongo mongo() throws Exception {
                 return new MongoClient(Collections.singletonList(new ServerAddress(System.getenv("OPENSHIFT_MONGODB_DB_HOST"), Integer.valueOf(System.getenv("OPENSHIFT_MONGODB_DB_PORT")))),
                 Collections.singletonList(MongoCredential.createCredential(System.getenv("OPENSHIFT_MONGODB_DB_USERNAME"), "mongodbtg", System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD").toCharArray())));
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
