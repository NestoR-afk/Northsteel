package com.zakharoff.seversteel.service;

import com.zakharoff.seversteel.model.Note;
import com.zakharoff.seversteel.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Optional<Note> findById(Long id) {
        return noteRepository.findById(id);
    }

    public Optional<Note> save(Note note) {
        try {
            Note newNote = new Note(note.getHeader(), note.getText());
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
            return Optional.of(noteRepository.save(updatedNote));
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }
}
