package org.hellchang.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.hellchang.exception.CustomEmailSigninFailedException;
import org.hellchang.model.UserModel;
import org.hellchang.model.common.CommonResult;
import org.hellchang.model.common.SingleResult;
import org.hellchang.repository.UserRepository;
import org.hellchang.service.ResponseService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Api(tags = {"1. Sign"})
@RequiredArgsConstructor
@RestController
public class SignController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ResponseService responseService;

    @ApiOperation(value = "회원가입", notes = "회원가입")
    @PostMapping(value = "v1/signup")
    public CommonResult getSignup(
            @ApiParam(value = "비밀번호", required = true)
            @RequestParam String password,
            @ApiParam(value = "이름", required = true)
            @RequestParam String name,
            @ApiParam(value = "이메일", required = true)
            @RequestParam String email) {

        userRepository.save(UserModel.builder()
                .name(name)
                .password(passwordEncoder.encode(password))
                .email(email)
                .roles(Collections.singletonList("ROLE_USER"))
                .build());

        return responseService.getSuccessResult();
    }

    @ApiOperation(value = "로그인", notes = "로그인")
    @GetMapping(value = "v1/signin")
    public SingleResult<Object> signin(@ApiParam(value = "이메일", required = true)
                                       @RequestParam String email,
                                       @ApiParam(value = "비밀번호", required = true)
                                       @RequestParam String password) {

        UserModel userModel = userRepository.findByEmail(email).orElseThrow(CustomEmailSigninFailedException::new);

        if (!passwordEncoder.matches(password, userModel.getPassword())) {
            throw new CustomEmailSigninFailedException();
        }

        return responseService.getSingleResult(userModel);
    }
}
