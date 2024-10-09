/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expenses.models.module;

/**
 *
 * @author Samuel
 */
public class Expense {
    public int userId;
    public String description;
    public float amount;    
    
    public Expense(int _userId, 
                String _description,
                float _amount)
    {
        this.userId = _userId;
        this.description = _description;
        this.amount = _amount;        
    }
}
