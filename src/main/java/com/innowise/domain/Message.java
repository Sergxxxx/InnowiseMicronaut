package com.innowise.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name="message")
@Builder(setterPrefix = "with")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name="HIBERNATE_SEQUENCE", initialValue = 10000)  //индекс начнется с 10000 после миграции данных
public class Message {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "type", nullable = false)
    @Size(max = 250)
    private String type;

    @Column(name = "text", nullable = false)
    @Size(max = 250)
    private String text;

    @Column(name = "tag", nullable = false)
    @Size(max = 250)
    private String tag;
}
