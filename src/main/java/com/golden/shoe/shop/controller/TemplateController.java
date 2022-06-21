package com.golden.shoe.shop.controller;

import com.golden.shoe.shop.domain.dto.TemplateDto;
import com.golden.shoe.shop.mapper.TemplateMapper;
import com.golden.shoe.shop.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(value = "/api/templates", produces = MediaType.APPLICATION_JSON_VALUE)
public class TemplateController {

    private final TemplateService templateService;
    private final TemplateMapper templateMapper;

    @PostMapping
    public TemplateDto createTemplate(@RequestBody @Valid TemplateDto template) {
        return templateMapper.daoToDto(templateService.save(templateMapper.dtoToDao(template)));
    }

    @DeleteMapping("/{id}")
    public void deleteTemplateById(@PathVariable Long id) {
        templateService.deleteTemplateById(id);
    }

    @PutMapping("/{id}")
    public TemplateDto updateTemplate(@RequestBody @Valid TemplateDto template, @PathVariable Long id) {
        return templateMapper.daoToDto(templateService.update(templateMapper.dtoToDao(template), id));
    }

    @GetMapping
    public Page<TemplateDto> getTemplatePage(@RequestParam int page, @RequestParam int size) {
        return templateService.getPage(PageRequest.of(page, size))
                .map(templateMapper::daoToDto);
    }

    @GetMapping("/{id}")
    public TemplateDto findTemplateById(@PathVariable Long id) {
        return templateMapper.daoToDto(templateService.findById(id));
    }

}
