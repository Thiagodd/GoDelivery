package com.thiagodd.godelivery.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class User {

 @Id
 @EqualsAndHashCode.Include
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(nullable = false)
 private String name;

 @Column(nullable = false)
 private String email;

 @Column(nullable = false)
 private String password;

 @ManyToMany
 @JoinTable(name = "user_compilation", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "compilation_id"))
 private List<Group> Groups = new ArrayList<>();

    /*
     @JoinTable(name = "", joinColumns = @JoinColumn(name = ""), inverseJoinColumns = @JoinColumn(name = ""))
     */

 @JsonIgnore
 @CreationTimestamp
 @Column(nullable = false, columnDefinition = "datetime")
 private LocalDateTime creationTimestamp;

 @JsonIgnore
 @UpdateTimestamp()
 @Column(nullable = false, columnDefinition = "datetime")
 private LocalDateTime updateTimestamp;
}
