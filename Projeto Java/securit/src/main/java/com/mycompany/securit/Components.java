package com.mycompany.securit;

import java.awt.Color;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.HWDiskStore;

public class Components {
    
    SystemInfo si = new SystemInfo();
    private final HardwareAbstractionLayer hal = si.getHardware();
    private final HWDiskStore diskStore = new HWDiskStore();
    SlackMessage mensagem = new SlackMessage(
            "https://hooks.slack.com/services/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"
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
                    SlackEmoji.EmojiAttention());
            return Color.red;
        } else {
            return Color.BLACK;
        }
    }
    
    public Color validateMemory(Integer memory){
        if(memory > 85){
            mensagem.sendMessage(
                    String.format("Memória do sistema %d está em %d%% ", sistemaId, memory),
                    SlackEmoji.EmojiAttention());
            return Color.red;
        } else {
            return Color.BLACK;
        }
    }
    
    public Color validateDisk(Integer disk){
        if(disk > 85){
            mensagem.sendMessage(
                    String.format("Disco do sistema %d está em %d%% ", sistemaId, disk),
                    SlackEmoji.EmojiAttention());
            return Color.red;
        } else {
            return Color.BLACK;
        }
    }
}
