/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expenses.models.module;

/**
 *
 * @author Samuel
 */
public class User {
    public int id;
    public String lastName;
    public String firstName;
    public String email;    
    
    public User(int _id, 
                String _lastName,
                String _firstName,
                String _email)
    {
        this.id = _id;
        this.lastName = _lastName;
        this.firstName = _firstName;
        this.email = _email;        
    }
}
