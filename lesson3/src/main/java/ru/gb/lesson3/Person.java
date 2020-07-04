package ru.gb.lesson3;

import java.util.Objects;

public class Person {
    private String lastName;
    private String phone;
    private String email;

    public Person(String lastName, String phone, String email){
        this.phone = phone;
        this.lastName = lastName;
        this.email = email.toLowerCase();
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(lastName, person.lastName) &&
                (Objects.equals(phone, person.phone) ||
                Objects.equals(email, person.email));
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, phone, email);
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
