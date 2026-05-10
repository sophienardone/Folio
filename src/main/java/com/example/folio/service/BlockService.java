package com.example.folio.service;

import com.example.folio.model.Block;
import com.example.folio.repository.BlockRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlockService {

    private final BlockRepository blockRepository;

    public BlockService(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    public List<Block> getBlocksByPageId(Long pageId) {
        return blockRepository.findByPageId(pageId);
    }

    public Block saveBlock(Block block) {
        return blockRepository.save(block);
    }

    public void deleteBlock(Long id) {
        blockRepository.deleteById(id);
    }
}
