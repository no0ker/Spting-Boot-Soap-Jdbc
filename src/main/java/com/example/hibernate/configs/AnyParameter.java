package com.example.hibernate.configs;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "parameters")
public class AnyParameter
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    enum Values
    {
        value1, value2, value4
    }

    @NotNull
    private Values value1;
}
