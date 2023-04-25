package com.vsks.immutable;

public class Student {

    private Long id;
    private String name;
    private String department;
    private Address address;

    public Student() {
    }

    private Student(Student st) {
        this.id = st.id;
        this.name = st.name;
        this.department = st.department;
        this.address = st.address;
    }

    public Long getId() {
        return id;
    }

    public Student setId(Long id) {
        Student st = new Student(this);
        st.setId(id);
        return st;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        Student st = new Student(this);
        st.setName(name);
        return st;
    }

    public String getDepartment() {
        return department;
    }

    public Student setDepartment(String department) {
        Student st = new Student(this);
        st.setDepartment(department);
        return st;
    }

    public Address getAddress() {
        return address;
    }

    public Student setAddress(Address address) {
        Student st = new Student(this);
        Address address1 = new Address(address);
        st.setAddress(address1);
        return st;
    }
}
