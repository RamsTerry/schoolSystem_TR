/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.mb;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;
import za.gov.sars.common.EmployeeType;
import za.gov.sars.common.PersonType;
import za.gov.sars.common.SystemUserStatus;
import za.gov.sars.common.SystemUserType;
import za.gov.sars.domain.Employee;
import za.gov.sars.domain.SystemUser;
import za.gov.sars.service.EmployeeServiceLocal;
import za.gov.sars.service.StudentServiceLocal;
import za.gov.sars.service.SystemUserServiceLocal;

/**
 *
 * @author S2028398
 */
@ManagedBean
@RequestScope
public class LoginBean extends BaseBean {

    @Autowired //to be able to allow the communication in between
    private SystemUserServiceLocal systemUserService;
    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private StudentServiceLocal studentService;

    private String username;
    private String password;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

    private boolean loggedIn;
    private boolean loginPanel;
    private boolean changePasswordPanel;
    private boolean resetPasswordPanel;

    private static final String LOGIN_PAGE = "/login.xhml";

    private SystemUser systemUser;

    @PostConstruct
    public void init() {
        setLoginPanel(true);
        setChangePasswordPanel(false);
        setResetPasswordPanel(false);
        setLoggedIn(false);
    }

    public String doLogin(String username, String password) {
        if (isValidUser(username, password)) {
            getActiveUser().setUserLoginIndicator(Boolean.TRUE);
            systemUser = systemUserService.login(username);
            if (systemUser.getSystemUserType().equals(SystemUserType.SYSTEM_ADMIN)) {
                getActiveUser().setModuleWelcomeMessage("Welcome To Admin Console");
                return "/secured/landing.xhtml?faces-redirect=true";
            } else if (systemUser.getSystemUserType().equals(SystemUserType.LEARNER)) {
                getActiveUser().setModuleWelcomeMessage("Welcome To Student Console");
                return "/secured/landing.xhtml?faces-redirect=true";
            } else if (systemUser.getSystemUserType().equals(SystemUserType.EMPLOYEE)) {
                getActiveUser().setModuleWelcomeMessage("Welcome To Employee Console");
                return "/secured/landing.xhtml?faces-redirect=true";
            }

        }
        return "/accessdenied.xhtml?faces-redirect=true";
    }

    public void doLogout() {
        invalidateSession().redirect(LOGIN_PAGE);
    }

    public boolean isValidUser(String username, String password) {
        SystemUser user = systemUserService.login(username);

        if (user == null) {
            return false;
        }
        Employee emp = employeeService.findEmployeeByEmployeeNum(user.getIdentifier());
        if (user.getPersonType().equals(PersonType.SYSTEM_USER)) {
            if (user.getSystemUserType().equals(SystemUserType.EMPLOYEE)) {
                if (emp.getEmployeeType().equals(EmployeeType.GENERAL_WORKER)) {
                    return false;
                } else if (emp.getEmployeeType().equals(EmployeeType.CLERK)) {
                    return false;
                }

            }
        }

        if (user.getSystemUserStatus().equals(SystemUserStatus.INACTIVE)) {
            return false;
        } else if (user.getSystemUserStatus().equals(SystemUserStatus.SUSPENDEND)) {
            return false;
        }

        if (!password.equals(user.getPassword())) {
            return false;
        }

        if (password.equals(user.getPassword()) && username.equals(user.getUsername())) {
            getActiveUser().setUsername(user.getUsername());
            getActiveUser().setPersonType(user.getPersonType());

            StringBuilder userDisplayName = new StringBuilder("[");
            userDisplayName.append(" ");
            userDisplayName.append(user.getFirstName());
            userDisplayName.append(" ");
            userDisplayName.append(user.getLastName());
            userDisplayName.append(" ");
            userDisplayName.append("]");

            getActiveUser().setDisplayName(userDisplayName);

            getActiveUser().setFirstName(user.getFirstName());
            getActiveUser().setIdentifier(user.getIdentifier());
            getActiveUser().setLastName(user.getLastName());
            getActiveUser().setSystemUserType(user.getSystemUserType());
            getActiveUser().setActiveStatus(user.getSystemUserStatus());
            getActiveUser().setUserLoginIndicator(Boolean.TRUE);

            getActiveUser().resetRole(false);
            if (user.getPersonType().equals(PersonType.SYSTEM_USER)) {
                if (user.getSystemUserType().equals(SystemUserType.EMPLOYEE)) {
                    if (emp.getEmployeeType().equals(EmployeeType.ADMIN)) {
                        getActiveUser().setOfficeAdmin(true);
                    } else if (emp.getEmployeeType().equals(EmployeeType.EDUCATOR)) {
                        getActiveUser().setEducator(true);
                    } else if (emp.getEmployeeType().equals(EmployeeType.HOD)) {
                        getActiveUser().setHeadOfDepartment(true);
                    } else if (emp.getEmployeeType().equals(EmployeeType.PRINCIPAL)) {
                        getActiveUser().setPrincipal(true);
                    }

                } else if (user.getSystemUserType().equals(SystemUserType.SYSTEM_ADMIN)) {
                    getActiveUser().setSystemAdmin(true);
                } else if (user.getSystemUserType().equals(SystemUserType.LEARNER)) {
                    getActiveUser().setLearner(true);
                }
                return true;
            }
        }
        return false;
    }

    public void redirectToLogin() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

        try {
            externalContext.redirect(LOGIN_PAGE);
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isLoginPanel() {
        return loginPanel;
    }

    public void setLoginPanel(boolean loginPanel) {
        this.loginPanel = loginPanel;
    }

    public boolean isChangePasswordPanel() {
        return changePasswordPanel;
    }

    public void setChangePasswordPanel(boolean changePasswordPanel) {
        this.changePasswordPanel = changePasswordPanel;
    }

    public boolean isResetPasswordPanel() {
        return resetPasswordPanel;
    }

    public void setResetPasswordPanel(boolean resetPasswordPanel) {
        this.resetPasswordPanel = resetPasswordPanel;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

}
