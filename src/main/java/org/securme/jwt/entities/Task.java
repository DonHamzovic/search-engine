package org.securme.jwt.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Data  @AllArgsConstructor @NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue
    private long id;
    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }
}
