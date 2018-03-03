package org.glenlivet.sakura;

import org.glenlivet.sakura.redis.RedisAtomicBeansConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by glenlivet on 6/12/17.
 */
@SpringBootApplication
@Import({RedisAtomicBeansConfig.class})
@PropertySources({@PropertySource("jms-destination.yml")})
@EnableMongoRepositories(basePackages = {"org.glenlivet.sakura.mongo.repository"})
public class SakuraApplication {

    public static void main(String[] args) {
        SpringApplication.run(SakuraApplication.class, args);
    }

}
