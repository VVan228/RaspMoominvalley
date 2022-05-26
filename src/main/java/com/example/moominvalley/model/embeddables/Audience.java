package com.example.moominvalley.model.embeddables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class Audience {
    private String audienceName;
}
