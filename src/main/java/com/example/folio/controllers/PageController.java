package com.example.folio.controllers;

import com.example.folio.model.Page;
import com.example.folio.service.BlockService;
import com.example.folio.service.PageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    private final PageService pageService;
    private final BlockService blockService;

    public PageController(PageService pageService, BlockService blockService) {
        this.pageService = pageService;
        this.blockService = blockService;
    }


    @GetMapping("/pages")
    public String getAllPages(Model model) {
        model.addAttribute("pages", pageService.getAllPages());
        return "pages";
    }
@GetMapping("/pages/{id}")
public String getPage(@PathVariable Long id, Model model) {
    model.addAttribute("page", pageService.getPageById(id));
    model.addAttribute("blocks", blockService.getBlocksByPageId(id));
    return "page";
}

//    @GetMapping("/pages/{id}")
//    public String getPage(@PathVariable Long id, Model model) {
//        model.addAttribute("page", pageService.getPageById(id));
//        return "page";
//    }

    @GetMapping("/pages/new")
    public String newPageForm(Model model) {
        model.addAttribute("page", new Page());
        return "page-form";
    }

    @PostMapping("/pages")
    public String savePage(@ModelAttribute Page page) {
        pageService.savePage(page);
        return "redirect:/pages";
    }

    @GetMapping("/pages/delete/{id}")
    public String deletePage(@PathVariable Long id) {
        pageService.deletePage(id);
        return "redirect:/pages";
    }

    @GetMapping("/pages/edit/{id}")
    public String editPageForm(@PathVariable Long id, Model model) {
        model.addAttribute("page", pageService.getPageById(id));
        return "page-edit";
    }

    @PostMapping("/pages/edit/{id}")
    public String updatePage(@PathVariable Long id, @ModelAttribute Page page) {
        page.setId(id);
        pageService.savePage(page);
        return "redirect:/pages";
    }
}
