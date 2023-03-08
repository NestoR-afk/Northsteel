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
            Note newNote = noteRepository.save(note);
            return Optional.of(newNote);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Note> update(Long id, Note note) {
        Optional<Note> noteOptional = noteRepository.findById(id);

        try {
            if (noteOptional.isPresent()) {
                Note updatedNote = noteOptional.get();
                updatedNote.setHeader(note.getHeader());
                updatedNote.setText(note.getText());
                updatedNote.setFontFamily(note.getFontFamily());
                updatedNote.setImage(note.getImage());
                return Optional.of(noteRepository.save(updatedNote));
            } else {
                note.setId(id);
                return Optional.of(noteRepository.save(note));
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }
}
