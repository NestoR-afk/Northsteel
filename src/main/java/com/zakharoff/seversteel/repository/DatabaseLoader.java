package com.zakharoff.seversteel.repository;

import com.zakharoff.seversteel.model.Note;
import com.zakharoff.seversteel.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final NoteService noteService;

    @Autowired
    public DatabaseLoader(NoteService noteService) {
        this.noteService = noteService;
    }

    @Override
    public void run(String... args) throws Exception {
        Note note = new Note("Добро пожаловать в заметки!",
                "Здесь вы можете записывать важные события, чтобы не забыть их.");
        noteService.save(note);
    }
}
