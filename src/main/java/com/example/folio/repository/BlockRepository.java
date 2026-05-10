package com.example.folio.repository;

import com.example.folio.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BlockRepository extends JpaRepository<Block, Long> {
    List<Block> findByPageId(Long pageId);
}