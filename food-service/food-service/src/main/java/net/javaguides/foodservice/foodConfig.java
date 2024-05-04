package net.javaguides.foodservice;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

//import com.fasterxml.jackson.databind.JsonDeserializer;
//import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
//import com.fasterxml.jackson.databind.ser.std.StringSerializer;

import net.javaguides.orderservice.Order;
import net.javaguides.orderservice.smsStatus;
import net.javaguides.stockservice.Stock;
@EnableKafka
@Configuration
public class foodConfig {
	@Bean
	public ConsumerFactory<String, Order> foodconsumerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "[::1]:9092");
		configProps.put(ConsumerConfig.GROUP_ID_CONFIG,"my-group-id");
		configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(
				configProps, new StringDeserializer(),
	            new JsonDeserializer<>(Order.class));
	//	return new DefaultKafkaConsumerFactory<>(configProps);
	}

	//creating listener
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Order>
	foodListener(){
		ConcurrentKafkaListenerContainerFactory<String, Order> factory
		= new ConcurrentKafkaListenerContainerFactory<String, Order>();
		factory.setConsumerFactory(foodconsumerFactory());
		return factory;
				
	}
	
	@Bean
	public ProducerFactory<String,smsStatus> foodProducerFactory() {
		Map<String, Object> configProp = new HashMap<>();
		configProp.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "[::1]:9092");
		configProp.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProp.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProp);
	}
	
	@Bean
	public KafkaTemplate<String,smsStatus> kafkaTemplate() {
		return new KafkaTemplate<>(foodProducerFactory());
	}
	
	@Bean
	public ProducerFactory<String,Stock> StockcProducerFactory() {
		Map<String, Object> configProp = new HashMap<>();
		configProp.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "[::1]:9092");
		configProp.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProp.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProp);
	}
	
	@Bean
	public KafkaTemplate<String,Stock> kafkaTemplateST() {
		return new KafkaTemplate<>(StockcProducerFactory());
	}
	



}