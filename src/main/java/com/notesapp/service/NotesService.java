package com.notesapp.service;

import com.notesapp.model.Notes;
import com.notesapp.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class NotesService {

    private final NotesRepository notesRepository;

    @Autowired
    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }
    public List<Notes> findAll() {
        return notesRepository.findAll();
    }

    public Notes findById(int id) {
        return notesRepository.findById(id).orElse(null);
    }

    public Notes save(Notes notes) {
        return notesRepository.save(notes);
    }

    public void deleteAll() {
        notesRepository.deleteAll();
    }

    public void deleteById(int id) {
        Optional<Notes> notes = notesRepository.findById(id);
        if (notes.isPresent()) {
            notesRepository.deleteById(id);
        }
        else{
            throw new NotFoundException("Notes not found with id " + id);
        }
    }

    public List<Notes> findAllByUserId(Long user_id) {
        return notesRepository.findAllByUserId(user_id);
    }

    public void updateNoteById(int id, Notes notes) {
        Optional<Notes> note = notesRepository.findById(id);
        if (note.isPresent()) {
            Notes newNote = note.get();
            newNote.setTitle(notes.getTitle());
            newNote.setContent(notes.getContent());

            notesRepository.save(newNote);
        }
        else{
            throw new NotFoundException("Notes not found with id " + id);
        }
    }

}
