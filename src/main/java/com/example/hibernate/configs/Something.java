package com.example.hibernate.configs;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Entity
@Table(name = "somethings")
public class Something
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String value1;

    @NotNull
    private BigInteger value2;

    public Something()
    {
    }

    public Something(long id)
    {
        this.id = id;
    }

    public Something(String value1, BigInteger value2)
    {
        this.value1 = value1;
        this.value2 = value2;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getValue1()
    {
        return value1;
    }

    public void setValue1(String value1)
    {
        this.value1 = value1;
    }

    public BigInteger getValue2()
    {
        return value2;
    }

    public void setValue2(BigInteger value2)
    {
        this.value2 = value2;
    }
}
