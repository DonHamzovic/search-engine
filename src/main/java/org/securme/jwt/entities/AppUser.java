package org.securme.jwt.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles =new ArrayList<>();

    @JsonIgnore
    public String getPassword() {
        return password;
    }
    @JsonSetter
    public void setPassword(String password) {
        this.password = password;
    }
}
