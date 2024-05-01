package org.study.ckeditor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.study.ckeditor.service.ContentService;

@Controller
public class DeleteController {

    private final ContentService contentService;

    @Autowired
    public DeleteController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        contentService.deleteContent(id);
        return "redirect:/list";
    }

}
