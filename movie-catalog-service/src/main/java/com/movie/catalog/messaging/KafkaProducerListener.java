/*
package com.movie.catalog.messaging;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Service;

public class KafkaProducerListener implements ProducerListener<String, Object>
{
    @Override
    public void onSuccess( String topic, Integer partition, String key, Object value, RecordMetadata recordMetadata )
    {
        System.out.println("message sent to topic->"+topic);
        System.out.println("message sent key->"+key);
        System.out.println("message sent value->"+value);
    }

    @Override
    public void onError( String topic, Integer partition, String key, Object value, Exception exception )
    {
        System.out.println("message failed to topic->"+topic);
        System.out.println("message failed key->"+key);
        System.out.println("message failed value->"+value);
        System.out.println("message failed exception->"+exception);
    }
}
*/
