package com.example.folio.repository;


import com.example.folio.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PageRepository extends JpaRepository<Page, Long> {
    List<Page> findByTitleContainingIgnoreCase(String title);
}
