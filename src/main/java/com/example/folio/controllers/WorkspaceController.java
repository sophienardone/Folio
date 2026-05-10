package com.example.folio.controllers;


import com.example.folio.model.Workspace;
import com.example.folio.service.WorkspaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @GetMapping("/workspaces")
    public String getAllWorkspaces(Model model) {
        model.addAttribute("workspaces", workspaceService.getAllWorkspaces());
        return "workspaces";
    }

    @GetMapping("/workspaces/new")
    public String newWorkspaceForm(Model model) {
        model.addAttribute("workspace", new Workspace());
        return "workspace-form";
    }

    @PostMapping("/workspaces")
    public String saveWorkspace(@ModelAttribute Workspace workspace) {
        workspaceService.saveWorkspace(workspace);
        return "redirect:/workspaces";
    }

    @GetMapping("/workspaces/{id}")
    public String getWorkspace(@PathVariable Long id, Model model) {
        model.addAttribute("workspace", workspaceService.getWorkspaceById(id));
        return "workspace";
    }

    @GetMapping("/workspaces/delete/{id}")
    public String deleteWorkspace(@PathVariable Long id) {
        workspaceService.deleteWorkspace(id);
        return "redirect:/workspaces";
    }
}
