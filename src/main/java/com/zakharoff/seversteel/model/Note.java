package com.zakharoff.seversteel.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(schema = "web")
@Entity
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String header;
    private String text;

    public Note() {
    }

    public Note(String header, String text) {
        this.header = header;
        this.text = text;
    }
}

