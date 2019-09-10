/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vijay.vendingmachine2;

/**
 *
 * @author Rites
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import vijay.vendingmachine2.VendingMachine;
import vijay.vendingmachine2.App;
import vijay.vendingmachine2.Item;
import java.util.List;



public class AppTest  {
    
 
    private static final String SEED = "seedfile.txt";
    private static final String PATH= "testvend.txt";
    VendingMachine v = new VendingMachine (PATH);
    
    
    
   
   
    public static void setUp() throws FileNotFoundException, IOException{
        Files.copy(Path.of(SEED), Path.of(PATH), StandardCopyOption.REPLACE_EXISTING);
       
        
    }
   
   
    public static void Exit(){
       
    }

    // ===================================================== //
    
    
    public void testBuyItemWithExactPrice() {
        
                                     
    }
   
   
    
    public void testBuyItemWithMorePrice(){
       
       
    }  
  
   

   

    public void testSoldOut(){
        for (int i = 0; i < 5; i++) {
            
            
        }
     
    }
   
   
    public void testNotSufficientChangeException(){
        for (int i = 0; i < 5; i++) {
           
        }
    }
   
   
  
    public void testExit(){
     
       
    }
   
   
}
