package com.mycompany.securit;

import java.util.Random;
import java.awt.Color;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

public class Components {
    
    SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer hal = si.getHardware();
    long[] cpu = hal.getProcessor().getSystemCpuLoadTicks();
    
    
    public Double getCPU(){
        Double cpu = Teste.printCpu(this.hal.getProcessor());
        return cpu;
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
