package com.golden.shoe.shop.service;

import com.golden.shoe.shop.domain.dao.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User user);

    User getById(Long id);

    Page<User> page(Pageable pageable);

    User getCurrentUser();

    User getByEmail(String email);

    User update(User user, Long id);

    void deleteById(Long id);

    User register(User user);
}
