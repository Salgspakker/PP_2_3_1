package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "age")
    private int age;

    public User() {

    }
    public User(int id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return this.lastName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.lastName + " " + this.age;
    }
}
