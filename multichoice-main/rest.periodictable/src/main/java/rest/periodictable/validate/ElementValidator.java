/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.periodictable.validate;

/**
 *
 * @author mnqobi
 */
public class ElementValidator {
    public static boolean validateSymbol(String element, String symbol){
        element = element.toLowerCase().replaceAll("[^"+ symbol.toLowerCase() +"]", "");
        return element.contains(symbol.toLowerCase());
    }
}
