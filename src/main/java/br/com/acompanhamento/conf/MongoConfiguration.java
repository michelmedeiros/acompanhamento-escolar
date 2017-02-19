package br.com.acompanhamento.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by miche on 19/02/2017.
 */
@Configuration
@EnableMongoAuditing
@EnableMongoRepositories("br.com.acompanhamento.gateways.mongo")
public class MongoConfiguration {
}
