package com.example.kafkaconsumerdatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafkaconsumerdatabase.entity.WikimediaData;
import com.example.kafkaconsumerdatabase.repositories.WikimediaRepository;

@Service
public class KafkaDatabaseConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	private WikimediaRepository dataRepository;
	
	public KafkaDatabaseConsumer(WikimediaRepository dataRepository) {
		this.dataRepository = dataRepository;
	}
	
	@KafkaListener(topics="wikimedia_recentchange", groupId="myGroup")
	public void consume(String eventMessage) {
		LOGGER.info(toString().format("Event Message receieved: %s", eventMessage));
		WikimediaData data = new WikimediaData();
		data.setWikiEventData(eventMessage);
		this.dataRepository.save(data);
	}

}
