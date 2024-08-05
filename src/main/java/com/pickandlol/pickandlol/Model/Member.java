package com.pickandlol.pickandlol.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oauthId;

    private String name;

    private String email;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Setter
    private String accessToken;

    private String refreshToken;

    private boolean isDeleted;

    protected Member() {
    }

    public Member(String oauthId, String name, String email, String imageUrl, Role role) {
        this(null, oauthId, name, email, imageUrl, role);
    }

    public Member(Long id, String oauthId, String name, String email, String imageUrl, Role role) {
        this.id = id;
        this.oauthId = oauthId;
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
        this.role = role;
    }

    public Member update(String name, String email, String imageUrl) {
        if (name != null) {
            this.name = name;
        }
        if (email != null) {
            this.email = email;
        }
        if (imageUrl != null) {
            this.imageUrl = imageUrl;
        }
        return this;
    }

    public Member updateToken(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        return this;
    }

    public Member delete() {
        this.isDeleted = true;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
