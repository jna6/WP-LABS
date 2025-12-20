package mk.ukim.finki.wp.kol2022.g1.service.impl;

import mk.ukim.finki.wp.kol2022.g1.model.Employee;
import mk.ukim.finki.wp.kol2022.g1.model.EmployeeType;
import mk.ukim.finki.wp.kol2022.g1.model.Skill;
import mk.ukim.finki.wp.kol2022.g1.model.exceptions.InvalidEmployeeIdException;
import mk.ukim.finki.wp.kol2022.g1.repository.EmployeeRepository;
import mk.ukim.finki.wp.kol2022.g1.service.EmployeeService;
import mk.ukim.finki.wp.kol2022.g1.service.SkillService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static mk.ukim.finki.wp.kol2022.g1.service.FieldFilterSpecification.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final SkillService skillService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, SkillService skillService) {
        this.employeeRepository = employeeRepository;
        this.skillService = skillService;
    }

    @Override
    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new InvalidEmployeeIdException(id));
    }

    @Override
    public Employee create(String name, String email, String password, EmployeeType type, List<Long> skillId, LocalDate employmentDate) {

        List<Skill> skills = skillId.stream()
                            .map(skillService::findById)
                            .collect(Collectors.toList());

        Employee employee = new Employee(name, email, password, type, skills, employmentDate);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, String name, String email, String password, EmployeeType type, List<Long> skillId, LocalDate employmentDate) {

        Employee employee = this.findById(id);

        List<Skill> skills = skillId.stream()
                .map(skill -> skillService.findById(skill))
                .collect(Collectors.toList());

        employee.setName(name);
        employee.setEmail(email);
        employee.setPassword(password);
        employee.setType(type);
        employee.setSkills(skills);
        employee.setEmploymentDate(employmentDate);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee delete(Long id) {
        Employee employee = this.findById(id);

        employeeRepository.delete(employee);

        return employee;
    }

    @Override
    public List<Employee> filter(Long skillId, Integer yearsOfService) {

        if(skillId==null && yearsOfService==null){
            return listAll();
        }
        else if(skillId!=null && yearsOfService!=null){
            Skill skill=this.skillService.findById(skillId);
            LocalDate years=LocalDate.now().minusYears(yearsOfService);
            return this.employeeRepository.findBySkillsContainsAndEmploymentDateBefore(skill,years);
        }
        else if(skillId!=null){
            Skill skill=this.skillService.findById(skillId);
            return this.employeeRepository.findBySkillsContains(skill);
        }
        else {
            LocalDate years=LocalDate.now().minusYears(yearsOfService);
            return this.employeeRepository.findByEmploymentDateBefore(years);
        }

    }

    @Override
    public Page<Employee> findPage(String name, EmployeeType employeeType, List<Long> skill, Integer pageNum, Integer pageSize) {
        Specification<Employee> specification = Specification
                .where(filterContainsText(Employee.class, "name", name))
                .and(filterEqualsV(Employee.class, "employeeType", employeeType));

        if(skill != null && !skill.isEmpty()){
            Specification<Employee> skillSpec =  skill.stream()
                    .map(skillID -> filterEquals(Employee.class, "skills.id", skillID))
                    .reduce(Specification::or)
                    .orElse(null);

            specification = specification.and(skillSpec);
        }

        return this.employeeRepository.findAll(
                specification,
                PageRequest.of(pageNum , pageSize)
        );
    }
}
