package org.springschool.simplerestclient.proxy;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springschool.simplerestclient.proxy.entity.RestPageImpl;
import org.springschool.simplerestclient.proxy.entity.Simple;

@Service
public class SimpleProxy {
    private RestTemplate rt = new RestTemplate();
    private String resourceUrl = "http://localhost:8080/";

    public PageImpl<Simple> getAllSimples(Pageable pageable) {
        UriComponents target = UriComponentsBuilder.fromUriString(resourceUrl)
                .path("/v2/simples")
                .queryParam("page", pageable.getPageNumber())
                .queryParam("size", pageable.getPageSize())
                .build();

        return rt.exchange(target.toUri(), HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<RestPageImpl<Simple>>() {}).getBody();
    }
}
