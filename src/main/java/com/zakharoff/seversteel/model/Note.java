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
    @Column(length = 1000)
    private String text;
    private String fontFamily;

    public Note() {
    }

    public Note(String header, String text, String fontFamily) {
        this.header = header;
        this.text = text;
        this.fontFamily = fontFamily;
    }
}

