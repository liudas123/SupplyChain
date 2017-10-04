/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplychain;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author liudas
 */
public class calculations {
   
    dataExtractor data = new dataExtractor();
    ArrayList<dataExtractor> supplyArray;
    ArrayList<dataExtractor> supply = data.getData();
    

    
   
    
    int countneg4neg4 = 0;
    int countneg4neg3 = 0;
    int countneg4neg2 = 0;
    int countneg4neg1 = 0;
    int countneg4neg0 = 0;
    int countneg4pos1 = 0;
    int countneg4pos2 = 0;
    int countneg4pos3 = 0;
    int countneg3neg4 = 0;
    int countneg3neg3 = 0;
    int countneg3neg2 = 0;
    int countneg3neg1 = 0;
    int countneg3neg0 = 0;
    int countneg3pos1 = 0;
    int countneg3pos2 = 0;
    int countneg3pos3 = 0;
    int countneg2neg4 = 0;
    int countneg2neg3 = 0;
    int countneg2neg2 = 0;
    int countneg2neg1 = 0;
    int countneg2neg0 = 0;
    int countneg2pos1 = 0;
    int countneg2pos2 = 0;
    int countneg2pos3 = 0;
    int countneg1neg4 = 0;
    int countneg1neg3 = 0;
    int countneg1neg2 = 0;
    int countneg1neg1 = 0;
    int countneg1neg0 = 0;
    int countneg1pos1 = 0;
    int countneg1pos2 = 0;
    int countneg1pos3 = 0;
    int countneg0neg4 = 0;
    int countneg0neg3 = 0;
    int countneg0neg2 = 0;
    int countneg0neg1 = 0;
    int countneg0neg0 = 0;
    int countneg0pos1 = 0;
    int countneg0pos2 = 0;
    int countneg0pos3 = 0;
    int countpos1neg4 = 0;
    int countpos1neg3 = 0;
    int countpos1neg2 = 0;
    int countpos1neg1 = 0;
    int countpos1neg0 = 0;
    int countpos1pos1 = 0;
    int countpos1pos2 = 0;
    int countpos1pos3 = 0;
    int countpos2neg4 = 0;
    int countpos2neg3 = 0;
    int countpos2neg2 = 0;
    int countpos2neg1 = 0;
    int countpos2neg0 = 0;
    int countpos2pos1 = 0;
    int countpos2pos2 = 0;
    int countpos2pos3 = 0;
    int countpos3neg4 = 0;
    int countpos3neg3 = 0;
    int countpos3neg2 = 0;
    int countpos3neg1 = 0;
    int countpos3neg0 = 0;
    int countpos3pos1 = 0;
    int countpos3pos2 = 0;
    int countpos3pos3 = 0;
    
    
    //still need to reshuffle excel into chrnological order
    
    ArrayList<dataExtractor> specificSupplier = new ArrayList<dataExtractor>();
    int i = 0;

    public calculations() throws IOException {
        this.supplyArray = data.readFromFile();
    }
    public ArrayList<Double> supplierNamesList()
    {
        ArrayList<Double> supplierNames = new ArrayList();
        for(int i = 0; i< supplyArray.size(); i++)
        {
            if (!supplierNames.contains(supplyArray.get(i).getSupplierName()) || supplierNames == null)
            {
                supplierNames.add(supplyArray.get(i).getSupplierName());
            }
        }
        return supplierNames;
    }
    
    public ArrayList<dataExtractor> arrayOneSupplier(Double aSupplierName) throws IOException
    {
        {
        for(int i = 0; i< supplyArray.size(); i++)
        {
            if ( supplyArray.get(i).getSupplierName() == aSupplierName)
            {
                specificSupplier.add(supplyArray.get(i));
                
            }
        }
    }
   
        //use a <Comparator>
      Collections.sort(specificSupplier, (p1, p2) ->(int) p1.getOrderDate() - (int) p2.getOrderDate());
        return specificSupplier;
    }
    public void print()
    {
        for(int i = 0; i<specificSupplier.size(); i++)
        {
            System.out.println(specificSupplier.get(i).getLate());
        }
    }
    
   
   

