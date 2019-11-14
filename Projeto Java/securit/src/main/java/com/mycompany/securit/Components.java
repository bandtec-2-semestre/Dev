package com.mycompany.securit;

import java.awt.Color;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.HWDiskStore;

public class Components {
    
    SystemInfo si = new SystemInfo();
    private final HardwareAbstractionLayer hal = si.getHardware();
    private final HWDiskStore diskStore = new HWDiskStore();
    private final String hooksUrl = "https://hooks.slack.com/";
    private final String hooksMiddle = "services/TPZPZU71T";
    private final String hooksEnd = "/BQ7LZQJHH/uSwP6o1KPO1hVDLeELi2DxBw";
    
    SlackMessage mensagem = new SlackMessage(
            hooksUrl + hooksMiddle + hooksEnd
    );
    
    Integer sistemaId;
    
    
    public Components(Integer sistemaId){
        this.sistemaId = sistemaId;
    }
    
     public String getProcessorInfo() {
        return hal.getProcessor().getProcessorIdentifier().getName();
    }   
    
    public Integer getCPU(){
       return Sistema.getCPU(this.hal.getProcessor());
    }
    
    public Integer getMemory(){
       return Sistema.getMemory(this.hal.getMemory());
    }
    
    public Integer getDisk(){
       return Sistema.getDisk(this.diskStore);
    }
    
    public Color validateCPU(Integer cpu){
        if(cpu > 85){
            mensagem.sendMessage(
                    String.format("CPU do sistema %d está em %d%% ", sistemaId, cpu),
                    SlackEmoji.EMOJI_WARNING);
            return Color.red;
        } else {
            return Color.BLACK;
        }
    }
    
    public Color validateMemory(Integer memory){
        if(memory > 3){
            mensagem.sendMessage(
                    String.format("Memória do sistema %d está em %d%% ", sistemaId, memory),
                    SlackEmoji.EMOJI_ATTENTION);
            return Color.red;
        } else {
            return Color.BLACK;
        }
    }
    
    public Color validateDisk(Integer disk){
        if(disk > 85){
            mensagem.sendMessage(
                    String.format("Disco do sistema %d está em %d%% ", sistemaId, disk),
                    SlackEmoji.EMOJI_ATTENTION);
            return Color.red;
        } else {
            return Color.BLACK;
        }
    }
}
