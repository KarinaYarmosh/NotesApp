package com.notesapp.controller;

import com.notesapp.model.Notes;
import com.notesapp.model.Users;
import com.notesapp.service.NotesService;
import com.notesapp.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    private final UsersService usersService;
    private final NotesService notesService;

    public NotesController(UsersService usersService, NotesService notesService) {
        this.usersService = usersService;
        this.notesService = notesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Notes>> getAllNotes() {
        try {
            return ResponseEntity.ok(notesService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/all/{user_id}")
    public ResponseEntity<List<Notes>> getAllNotesByUserId(@PathVariable Long user_id) {
        try {
            return ResponseEntity.ok(notesService.findAllByUserId(user_id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Notes> createNotes(@RequestBody Notes notes, @RequestParam int user_id) {
        Users user = usersService.findById(user_id);
        notes.setUser(user);
        try {
            return ResponseEntity.ok(notesService.save(notes));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(notes);
        }
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllNotes() {
        try {
            notesService.deleteAll();
            return ResponseEntity.ok("All notes were deleted");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Notes not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotes(@PathVariable int id) {
        try {
            notesService.deleteById(id);
            return ResponseEntity.ok(id + " was deleted");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Notes not found with id " + id);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notes> getNotesById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(notesService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notes> updateNotes(@PathVariable int id, @RequestBody Notes notes) {
        try {
            notesService.updateNoteById(id, notes);
            return ResponseEntity.ok(notes);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(notes);
        }
    }
}
