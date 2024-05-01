package org.study.ckeditor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.study.ckeditor.dto.SaveDTO;
import org.study.ckeditor.service.ContentService;

@Controller
public class SaveController {

    private final ContentService contentService;

    @Autowired
    public SaveController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("/save")
    public String saveLogic(SaveDTO saveDTO) {

        contentService.saveContent(saveDTO);

        return "redirect:/";
    }

    @PostMapping("/save/{id}")
    public String updateLogic(SaveDTO saveDTO, @PathVariable("id") String id) {

        contentService.updateContent(saveDTO, id);
        return "redirect:/content/" + id;
    }
}
