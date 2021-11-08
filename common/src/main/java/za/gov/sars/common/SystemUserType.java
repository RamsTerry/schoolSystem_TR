/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.common;

/**
 *
 * @author S2028398
 */
public enum SystemUserType {

    SYSTEM_ADMIN("System Admin"),
    EMPLOYEE("Employee"),
    LEARNER("Learner");

    private final String displayName;

    private SystemUserType(final String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
