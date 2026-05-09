package com.example.folio.repository;


import com.example.folio.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PageRepository extends JpaRepository<Page, Long> {
}
