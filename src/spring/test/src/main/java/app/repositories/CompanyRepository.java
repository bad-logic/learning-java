package app.repositories;

import app.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long>, JpaSpecificationExecutor<Company> {

    List<Company> findCompanyByName(String name);

    @Query("select distinct c.name from Company c join c.employeeList e where e.address.city=:city")
    List<String> getCompaniesNameFromCity(@Param("city") String city);
    @Query("select c.name from Company c where c.contact.phone=:phone")
    String getCompanyNameFromPhone(@Param("phone") String phone);
    @Query("select c from Company c join fetch c.employeeList e where e.name=:name")
    List<Company> getCompaniesWhereEmployeeWithGivenNameWorks(@Param("name") String name);
}
