package com.example.demo.repository;

import com.example.demo.model.NoteDetail;
import com.example.demo.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteDetailRepository extends JpaRepository<NoteDetail,Long> {
    List<NoteDetail> findAllByTag_id(Long id);
}
