package de.htmlfit.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class ProgramUser  {
 
    @Id
    @GeneratedValue()
    @Column(name="USER_ID")
    private long id;
 
    @NotEmpty(message = "username is required")
    @Column(unique = true)
    private String username;
 
    @NotEmpty(message = "password is required")
    private String password;
 
     
    public ProgramUser() {}
 
    public ProgramUser(String userName, String password) {
        this.username = userName;
        this.password = password;
        
       
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    @OneToMany
	@JoinTable(
	          name="BodyBuildExercises",
	          joinColumns = @JoinColumn( name="USER_ID"),
	          inverseJoinColumns = @JoinColumn( name="TRAININGDAY_ID"))
	private Collection<TrainingDay> trainingDays;


	
	
      	
}