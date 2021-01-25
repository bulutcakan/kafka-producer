package com.kafka.event.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.event.producer.domain.LibraryEvent;
import com.kafka.event.producer.model.LibraryEventType;
import com.kafka.event.producer.producer.LibraryEventProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Created by Bulut Cakan (179997) on
 * Hour :17:08
 * Day: Sunday
 * Month:January
 * Year:2021
 */
@RestController
@Slf4j
public class LibraryController {

    @Autowired
    LibraryEventProducer libraryEventProducer;

    @PostMapping("v1/libraryevent")
    public ResponseEntity<LibraryEvent> addBook(@RequestBody LibraryEvent libraryEvent) throws JsonProcessingException {

        // log.info("Before send library Event");
        // libraryEventProducer.sendLibraryEventAsynchronous(libraryEvent);
        //  SendResult sendResult = libraryEventProducer.sendLibraryEventSynchronous(libraryEvent);
        libraryEvent.setLibraryEventType(LibraryEventType.NEW);
        libraryEventProducer.sendLibraryEventAsynchronousApproach2WithTopicName(libraryEvent);
        //  log.info("After send library Event");
        //  log.info("Send result {}", sendResult.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
    }

    @PutMapping("v1/libraryevent")
    public ResponseEntity updateBook(@RequestBody LibraryEvent libraryEvent) throws JsonProcessingException {

        if (Objects.isNull(libraryEvent.getLibraryEventId()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please pass the Library event id");

        // log.info("Before send library Event");
        // libraryEventProducer.sendLibraryEventAsynchronous(libraryEvent);
        //  SendResult sendResult = libraryEventProducer.sendLibraryEventSynchronous(libraryEvent);
        libraryEvent.setLibraryEventType(LibraryEventType.UPDATE);
        libraryEventProducer.sendLibraryEventAsynchronousApproach2WithTopicName(libraryEvent);
        //  log.info("After send library Event");
        //  log.info("Send result {}", sendResult.toString());
        return ResponseEntity.status(HttpStatus.OK).body(libraryEvent);
    }


}
