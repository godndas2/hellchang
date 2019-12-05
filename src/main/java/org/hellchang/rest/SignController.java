package org.hellchang.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.hellchang.model.UserModel;
import org.hellchang.model.common.CommonResult;
import org.hellchang.repository.UserRepository;
import org.hellchang.service.ResponseService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Api(tags = {"1. Sign"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class SignController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ResponseService responseService;

    @ApiOperation(value = "회원가입", notes = "회원가입")
    @PostMapping(value = "/signup")
    public CommonResult getSignup(@RequestParam String password,
                               @RequestParam String name,
                               @RequestParam String email) {

        userRepository.save(UserModel.builder()
                .name(name)
                .password(passwordEncoder.encode(password))
                .email(email)
                .roles(Collections.singletonList("ROLE_USER"))
                .build());

        return responseService.getSuccessResult();
    }
}
