package com.hancharou.newsportal.repo;

import com.hancharou.newsportal.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NewsRepo extends PagingAndSortingRepository<News, Long> {
    @Query(value = "select news_name from news", nativeQuery = true)
    Page findAll(Pageable pageable);
    void deleteById(Long id);
    News getNewsDetailsById(Long id);
}
