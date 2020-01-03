package com.hancharou.newsportal.service;

import com.hancharou.newsportal.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NewsService {

    Page findAllNews(Pageable pageable);

    News save(News news);

    void delete(Long id);

    News getNewDetails(Long id);

}
