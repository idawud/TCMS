package io.turntabl;

import io.turntabl.dataaccess.DataAccess;
import io.turntabl.menu.AnsiConsole;

import java.io.IOException;
import java.sql.SQLException;

public class BGThread {
    private DataAccess dataAccess = new DataAccess();

    public void operation(int option) throws SQLException, ClassNotFoundException, IOException {
        switch (option){
            case 1:
                dataAccess.entry();
                break;
            case 2:
                dataAccess.showAllClientsRecords();
                break;
            case 3:
                dataAccess.showSearchedClientsRecords();
                break;
            case 4:
                dataAccess.deleteClientRecord();
                break;
            case 5:
                dataAccess.recoverDeleteClientRecord();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println( AnsiConsole.RED + "\nYou Entered an InCorrect Option!" + AnsiConsole.RESET);
        }
    }
}
