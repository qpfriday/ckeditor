package org.study.ckeditor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.ckeditor.dto.SaveDTO;
import org.study.ckeditor.entity.ContentEntity;
import org.study.ckeditor.repository.ContentRepository;

import java.util.List;

@Service
public class ContentService {

    private final ContentRepository contentRepository;

    @Autowired
    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public void saveContent(SaveDTO saveDTO) {
        String title = saveDTO.getTitle();
        String content = saveDTO.getContent();

        ContentEntity content1 = new ContentEntity();

        content1.setTitle(title);
        content1.setContent(content);

        contentRepository.save(content1);
    }

    // 전체 게시글 불러오기
    public List<ContentEntity> selectContents() {
        return contentRepository.findAll();
    }

    // 하나의 게시글 불러오기
    public ContentEntity selectContent(String id) {
        int to = Integer.parseInt(id);

        return contentRepository.findById(to);
    }

    // 게시글 삭제하기
    public void deleteContent(String id) {
        int to = Integer.parseInt(id);
        contentRepository.deleteById(to);
    }

    // 게시글 수정하기
    public void updateContent(SaveDTO saveDTO, String id) {
        ContentEntity content1 = new ContentEntity();
        content1.setId(Integer.parseInt(id));
        content1.setTitle(saveDTO.getTitle());
        content1.setContent(saveDTO.getContent());

        contentRepository.save(content1);
    }
}
