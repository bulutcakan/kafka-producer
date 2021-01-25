package com.kafka.event.producer.domain;

import com.kafka.event.producer.model.Book;
import com.kafka.event.producer.model.LibraryEventType;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Bulut Cakan (179997) on
 * Hour :16:00
 * Day: Sunday
 * Month:January
 * Year:2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LibraryEvent {

    private Integer libraryEventId;

    private LibraryEventType libraryEventType;

    private Book book;

}
