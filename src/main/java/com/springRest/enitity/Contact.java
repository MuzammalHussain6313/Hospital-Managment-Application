package com.springRest.enitity;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact
{
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int Id;
    @Column(name = "name")
    private String name;
    @Column(name = "message")
    private String message;
    @Column(name = "email")
    private String email;

    public Contact()
    {
    }

    public Contact(String message, String email)
    {
        this.message = message;
        this.email = email;
    }

    public int getId()
    {
        return Id;
    }

    public void setId(int id)
    {
        Id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "Contact{" +
                "Id=" + Id +
                ", message='" + message + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
