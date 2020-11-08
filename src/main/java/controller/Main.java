/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import model.Moon;
import model.PhaseException;
import view.View;

/**
 * Main class is responsible to manage a whole software
 *
 *
 * @author Szymon Godziński
 * @version 1.0
 */
public class Main {

    /**
     * Start a entire program by calling a function named process
     *
     * @param args first arg = year, second = month, third = day
     */
    public static void main(String args[]) {
        new Main().process(args);
    }

    /**
     * Processes the entire program
     *
     * @param args date provided by function named main
     */
    private void process(String args[]) {

        /**
         * Object view represents View class to show information for user
         */
        View view = new View();
        view.showWelcomeInfo();

        LocalDate date = getDateFromUser(args, view);
        if (date == null) {
            return;
        }

        /**
         * Object moon represents Moon class to calculate phase of moon
         */
        Moon moon = new Moon();
        double phase = 0;

        try {
            phase = moon.calculatePhaseOfMoon(date);
        } catch (PhaseException ex) {
            view.showErrorInfo();
            return;
        }

        view.showPhaseOfMoon(phase);
    }

    /**
     * Check if pDate is date, if pDate is date processes her to LocalDate
     * object, if pDate isn't date program get date from user and return
     * LocalDate object
     *
     * @param pDate Date as string array
     * @param view View responsible for show information for user
     * @return LocalDate object selected by user
     */
    private LocalDate getDateFromUser(String[] pDate, View view) {

        /**
         * Array of string represents date,index 0=year 1=month 2=day
         */
        String[] dateAsStringArray = pDate;
        /**
         * Object localDate represents processes date
         */
        LocalDate localDate;
        /**
         * Object represent date get from user by widget
         */
        String dateString = "";
        try {
            if (dateAsStringArray.length < 3) {
                dateString = view.showInputDialogToGetDate();
                dateAsStringArray = dateString.split(" ");
            }

            if (ifUserClickCancelOrExit(dateString)) {
                return null;
            }

            int day, month, year;
            year = Integer.parseInt(dateAsStringArray[0]);
            month = Integer.parseInt(dateAsStringArray[1]);
            day = Integer.parseInt(dateAsStringArray[2]);

            localDate = LocalDate.of(year, month, day);

        } catch (Exception ex) {
            dateAsStringArray = new String[0];
            localDate = getDateFromUser(dateAsStringArray, view);
        }

        return localDate;
    }

    /**
     * Check if user click cancel or exit in widget
     *
     * @param responseFromInputDialog Response from widget
     * @return true if user click cancel or exit, if user does not click, it
     * returns false
     */
    private boolean ifUserClickCancelOrExit(String responseFromInputDialog) {
        return responseFromInputDialog == null;
    }
}
