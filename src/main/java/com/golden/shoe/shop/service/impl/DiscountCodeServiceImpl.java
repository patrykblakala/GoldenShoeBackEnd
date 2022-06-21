package com.golden.shoe.shop.service.impl;

import com.golden.shoe.shop.domain.dao.DiscountCode;
import com.golden.shoe.shop.repository.DiscountCodeRepository;
import com.golden.shoe.shop.service.DiscountCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountCodeServiceImpl implements DiscountCodeService {

    private final DiscountCodeRepository discountCodeRepository;

    @Override
    public DiscountCode save(DiscountCode discountCode) {
        return discountCodeRepository.save(discountCode);
    }
}
