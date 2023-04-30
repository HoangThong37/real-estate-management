package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = -4988455421375043688L;

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone", unique = true)
    private String phone;

    // 1 user - n assignBuilding
    @OneToMany(mappedBy="user") //
    private Set<AssignBuildingEntity> buildings;

    // 1 user - n assignCustomer
    @OneToMany(mappedBy="user")
    private List<AssignCustomerEntity> customers;

    // 1 user - n role
    @OneToMany(mappedBy="user") //
    private Set<UserRoleEntity> userRoles;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id", nullable = false),
//            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
//    private List<RoleEntity> roles = new ArrayList<>();

    @ElementCollection()
    List<RoleEntity> roles = new ArrayList<>();

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public Set<UserRoleEntity> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRoleEntity> userRoles) {
        this.userRoles = userRoles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<AssignBuildingEntity> getBuildings() {
        return buildings;
    }

    public void setBuildings(Set<AssignBuildingEntity> buildings) {
        this.buildings = buildings;
    }

    public List<AssignCustomerEntity> getCustomers() {
        return customers;
    }

    public void setCustomers(List<AssignCustomerEntity> customers) {
        this.customers = customers;
    }



}
