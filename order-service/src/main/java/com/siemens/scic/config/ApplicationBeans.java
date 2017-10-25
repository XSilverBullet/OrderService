package com.siemens.scic.config;

import com.siemens.scic.async.TaskQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Simon.Lau on 16-Dec-16.
 */
@Configuration
public class ApplicationBeans {

    @Bean
    TaskQueue erpTaskQueue () {
        return new TaskQueue();
    }

    @Bean
    TaskQueue mesTaskQueue () {
        return new TaskQueue();
    }

    @Bean
    TaskQueue wccTaskQueue () {
        return new TaskQueue();
    }

}
