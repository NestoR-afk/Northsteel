package com.zakharoff.seversteel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(schema = "web")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String header;
    @Column(length = 1000)
    private String text;
    private String fontFamily;
    private Integer fontSize;
    @Column(length = Integer.MAX_VALUE)
    private String image;
}

