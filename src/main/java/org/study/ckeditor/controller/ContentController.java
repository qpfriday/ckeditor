package org.study.ckeditor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.study.ckeditor.service.ContentService;

@Controller
public class ContentController {

    private ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/content/{id}")
    public String contentPage(@PathVariable("id") String id, Model model) {

        model.addAttribute("Content", contentService.selectContent(id));


        return "content";
    }
}
