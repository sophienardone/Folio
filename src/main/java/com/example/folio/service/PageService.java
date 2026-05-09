package com.example.folio.service;


import com.example.folio.model.Page;
import com.example.folio.repository.PageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService {

    private final PageRepository pageRepository;

    public PageService(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    public List<Page> getAllPages() {
        return pageRepository.findAll();
    }

    public Page getPageById(Long id) {
        return pageRepository.findById(id).orElse(null);
    }

    public Page savePage(Page page) {
        return pageRepository.save(page);
    }

    public void deletePage(Long id) {
        pageRepository.deleteById(id);
    }
}
