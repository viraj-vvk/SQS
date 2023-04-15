package com.demo.sqs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.config.SimpleMessageListenerContainerFactory;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;

@Configuration
@EnableSqs
public class AwsSQSConfiguration {

    @Value("${cloud.aws.region:eu-west-1}")
    private String awsRegion;

    @Value("${cloud.aws.accessKey:eu-west-1}")
    private String awsAccessKey;

    @Value("${cloud.aws.secretKey:eu-west-1}")
    private String awsSecretKey;

    @Bean
    @Primary
    public AmazonSQSAsync amazonSQSAsync() {
        return AmazonSQSAsyncClientBuilder
                .standard()
                .withCredentials(credentialsProvider())
                .withRegion(awsRegion)
                .build();
    }

    @Bean
    public AWSCredentialsProvider credentialsProvider() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
    }

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate() {
        return new QueueMessagingTemplate(amazonSQSAsync());
    }

    @Bean
    public SimpleMessageListenerContainerFactory simpleMessageListenerContainerFactory(AmazonSQSAsync amazonSQSAsync) {
        return new SimpleMessageListenerContainerFactory() {
            {
                setAmazonSqs(amazonSQSAsync);
                setAutoStartup(true);
                setMaxNumberOfMessages(10);
                setTaskExecutor(createDefaultTaskExecuter());
            }
        };
    }

    protected AsyncTaskExecutor createDefaultTaskExecuter() {
        return new ThreadPoolTaskExecutor() {
            {
                setThreadNamePrefix("SQSExecutor-");
                setCorePoolSize(100);
                setMaxPoolSize(100);
                setQueueCapacity(20);
                afterPropertiesSet();
            }
        };
    }
}
