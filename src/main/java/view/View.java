/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/**
 * Class View show user widget information provided by controller
 *
 * @author Szymon Godziński
 * @version 1.0
 */
public class View {

    /**
     * Show user welcome information
     */
    public void showWelcomeInfo() {
        JOptionPane.showMessageDialog(null,
                "Welcome in program Moon Phase, this program display "
                + "information about  phase of moon for selected day.",
                "Moon Phase", JOptionPane.NO_OPTION);
    }

    /**
     * Show user information when is error
     */
    public void showErrorInfo() {
        JOptionPane.showMessageDialog(null,
                "A huge system error has occurred,"
                + "the developer takes no responsibility for it.",
                "Moon Phase", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Show user widget with request about date and get date
     *
     * @return Date as String
     */
    public String showInputDialogToGetDate() {
        return JOptionPane.showInputDialog(null,
                "Write Date in format like below \n"
                + "YEAR MONTH DAY \nfor example \"2008 8 25\"",
                "MoonPhase", JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Show information in which phase of moon is moon in concrete day
     *
     * @param phase Earlier calculated phase of moon for moon in concrete day
     */
    public void showPhaseOfMoon(double phase) {

        /**
         * String represents phase of moon
         */
        String phaseString = "";

        if (phase < 0.125 || phase > 0.875) {
            phaseString = "new moon";
        } else if (phase < 0.375) {
            phaseString = "first quarter";
        } else if (phase < 0.625) {
            phaseString = "full";
        } else if (phase <= 0.875) {
            phaseString = "second quarter";
        }

        JOptionPane.showMessageDialog(null, "For this day moon will be "
                + phaseString, "Moon Phase ", 1);
    }
}
