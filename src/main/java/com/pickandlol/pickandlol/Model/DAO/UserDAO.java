package com.pickandlol.pickandlol.Model.DAO;

import com.pickandlol.pickandlol.Model.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDAO {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginId;
    private String password;
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    // provider : google이 들어감
    private String provider;

    // providerId : 구굴 로그인 한 유저의 고유 ID가 들어감
    private String providerId;

}
