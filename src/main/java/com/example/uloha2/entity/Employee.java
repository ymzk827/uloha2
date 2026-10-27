package com.example.uloha2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Meno je povinné")
    @Size(min = 2, max = 50, message = "Meno musí mať 2-50 znakov")
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @NotBlank(message = "Priezvisko je povinné")
    @Size(min = 2, max = 50, message = "Priezvisko musí mať 2-50 znakov")
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @NotBlank(message = "Email je povinný")
    @Email(message = "Neplatný formát emailu")
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
            message = "Email spĺňať medzinárodný štandard (napr. meno@domain.com)"
    )
    @Size(max = 100, message = "Email môže mať najviac 100 znakov")
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "Telefónne číslo je povinné")
    @Pattern(
            regexp = "^(\\+421|0)\\d{9}$",
            message = "Telefónne číslo musí mať správny formát"
    )
    @Column(name = "phone", length = 15)
    private String phone;

    @NotBlank(message = "Pracovná pozícia je povinná")
    @Size(max = 100, message = "Názov pozície môže mať najviac 100 znakov")
    @Column(name = "job_title")
    private String jobTitle;

    @NotNull(message = "Plat je povinný")
    @Min(value = 0, message = "Plat nemôže byť záporný")
    @Column(name = "salary")
    private Integer salary;

    @NotNull(message = "Úväzok je povinný")
    @Min(value = 0, message = "Hodnota fullTime musí byť 0 alebo 1")
    @Max(value = 1, message = "Hodnota fullTime musí byť 0 alebo 1")
    @Column(name = "full_time")
    private Integer fullTime;

    @NotNull(message = "Dátum narodenia je povinný")
    @Past(message = "Dátum narodenia musí byť v minulosti")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    public Employee() {}

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public Integer getSalary() { return salary; }
    public void setSalary(Integer salary) { this.salary = salary; }

    public Integer getFullTime() { return fullTime; }
    public void setFullTime(Integer fullTime) { this.fullTime = fullTime; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
}