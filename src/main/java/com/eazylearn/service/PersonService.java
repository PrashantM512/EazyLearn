package com.eazylearn.service;

import com.eazylearn.constants.EazyLearnConstants;
import com.eazylearn.model.Person;
import com.eazylearn.model.Roles;
import com.eazylearn.repository.PersonRepository;
import com.eazylearn.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
 
	 @Autowired
     private PasswordEncoder passwordEncoder;
	
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EazyLearnConstants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}
