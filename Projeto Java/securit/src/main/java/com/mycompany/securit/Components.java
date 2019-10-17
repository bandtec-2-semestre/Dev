package com.mycompany.securit;

import java.util.Random;
import java.awt.Color;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

public class Components {
    Random sorteio = new Random();
    SystemInfo si = new SystemInfo();
    private Integer soma = 0;
    private long[] cpu;
    
  
    public Integer getCPU(){
        //return cpu = sorteio.nextInt(100);
        return soma;
    }
    
    public Integer setCPU(Integer cpu){
        //return 1;
        return 0;
    }
    
    public Integer getMemory(){
        //return memory = sorteio.nextInt(100);
        return 0;
    }
    
    public Integer setMemory(Integer memory){
       //return 1;
        return 0;
    }
    
    public Integer getDisk(){
        //return disk = sorteio.nextInt(100);
        return 0;
    }
    
    public Integer setDisk(Integer disk){
        //return 1;
        return 0;
    }
    
    public Color validateCPU(Integer cpu){
        /* if(cpu > 85){
            return Color.red;
        } else {
            return Color.BLACK;
        } */
        return Color.BLACK;
    }
    
    public Color validateMemory(Integer memory){
        if(memory > 85){
            return Color.red;
        } else {
            return Color.BLACK;
        }
    }
    
    public Color validateDisk(Integer disk){
        if(disk > 85){
            return Color.red;
        } else {
            return Color.BLACK;
        }
    }
}
