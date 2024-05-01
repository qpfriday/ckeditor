package org.study.ckeditor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.study.ckeditor.service.ContentService;

@Controller
public class ListController {

    private ContentService contentService;

    @Autowired
    public ListController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/list")
    public String listPage(Model model) {

        model.addAttribute("ContentList", contentService.selectContents());
        return "list";
    }
}
