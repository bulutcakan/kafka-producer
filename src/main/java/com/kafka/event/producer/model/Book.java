package com.kafka.event.producer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Bulut Cakan (179997) on
 * Hour :16:28
 * Day: Sunday
 * Month:January
 * Year:2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {

    private Integer bookId;

    private String bookName;

    private String bookAuthor;
}
