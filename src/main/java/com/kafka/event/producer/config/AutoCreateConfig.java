package com.kafka.event.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Created by Bulut Cakan (179997) on
 * Hour :17:38
 * Day: Sunday
 * Month:January
 * Year:2021
 */
@Configuration
@Profile("local")
public class AutoCreateConfig {

    @Bean
    public NewTopic libraryEvents() {
        return TopicBuilder.name("library-events").
                partitions(3).
                replicas(1).
                build();
    }
}
