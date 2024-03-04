/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

public class Method {
    
    public static boolean validateIdFormat(String id,String regex)
    {
        if (id == null || id.length() < 3) 
        {
            return false;
        }
        String modifiedRegex = regex + ".*";
        return id.matches(modifiedRegex);
    }
   
}
