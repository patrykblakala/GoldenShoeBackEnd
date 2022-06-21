package com.golden.shoe.shop.mapper;

import com.golden.shoe.shop.domain.dao.Template;
import com.golden.shoe.shop.domain.dto.TemplateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TemplateMapper {

    TemplateDto daoToDto(Template template);

    Template dtoToDao(TemplateDto templateDto);
}
