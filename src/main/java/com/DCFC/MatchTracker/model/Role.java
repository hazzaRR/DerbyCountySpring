package com.DCFC.MatchTracker.model;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.*;


@Entity
@Table(name="roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name ="authority")
    private String authority;


    public Role() {

    }

    public Role(String authority) {

        this.authority = authority;
    }

    public Role(Integer roleId, String authority) {
        this.roleId = roleId;
        this.authority = authority;
    }

    @Override
    public String getAuthority() {

        return this.authority;
    }

    public void setAuthority (String authority) {
        this.authority = authority;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
