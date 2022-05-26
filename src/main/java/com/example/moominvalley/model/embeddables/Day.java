package com.example.moominvalley.model.embeddables;

import com.example.moominvalley.model.entites.Para;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Day {
    private List<Para> listParas;
}
