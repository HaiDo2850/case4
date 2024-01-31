package com.example.demo.repository;

import com.example.demo.model.NoteDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteDetailRepository extends JpaRepository<NoteDetail,Long> {
}
