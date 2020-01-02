package org.hellchang;

import org.hellchang.model.UserModel;
import org.hellchang.security.SecurityConfig;
import org.hellchang.security.jwt.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {JwtTokenProvider.class, SecurityConfig.class})
@SpringBootTest
class HellchangApplicationTests {

    @Test
    void test() {
    }

}

