package com.example.codefellowship.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class ApplicationUser implements UserDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
 @Column(unique = true)
private String username;
private String password;
private String firstname;
private String lastname;
private String dateofbirth;
private String bio;

@OneToMany(mappedBy ="applicationUser")
private List<Post> posts;


@ManyToMany(cascade = {CascadeType.ALL})
@JoinTable(name = "FOLLOWER_FOLLOWING",
        joinColumns={@JoinColumn(name="FOLLOWER_ID")},
        inverseJoinColumns={@JoinColumn(name="FOLLOWING_ID")})
private Set<ApplicationUser> followers = new HashSet<>();

    @ManyToMany(mappedBy="followers")
    private Set<ApplicationUser> following = new HashSet<>();

    public ApplicationUser() {

    }

    public ApplicationUser(String username, String password, String firstname, String lastname, String dateofbirth, String bio) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.bio = bio;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public String getBio() {
        return bio;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Set<ApplicationUser> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<ApplicationUser> followers) {
        this.followers = followers;
    }

    public Set<ApplicationUser> getFollowing() {
        return following;
    }

    public void setFollowing(Set<ApplicationUser> following) {
        this.following = following;
    }
}
