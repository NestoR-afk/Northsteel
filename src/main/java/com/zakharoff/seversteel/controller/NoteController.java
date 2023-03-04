package com.zakharoff.seversteel.controller;

import com.zakharoff.seversteel.model.Note;
import com.zakharoff.seversteel.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getNotes() {
        List<Note> notes = noteService.findAll();

        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getNote(@PathVariable Long id) {
        Optional<Note> noteData = noteService.findById(id);

        if (noteData.isPresent()) {
            return new ResponseEntity<>(noteData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/notes")
    public ResponseEntity<Note> createNote(@RequestBody Note noteBody) {
        Note note = noteService.save(noteBody);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable("id") long id, @RequestBody Note noteBody) {
        Optional<Note> updatedNote = noteService.update(id, noteBody);

        if (updatedNote.isPresent()) {
            return new ResponseEntity<>(updatedNote.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<HttpStatus> deleteNote(@PathVariable Long id) {
        noteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
