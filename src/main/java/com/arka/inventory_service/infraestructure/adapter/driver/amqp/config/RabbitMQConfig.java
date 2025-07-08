//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.amqp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String STOCK_EXCHANGE = "stock";
    public static final String STOCK_RECEIVED_QUEUE = "stock.received";
    public static final String STOCK_RECEIVED_ROUTING_KEY = "stock.received";
    public static final String ORDER_EXCHANGE = "order";
    public static final String ORDER_PLACED_QUEUE = "order.placed";
    public static final String ORDER_PLACED_ROUTING_KEY = "order.placed";

    public RabbitMQConfig() {
    }

    @Bean
    public TopicExchange stockExchange() {
        return new TopicExchange("stock");
    }

    @Bean
    public TopicExchange orderExchange() {
        return new TopicExchange("order");
    }

    @Bean
    public Queue stockReceivedQueue() {
        return new Queue("stock.received");
    }

    @Bean
    public Queue orderPlacedQueue() {
        return new Queue("order.placed");
    }

    @Bean
    public Binding stockReceivedBinding(Queue stockReceivedQueue, TopicExchange stockExchange) {
        return BindingBuilder.bind(stockReceivedQueue).to(stockExchange).with("stock.received");
    }

    @Bean
    public Binding orderPlacedBinding(Queue orderPlacedQueue, TopicExchange orderExchange) {
        return BindingBuilder.bind(orderPlacedQueue).to(orderExchange).with("order.placed");
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(this.messageConverter());
        return factory;
    }
}
