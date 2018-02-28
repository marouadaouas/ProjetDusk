/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import static com.oracle.nio.BufferSecrets.instance;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Esprit1
 */
public class Panier {

   
   public static Panier instance;
    public List<Ligne_commande> p=new ArrayList();
    public Panier() {
    }

    public static Panier getInstance()
    {
        if(instance == null)
        {
            instance=new Panier();
        }
        return instance;
        
    }
    
    public void addLine(Ligne_commande c)
    {
        if(search(c)==false)
        {
            p.add(c);
        }
        else
        {
            for(Ligne_commande c1:p)
             {
               if(c1.equals(c))
                 {
                     c1.quantite++;
                 }
             }
        }
            
    }     
    public void removeLine(Ligne_commande c)
  {
      p.remove(c);
     
  }
    
    public void show()
    {
       
       for(Ligne_commande c:p)
       {
           System.out.println(c.toString());
       }
    }
    
    public boolean search(Ligne_commande c)
    {
     for(Ligne_commande c1:p)
       {
           if(c.equals(c1))
               return true;
       }
     return false;
    }
    
   
    
   
   
    
}
