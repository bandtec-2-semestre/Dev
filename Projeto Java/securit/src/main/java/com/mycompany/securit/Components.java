package com.mycompany.securit;

import java.util.Random;
import java.awt.Color;

public class Components {
    Random sorteio = new Random();
    private Integer cpu = sorteio.nextInt(100);
    private Integer memory = sorteio.nextInt(100);
    private Integer disk = sorteio.nextInt(100);
    
    public Integer getCPU(){
        return cpu = sorteio.nextInt(100);
    }
    
    public Integer setCPU(Integer cpu){
        return 1;
    }
    
    public Integer getMemory(){
        return memory = sorteio.nextInt(100);
    }
    
    public Integer setMemory(Integer memory){
        return 1;
    }
    
    public Integer getDisk(){
        return disk = sorteio.nextInt(100);
    }
    
    public Integer setDisk(Integer disk){
        return 1;
    }
    
    public Color validateCPU(Integer cpu){
        if(cpu > 85){
            return Color.red;
        } else {
            return Color.BLACK;
        }
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
