package com.zakharoff.seversteel;

import com.zakharoff.seversteel.model.Note;
import com.zakharoff.seversteel.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeverSteelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeverSteelApplication.class, args);
    }
}
