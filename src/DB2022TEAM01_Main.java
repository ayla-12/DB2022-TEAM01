import DAO.DB2022TEAM01_LogInDAO;
import GUI.DB2022TEAM01_LogIn;

public class DB2022TEAM01_Main {

    public static void main(String args[]){

        DB2022TEAM01_LogInDAO logInFunc = new DB2022TEAM01_LogInDAO();
        logInFunc.Start();

        new DB2022TEAM01_LogIn();
    }


}
