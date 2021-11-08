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
public enum GenderType {

    MALE("male"),
    FEMALE("female"),;

    private final String displayGender;

    private GenderType(String displayGenderType) {
        this.displayGender = displayGenderType;
    }

    @Override
    public String toString() {
        return this.displayGender;
    }
}
