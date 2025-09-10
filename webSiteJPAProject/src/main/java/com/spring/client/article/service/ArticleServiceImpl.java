package com.spring.client.article.service;

import com.spring.client.article.domain.Article;
import com.spring.client.article.repository.ArticleRepository;
import com.spring.common.dto.PageRequestDTO;
import com.spring.common.dto.PageResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService{
    public final ArticleRepository articleRepository;

    @Override
    public List<Article> articleList(Article article){
        return articleRepository.findAll();
    }

    @Override
    public void articleInsert(Article article) {articleRepository.save(article);}


    @Override
    public Article getArticle(Long no){
      return articleRepository.findById(no)
              .orElseThrow(() -> new EntityNotFoundException("게시글이 존재하지 않습니다."));
    }

    @Override
    @Transactional
    public Article articleHitUpdate(Article article) {
        Article dataArticle = getArticle(article.getNo());
        dataArticle.setHit(dataArticle.getHit()+1);
        articleRepository.save(dataArticle);
        return dataArticle;

    }

    @Override
    public Article articleDetail(Article article){
        Article detail = articleHitUpdate(article);
        return detail;
    }

    @Override
    public void articleUpdate(Article article) {
        Optional<Article> articleOptional = articleRepository.findById(article.getNo());
        Article updateArticle = articleOptional.orElseThrow();

        updateArticle.setTitle(article.getTitle());
        updateArticle.setContent(article.getContent());

        articleRepository.save(updateArticle);
    }

    @Override
    public void articleDelete(Article article) {
        articleRepository.deleteById(article.getNo());
    }
    @Override
    public PageResponseDTO<Article> list(PageRequestDTO pageRequestDTO) {
        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() - 1, // 1페이지가 0이므로 주의
                pageRequestDTO.getSize(),
                Sort.by("no").descending());

        Page<Article> result = articleRepository.findAll(pageable);


        switch (pageRequestDTO.getSearch()) {
            case "title":
                result = articleRepository.findByTitleContaining(pageRequestDTO.getKeyword(), pageable);
                break;
            case "name":
                result = articleRepository.findByNameContaining(pageRequestDTO.getKeyword(), pageable);
                break;
            case "content":
                result = articleRepository.findByContentContaining(pageRequestDTO.getKeyword(), pageable);
                break;
            case "regDate":
                result = articleRepository.findByRegDateBetween(pageRequestDTO.getStartDate(), pageRequestDTO.getEndDate(), pageable);
                break;
            default:
                result = articleRepository.findAll(pageable);
                break;
        }

        List<Article> articleList = result.getContent().stream().collect(Collectors.toList());
        long totalCount = result.getTotalElements();
        PageResponseDTO<Article> responseDTO = PageResponseDTO.<Article>withAll()
                .dtoList(articleList)
                .pageRequestDTO(pageRequestDTO)
                .totalCount(totalCount)
                .build();

        return responseDTO;
    }


}