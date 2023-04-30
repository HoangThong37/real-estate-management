package com.laptrinhjavaweb.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRoleEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="role_id", nullable=false) //cart_id chính là truong khoá phu trong table Item liên k?t v?i khóa chính trong table Cart
    private RoleEntity role;


    @ManyToOne
    @JoinColumn(name="user_id", nullable=false) //cart_id chính là truong khoá phu trong table Item liên k?t v?i khóa chính trong table Cart
    private UserEntity user;

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }


}
