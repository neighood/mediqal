package com.mediqal.community.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
public class Criteria {
    private int page;
    private int amount;

    private String boardCategory;

    public Criteria create(int page, int amount) {
        this.page = page;
        this.amount = amount;
        return this;
    }

    public Criteria criteria(int page, int amount) {
        this.page = page;
        this.amount = amount;
        return this;
    }

    public String getQueryString(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("page", this.page)
                .queryParam("amount", this.amount);
        return builder.toUriString();
    }

    public Criteria createCategory(String boardCategory) {
        this.boardCategory = boardCategory;
        return this;
    }
}
