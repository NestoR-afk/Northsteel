package com.zakharoff.seversteel.service;

import com.zakharoff.seversteel.model.Note;
import com.zakharoff.seversteel.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Optional<Note> save(Note note) {
        try {
            Note newNote = new Note(note.getHeader(), note.getText(), note.getFontFamily(), note.getFontSize());
            return Optional.of(noteRepository.save(newNote));
        } catch(Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Note> update(Long id, Note note) {
        Optional<Note> noteOptional = noteRepository.findById(id);

        if (noteOptional.isPresent()) {
            Note updatedNote = noteOptional.get();
            updatedNote.setId(id);
            updatedNote.setHeader(note.getHeader());
            updatedNote.setText(note.getText());
            updatedNote.setFontFamily(note.getFontFamily());
            return Optional.of(noteRepository.save(updatedNote));
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }
}
