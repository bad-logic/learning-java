package app.repositories;

import app.domain.company.Company;
import org.springframework.data.jpa.domain.Specification;

public class CompanySpecification {
    public static Specification<Company> withEmployeeNamed(String name){
        return (root,query,queryBuilder)-> queryBuilder.equal((root.get("employeeList")).get("name"),name);
    }
}
