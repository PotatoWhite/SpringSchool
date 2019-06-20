package org.springschool.simplerestclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springschool.simplerestclient.proxy.SimpleProxy;
import org.springschool.simplerestclient.proxy.entity.Simple;

@Slf4j
@RestController
@RequestMapping("/simples")
public class TestController {

    @Autowired
    private SimpleProxy simpleProxy;

    @GetMapping("")
    public PageImpl<Simple> getAllSimples(Pageable pageable) {
        return simpleProxy.getAllSimples(pageable);
    }
}
