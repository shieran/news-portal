package com.hancharou.newsportal.controller;

import com.hancharou.newsportal.entity.News;
import com.hancharou.newsportal.service.NewsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

@Controller
@RequestMapping(value = "/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public @ResponseBody Page findAllNews(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return newsService.findAllNews(pageable);
    }

    @GetMapping(path = "/{id}/details")
    public @ResponseBody News getNewsDetails(@PathVariable Long id) {
        return newsService.getNewDetails(id);
    }

    @PostMapping
    public @ResponseBody News createNews(@RequestBody News news) {
        return newsService.save(news);
    }

    @PutMapping
    public @ResponseBody News updateNews(@RequestBody News news) {
        return newsService.save(news);
    }

    @DeleteMapping(path = "{id}")
    public Response deleteNews(@PathVariable Long id) {
        newsService.delete(id);
        return Response.status(Response.Status.OK).build();
    }
}
