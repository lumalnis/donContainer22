package com.donContainer.web.auth.entity;

import com.donContainer.web.auth.enums.ApplicationRole;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE users SET soft_deleted=true WHERE id=?")
//@Where(clause = "soft_deleted=false")
@Entity
@Table(name = "user")
public class Userx {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String username; //EMAIL

    private String password;

    private ApplicationRole role; //por default user

    @CreationTimestamp
    @Column(name = "TIMESTAMP")
    private Timestamp timestamp;


//    @Column(name = "SOFT_DELETED")
//    private boolean softDeleted;
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return !this.softDeleted;
//    }
}
