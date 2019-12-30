package org.hellchang.repository;

import org.hellchang.model.UserModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void cleanup() {
        userRepository.deleteAll();
    }

    @Test
    public void 회원_등록_목록() {

        //given
        String name = "halfdev";
        String password = "1234";
        String email = "halfdev@gmail.com";
        String role = "ROLE_USER";

        userRepository.save(UserModel.builder()
                .name(name)
                .password(password)
                .email(email)
                .roles(Collections.singletonList(role))
                .build());

        //when
        List<UserModel> userModelList = userRepository.findAll();

        //then
        UserModel userModel = userModelList.get(0);
        assertThat(userModel.getName()).isEqualTo(name);
        assertThat(userModel.getPassword()).isEqualTo(password);
        assertThat(userModel.getEmail()).isEqualTo(email);

    }
}
