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
public enum AttendenceStatus {

    AVAILABLE("Available"),
    CANCELLED("Canvelled"),
    SESSIONED("In Progress"),
    POSTPONED("Postponed"),;

    private final String displayAttendance;

    private AttendenceStatus(String displayAttendances) {
        this.displayAttendance = displayAttendances;
    }

    @Override
    public String toString() {
        return this.displayAttendance;
    }
}
