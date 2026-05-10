package com.example.folio.controllers;

import com.example.folio.model.Block;
import com.example.folio.service.BlockService;
import com.example.folio.service.PageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlockController {

    private final BlockService blockService;
    private final PageService pageService;

    public BlockController(BlockService blockService, PageService pageService) {
        this.blockService = blockService;
        this.pageService = pageService;
    }

    @PostMapping("/pages/{pageId}/blocks")
    public String addBlock(@PathVariable Long pageId, @RequestParam String type, @RequestParam String content) {
        Block block = new Block();
        block.setType(type);
        block.setContent(content);
        block.setPage(pageService.getPageById(pageId));
        blockService.saveBlock(block);
        return "redirect:/pages/" + pageId;
    }

    @GetMapping("/blocks/delete/{id}/{pageId}")
    public String deleteBlock(@PathVariable Long id, @PathVariable Long pageId) {
        blockService.deleteBlock(id);
        return "redirect:/pages/" + pageId;
    }
}
