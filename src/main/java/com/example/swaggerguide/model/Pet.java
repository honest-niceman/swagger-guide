package com.example.swaggerguide.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name")
    private String name;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "pet_id")
    private Set<Tag> tags = new LinkedHashSet<>();

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "pet_id")
    private Set<Visit> visits = new LinkedHashSet<>();

    public Set<Visit> getVisits() {return visits;}

    public void setVisits(Set<Visit> visits) {this.visits = visits;}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Set<Tag> getTags() {return tags;}

    public void setTags(Set<Tag> tags) {this.tags = tags;}

}