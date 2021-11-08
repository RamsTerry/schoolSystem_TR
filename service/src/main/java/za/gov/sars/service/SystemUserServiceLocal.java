/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.service;

import java.util.List;
import za.gov.sars.domain.SystemUser;

/**
 *
 * @author S2028398
 */
public interface SystemUserServiceLocal {

    SystemUser login(String username);

    SystemUser save(SystemUser systemUser);

    SystemUser findById(Long id);

    SystemUser update(SystemUser systemUser);

    void deleteAll();

    SystemUser deleteById(Long id);

    SystemUser findSystemUserByIdentifier(String identifier);

    List<SystemUser> listAll();

    boolean isExist(SystemUser systemUser);

    long count();
}
