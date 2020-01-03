package com.hancharou.newsportal.service.serviceImpl;

import com.hancharou.newsportal.entity.News;
import com.hancharou.newsportal.repo.NewsRepo;
import com.hancharou.newsportal.service.NewsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

   private final NewsRepo newsRepo;

    public NewsServiceImpl(NewsRepo newsRepo) {
        this.newsRepo = newsRepo;
    }

    @Override
    public Page findAllNews(Pageable pageable) {
        return newsRepo.findAll(pageable);
    }

    @Override
    public News save(News news) {
        return newsRepo.save(news);
    }

    @Override
    public void delete(Long id) {
        newsRepo.deleteById(id);
    }

    @Override
    public News getNewDetails(Long id) {
        return newsRepo.getNewsDetailsById(id);
    }
}
