package com.golden.shoe.shop.service;

import com.golden.shoe.shop.domain.dao.Template;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TemplateService {

    Template save(Template template);

    Template findById(Long id);

    Template findByName(String name);

    Template update(Template template, Long id);

    void deleteTemplateById(Long id);

    Page<Template> getPage(Pageable pageable);
}

