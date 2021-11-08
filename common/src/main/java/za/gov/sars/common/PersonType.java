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
public enum PersonType {

    SYSTEM_USER("System User"),
    EMPLOYEE("Employee"),
    LEARNER("Learner");

    private final String displayAddress;

    private PersonType(String displayAddress) {
        this.displayAddress = displayAddress;
    }

    @Override
    public String toString() {
        return this.displayAddress;
    }
}
