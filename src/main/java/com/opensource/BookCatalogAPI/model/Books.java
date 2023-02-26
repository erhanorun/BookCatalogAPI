package com.opensource.BookCatalogAPI.model;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.persistence.*;

@Table(name="books")
@Entity
@Data
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    private int isbn;

    @NotNull
    private Integer year;

}
