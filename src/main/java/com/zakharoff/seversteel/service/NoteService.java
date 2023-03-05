package com.zakharoff.seversteel.service;

import com.zakharoff.seversteel.model.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {

    List<Note> findAll();

    Optional<Note> findById(Long id);

    Optional<Note> save(Note note);

    Optional<Note> update(Long id, Note note);

    void deleteById(Long id);
}
