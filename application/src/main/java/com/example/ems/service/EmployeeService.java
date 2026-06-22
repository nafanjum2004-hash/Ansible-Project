package com.example.ems.service;

import com.example.ems.model.Employee;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final List<Employee> employees = new CopyOnWriteArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @PostConstruct
public void init() {

    save(new Employee(null, "Aarav", "Sharma", "aarav.sharma@example.com", "Engineering", "Software Engineer", LocalDate.now().minusYears(2)));

    save(new Employee(null, "Priya", "Verma", "priya.verma@example.com", "HR", "HR Manager", LocalDate.now().minusMonths(18)));

    save(new Employee(null, "Rahul", "Gupta", "rahul.gupta@example.com", "Finance", "Financial Analyst", LocalDate.now().minusMonths(12)));

    save(new Employee(null, "Sneha", "Patel", "sneha.patel@example.com", "Marketing", "Marketing Executive", LocalDate.now().minusMonths(8)));

    save(new Employee(null, "Vikram", "Singh", "vikram.singh@example.com", "Engineering", "Senior Developer", LocalDate.now().minusYears(1)));

    save(new Employee(null, "Ananya", "Reddy", "ananya.reddy@example.com", "Operations", "Operations Lead", LocalDate.now().minusMonths(10)));

    save(new Employee(null, "Rohan", "Mehta", "rohan.mehta@example.com", "Sales", "Sales Executive", LocalDate.now().minusMonths(5)));

    save(new Employee(null, "Kavya", "Nair", "kavya.nair@example.com", "Marketing", "Content Specialist", LocalDate.now().minusMonths(7)));

    save(new Employee(null, "Arjun", "Yadav", "arjun.yadav@example.com", "Engineering", "DevOps Engineer", LocalDate.now().minusYears(3)));

    save(new Employee(null, "Pooja", "Kulkarni", "pooja.kulkarni@example.com", "Administration", "Administrator", LocalDate.now().minusMonths(15)));
}
    public List<Employee> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(employees));
    }

    public Optional<Employee> findById(Long id) {
        return employees.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(idCounter.getAndIncrement());
            employees.add(employee);
        } else {
            // update
            delete(employee.getId());
            employees.add(employee);
        }
        return employee;
    }

    public boolean delete(Long id) {
        return employees.removeIf(e -> e.getId().equals(id));
    }

    public long count() {
        return employees.size();
    }

    public List<Employee> search(String query) {
        if (query == null || query.trim().isEmpty()) return findAll();
        String q = query.toLowerCase().trim();
        return employees.stream()
                .filter(e -> (e.getFirstName() + " " + e.getLastName()).toLowerCase().contains(q)
                        || e.getEmail().toLowerCase().contains(q)
                        || e.getDepartment().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public List<Employee> recent(int n) {
        List<Employee> copy = new ArrayList<>(employees);
        copy.sort((a, b) -> b.getJoiningDate().compareTo(a.getJoiningDate()));
        return copy.stream().limit(n).collect(Collectors.toList());
    }
}
