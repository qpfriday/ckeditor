package org.study.ckeditor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.ckeditor.entity.ContentEntity;

public interface ContentRepository extends JpaRepository<ContentEntity, Integer> {
    ContentEntity findById(int id);
}
