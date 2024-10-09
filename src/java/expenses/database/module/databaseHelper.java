/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expenses.database.module;

import expenses.models.module.Expense;
import expenses.models.module.User;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel
 */
public class databaseHelper {

    Connection conn;

    public databaseHelper() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/ExpensesDatabase", "root", "Admin$1234");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(databaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validateLogin(String txtEmail, String txtPwd) throws SQLException {
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM expensesdatabase.users WHERE email = '" + txtEmail + "' AND pwd = '" + txtPwd + "'";
        ResultSet resultset = statement.executeQuery(sql);
        while (resultset.next()) {
            return true;
        }
        return false;
    }

    public ResultSet getExpenses(int idUser) throws SQLException {
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM expensesdatabase.expenses WHERE idUser = " + idUser + "";
        ResultSet resultset = statement.executeQuery(sql);
        return resultset;
    }

    public boolean saveExpense(Expense expense) {
        try {
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO expenses (idUser, description, amount, creationDate) VALUES (" + expense.userId + ", '"
                    + expense.description + "', "
                    + expense.amount + ", CURDATE());";
            statement.executeUpdate(sql);

            return true;
        } catch (SQLException ex)  {
            return false;
        }
    }

    public User getUser(String email) throws SQLException {
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM expensesdatabase.users WHERE email = '" + email + "'";
        ResultSet resultset = statement.executeQuery(sql);
        while (resultset.next()) {
            User user = new User(
                    resultset.getInt("id"),
                    resultset.getString("lastname"),
                    resultset.getString("firstname"),
                    resultset.getString("email")
            );

            return user;
        }

        return null;
    }
}
