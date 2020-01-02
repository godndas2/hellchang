package org.hellchang.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hellchang.model.oauth.ProviderType;

import javax.persistence.*;

@Entity
@Table(name = "user_connection")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserConnection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "provider")
    @Enumerated(EnumType.STRING)
    private ProviderType provider;

    @Column(name = "provider_id", nullable = false)
    private String providerId;

    @Column(name = "profile_url")
    private String profileUrl;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "expire_time")
    private long expireTime;

    @Builder
    private UserConnection(String email, ProviderType provider, String providerId, String profileUrl, String imageUrl, String accessToken, long expireTime) {
        this.email = email;
        this.provider = provider;
        this.providerId = providerId;
        this.profileUrl = profileUrl;
        this.imageUrl = imageUrl;
        this.accessToken = accessToken;
        this.expireTime = expireTime;
    }

}
