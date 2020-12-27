/*
package com.movie.info.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.movie.info.model.MovieMessage;

//@Configuration
//@EnableKafka
public class KafkaConsumerConfiguration
{
    private static final String MOVIE_NAME_STRING_GROUP_ID = "movie-name-string-group";
    private static final String MOVIE_LIST_GROUP_ID = "movie-list-group";

    @Bean
    public ConsumerFactory<String, MovieMessage> consumerFactory( @Value( "${kafkaBootstrapServerHost}" ) String kafkaBootstrapServerHost )
    {
        JsonDeserializer<MovieMessage> deserializer = new JsonDeserializer<>( MovieMessage.class );
        deserializer.setRemoveTypeHeaders( false );
        deserializer.addTrustedPackages( "*" );
        deserializer.setUseTypeMapperForKey( true );

        Map<String, Object> configs = this.getConsumerProperties( kafkaBootstrapServerHost, deserializer );
        return new DefaultKafkaConsumerFactory<>( configs, new StringDeserializer(), deserializer );
    }

    private Map<String, Object> getConsumerProperties( String kafkaBootstrapServerHost, JsonDeserializer<?> deserializer )
    {
        Map<String, Object> configs = new HashMap<>();
        configs.put( ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServerHost );
        configs.put( ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class );
        configs.put( ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer );
        configs.put( ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest" );
        configs.put( ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false );
        configs.put( ConsumerConfig.GROUP_ID_CONFIG, MOVIE_LIST_GROUP_ID );

        return configs;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MovieMessage> kafkaListenerContainerFactory( ConsumerFactory<String, MovieMessage> consumerFactory )
    {
        ConcurrentKafkaListenerContainerFactory<String, MovieMessage> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        concurrentKafkaListenerContainerFactory.setConsumerFactory( consumerFactory );
        return concurrentKafkaListenerContainerFactory;
    }

  */
/*  @Bean
    public KafkaMessageListenerContainer<String, MovieMessage> messageListenerContainer( @Value( "${kafkaTopicName}" ) String kafkaTopicName,
                                                                                         ConsumerFactory<String, MovieMessage> consumerFactory)
    {
        ContainerProperties containerProperties = new ContainerProperties( kafkaTopicName );
        containerProperties.setMessageListener( new KafkaMovieNameListener() );

        KafkaMessageListenerContainer<String, MovieMessage> listenerContainer = new KafkaMessageListenerContainer<>( consumerFactory, containerProperties );
        listenerContainer.setAutoStartup( false );

        // bean name is the prefix of kafka consumer thread name
        listenerContainer.setBeanName( "kafka-message-listener" );

        return listenerContainer;
    }*//*

}
*/
