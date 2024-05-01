package org.study.ckeditor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.study.ckeditor.service.ContentService;

@Controller
public class EditorController {

    private ContentService contentService;

    @Autowired
    public EditorController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/editor")
    public String editorPage() {
        return "editor";
    }

    @GetMapping("/editor/{id}")
    public String updateContent(@PathVariable("id") String id, Model model) {

        model.addAttribute("data", contentService.selectContent(id));

        return "editor";

    }
}
