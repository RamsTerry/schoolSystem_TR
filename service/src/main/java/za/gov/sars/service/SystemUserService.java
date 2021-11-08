/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.gov.sars.domain.SystemUser;
import za.gov.sars.persistance.SystemUserRepository;

/**
 *
 * @author S2028398
 */
@Service
public class SystemUserService implements SystemUserServiceLocal {

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Override
    public SystemUser login(String username) {
        return systemUserRepository.searchByUsername(username);
    }

    @Override
    public SystemUser save(SystemUser systemUser) {
        return systemUserRepository.save(systemUser);
    }

    @Override
    public SystemUser findById(Long id) {
        return systemUserRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("The request id [" + id + "] does not exist."));
    }

    @Override
    public SystemUser update(SystemUser systemUser) {
        return systemUserRepository.save(systemUser);
    }

    @Override
    public void deleteAll() {
        systemUserRepository.deleteAll();
    }

    @Override
    public SystemUser deleteById(Long id) {
        SystemUser systemUser = findById(id);
        if (systemUser != null) {
            systemUserRepository.deleteById(id);
        }
        return systemUser;
    }

    @Override
    public SystemUser findSystemUserByIdentifier(String identifier) {
        return systemUserRepository.findSystemUserByIdentifier(identifier);
    }

    @Override
    public List<SystemUser> listAll() {
        return systemUserRepository.findAll();
    }

    @Override
    public boolean isExist(SystemUser systemUser) {
        return systemUserRepository.findById(systemUser.getId()) != null;
    }

    @Override
    public long count() {
        return systemUserRepository.count();
    }
}
