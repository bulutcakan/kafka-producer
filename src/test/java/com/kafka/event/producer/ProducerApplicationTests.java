package com.kafka.event.producer;

import com.kafka.event.producer.domain.LibraryEvent;
import com.kafka.event.producer.model.Book;
import com.kafka.event.producer.model.LibraryEventType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProducerApplicationTests {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void postLibraryEvent() {

        Book book = Book.builder().
                bookId(2).
                bookName("Nasil küçüklük").
                bookAuthor("TEATEMEANE").
                build();

        LibraryEvent libraryEvent = LibraryEvent.builder().
                libraryEventId(null).
                book(book).
                libraryEventType(LibraryEventType.NEW).
                build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LibraryEvent> request = new HttpEntity<>(libraryEvent, httpHeaders);
        ResponseEntity<LibraryEvent> responseEntity = testRestTemplate.exchange("/v1/libraryevent", HttpMethod.POST, request, LibraryEvent.class);
        org.junit.jupiter.api.Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

    }

}