    public void createMatrix(Double aName) throws IOException
    {
       ArrayList<dataExtractor> temp = arrayOneSupplier(aName);
       for(int j = 0; j<=temp.size()-1; j++)
        {
            if(aName == temp.get(j).getLate())
            {
                if(temp.get(j).getLate()<=-4)
                {
                    //j+1 will only work if the next supplier has the same name
                    if(temp.get(j+1).getLate()<=-4)
                    {
                        countneg4neg4++;
                    }
                    else if(temp.get(j+1).getLate()==-3)
                    {
                        countneg4neg3++;
                    }
                    else if(temp.get(j+1).getLate()==-2)
                    {
                        countneg4neg2++;
                    }
                    else if(temp.get(j+1).getLate()==-1)
                    {
                        countneg4neg1++;
                    }
                    else if(temp.get(j+1).getLate()==0)
                    {
                        countneg4neg0++;
                    }
                    else if(temp.get(j+1).getLate()==1)
                    {
                        countneg4pos1++;
                    }
                    else if(temp.get(j+1).getLate()==2)
                    {
                        countneg4pos2++;
                    }
                    else
                    {
                        countneg4pos3++;
                    }
                }
                else if(data.readFromFile().get(j).getLate()==-3)
                 {
                     if(temp.get(j+1).getLate()<=-4)
                    {
                        countneg3neg4++;
                    }
                    else if(temp.get(j+1).getLate()==-3)
                    {
                        countneg3neg3++;
                    }
                    else if(temp.get(j+1).getLate()==-2)
                    {
                        countneg3neg2++;
                    }
                    else if(temp.get(j+1).getLate()==-1)
                    {
                        countneg3neg1++;
                    }
                    else if(temp.get(j+1).getLate()==0)
                    {
                        countneg3neg0++;
                    }
                    else if(temp.get(j+1).getLate()==1)
                    {
                        countneg3pos1++;
                    }
                    else if(temp.get(j+1).getLate()==2)
                    {
                        countneg3pos2++;
                    }
                    else
                    {
                        countneg3pos3++;
                    }
                }
                else if(data.readFromFile().get(j).getLate()==-2)
                 {
                     if(temp.get(j+1).getLate()<=-4)
                    {
                        countneg2neg4++;
                    }
                    else if(temp.get(j+1).getLate()==-3)
                    {
                        countneg2neg3++;
                    }
                    else if(temp.get(j+1).getLate()==-2)
                    {
                        countneg2neg2++;
                    }
                    else if(temp.get(j+1).getLate()==-1)
                    {
                        countneg2neg1++;
                    }
                    else if(temp.get(j+1).getLate()==0)
                    {
                        countneg2neg0++;
                    }
                    else if(temp.get(j+1).getLate()==1)
                    {
                        countneg2pos1++;
                    }
                    else if(temp.get(j+1).getLate()==2)
                    {
                        countneg2pos2++;
                    }
                    else
                    {
                        countneg2pos3++;
                    }
                }
                else if(data.readFromFile().get(j).getLate()==-1)
                 {
                     if(temp.get(j+1).getLate()<=-4)
                    {
                        countneg1neg4++;
                    }
                    else if(temp.get(j+1).getLate()==-3)
                    {
                        countneg1neg3++;
                    }
                    else if(temp.get(j+1).getLate()==-2)
                    {
                        countneg1neg2++;
                    }
                    else if(temp.get(j+1).getLate()==-1)
                    {
                        countneg1neg1++;
                    }
                    else if(temp.get(j+1).getLate()==0)
                    {
                        countneg1neg0++;
                    }
                    else if(temp.get(j+1).getLate()==1)
                    {
                        countneg1pos1++;
                    }
                    else if(temp.get(j+1).getLate()==2)
                    {
                        countneg1pos2++;
                    }
                    else
                    {
                        countneg1pos3++;
                    }
                }
                else if(data.readFromFile().get(j).getLate()==0)
                 {
                     if(temp.get(j+1).getLate()<=-4)
                    {
                        countneg0neg4++;
                    }
                    else if(temp.get(j+1).getLate()==-3)
                    {
                        countneg0neg3++;
                    }
                    else if(temp.get(j+1).getLate()==-2)
                    {
                        countneg0neg2++;
                    }
                    else if(temp.get(j+1).getLate()==-1)
                    {
                        countneg0neg1++;
                    }
                    else if(temp.get(j+1).getLate()==0)
                    {
                        countneg0neg0++;
                    }
                    else if(temp.get(j+1).getLate()==1)
                    {
                        countneg0pos1++;
                    }
                    else if(temp.get(j+1).getLate()==2)
                    {
                        countneg0pos2++;
                    }
                    else
                    {
                        countneg0pos3++;
                    }
                }
                else if(data.readFromFile().get(j).getLate()==1)
                 {
                     if(temp.get(j+1).getLate()<=-4)
                    {
                        countpos1neg4++;
                    }
                    else if(temp.get(j+1).getLate()==-3)
                    {
                        countpos1neg3++;
                    }
                    else if(temp.get(j+1).getLate()==-2)
                    {
                        countpos1neg2++;
                    }
                    else if(temp.get(j+1).getLate()==-1)
                    {
                        countpos1neg1++;
                    }
                    else if(temp.get(j+1).getLate()==0)
                    {
                        countpos1neg0++;
                    }
                    else if(temp.get(j+1).getLate()==1)
                    {
                        countpos1pos1++;
                    }
                    else if(temp.get(j+1).getLate()==2)
                    {
                        countpos1pos2++;
                    }
                    else
                    {
                        countpos1pos3++;
                    }
                }
                 else if(data.readFromFile().get(j).getLate()==2)
                 {
                     if(temp.get(j+1).getLate()<=-4)
                    {
                        countpos2neg4++;
                    }
                    else if(temp.get(j+1).getLate()==-3)
                    {
                        countpos2neg3++;
                    }
                    else if(temp.get(j+1).getLate()==-2)
                    {
                        countpos2neg2++;
                    }
                    else if(temp.get(j+1).getLate()==-1)
                    {
                        countpos2neg1++;
                    }
                    else if(temp.get(j+1).getLate()==0)
                    {
                        countpos2neg0++;
                    }
                    else if(temp.get(j+1).getLate()==1)
                    {
                        countpos2pos1++;
                    }
                    else if(temp.get(j+1).getLate()==2)
                    {
                        countpos2pos2++;
                    }
                    else
                    {
                        countpos2pos3++;
                    }
                }
                 else 
                 {
                     if(temp.get(j+1).getLate()<=-4)
                    {
                        countpos3neg4++;
                    }
                    else if(temp.get(j+1).getLate()==-3)
                    {
                        countpos3neg3++;
                    }
                    else if(temp.get(j+1).getLate()==-2)
                    {
                        countpos3neg2++;
                    }
                    else if(temp.get(j+1).getLate()==-1)
                    {
                        countpos3neg1++;
                    }
                    else if(temp.get(j+1).getLate()==0)
                    {
                        countpos3neg0++;
                    }
                    else if(temp.get(j+1).getLate()==1)
                    {
                        countpos3pos1++;
                    }
                    else if(temp.get(j+1).getLate()==2)
                    {
                        countpos3pos2++;
                    }
                    else
                    {
                        countpos3pos3++;
                    }
                }
                 }
                
                    
                 
            }
        }
            
    }
    
    
    
    
    
   
    
   
    

