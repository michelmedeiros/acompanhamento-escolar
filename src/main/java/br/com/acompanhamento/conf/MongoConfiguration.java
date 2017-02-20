package br.com.acompanhamento.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories("br.com.acompanhamento.gateways.mongo")
public class MongoConfiguration {
}
