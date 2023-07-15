package com.ken.newsapp.services;

import com.ken.newsapp.dto.NewDTO;
import com.ken.newsapp.entities.New;
import com.ken.newsapp.exceptions.NotFoundException;
import com.ken.newsapp.repositories.NewRepository;
import com.ken.newsapp.requests.NewsRequest;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewService implements INewService {

    private final NewRepository newRepository;

    @Value("${api.key.news}")
    private String apiKey;

    @Override
    public void generateNews(NewsRequest request){
        NewsApiClient newsApiClient = new NewsApiClient(apiKey);
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q(request.getQuery())
                        .language(request.getLanguage())
                        .pageSize(request.getPageSize())
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        response.getArticles().forEach(a -> {
                            if(!newRepository.existsByUrl(a.getUrl())){
                                newRepository.save(New.builder()
                                        .title(a.getTitle())
                                        .content(a.getDescription())
                                        .url(a.getUrl())
                                        .author(a.getAuthor())
                                        .imageUrl(a.getUrlToImage())
                                        .source(a.getSource().getName())
                                        .date(LocalDate.from(ZonedDateTime.parse(a.getPublishedAt())))
                                        .tag(request.getQuery().toLowerCase())
                                        .lang(request.getLanguage())
                                        .build()
                                );
                            }
                        });
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        log.error(throwable.getMessage());
                    }
                }
        );
    }

    @Override
    public List<NewDTO> findAll(){
        return newRepository.findAll().stream().map(NewDTO::new).toList();
    }

    @Override
    public NewDTO findById(String id) throws NotFoundException {
        New n = newRepository.findById(id).orElse(null);
        if(n == null){
            throw new NotFoundException("New not found.");
        }
        return new NewDTO(n);
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        if(!newRepository.existsById(id)){
            throw new NotFoundException("New not found");
        }
        newRepository.deleteById(id);
    }

}





