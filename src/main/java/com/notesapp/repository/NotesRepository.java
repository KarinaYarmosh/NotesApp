package com.notesapp.repository;

import com.notesapp.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotesRepository extends JpaRepository<Notes, Integer> {

    @Query("SELECT n FROM Notes n WHERE n.user.id = ?1")
    List<Notes> findAllByUserId(@Param("user_id") Long user_id);

}
