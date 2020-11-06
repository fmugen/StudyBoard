package com.study.board.auth.service;

import com.study.board.auth.dto.AuthDto;
import com.study.board.auth.service.AuthService;
import com.study.board.entity.Auth;
import com.study.board.entity.AuthExample;
import com.study.board.mybatis.mapper.AuthMapper;
import com.study.board.mybatis.mapper.AuthMapperCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final AuthMapper authMapper;
    private final AuthMapperCustom authMapperCustom;

    /**
     * PasswordEncoder
     */
    private final PasswordEncoder passwordEncoder;

    public void insertUser(AuthDto authdto) {
        Auth auth = new Auth();
        auth.setPassword(passwordEncoder.encode(authdto.getPassword()));
        auth.setUsername(authdto.getName());
        authMapperCustom.insertUser(auth);
    }


    public List<Auth> findAllUser() {
        return authMapper.selectByExample(new AuthExample());
    }
}
