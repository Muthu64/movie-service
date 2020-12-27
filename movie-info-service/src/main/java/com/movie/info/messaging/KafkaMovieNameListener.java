/*
package com.movie.info.messaging;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

import com.movie.info.model.MovieMessage;

//@Service
public class KafkaMovieNameListener implements MessageListener<String, MovieMessage>
{
    @Override
    public void onMessage( ConsumerRecord<String, MovieMessage> movieMessageConsumerRecord )
    {
        System.out.println( " message received here in consumer ---> "+movieMessageConsumerRecord.value() );
    }
}
*/
