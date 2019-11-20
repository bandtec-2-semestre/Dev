package securit.oshi;

import securit.slack.SlackEmoji;
import securit.slack.SlackMessage;
import java.awt.Color;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.HWDiskStore;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

public class Components {
    
    private final SystemInfo si;
    private final HardwareAbstractionLayer hal;
    private final HWDiskStore[] diskStore;
    private final OperatingSystem os;
    private final String hooksUrl;
    private final String hooksMiddle;
    private final String hooksEnd;
    private final SlackMessage mensagem;
    private String sistema;
    
    
    public Components(String sistema){
        this.sistema = sistema;
        this.si = new SystemInfo();
        this.hal = si.getHardware();
        this.os = si.getOperatingSystem();
        this.diskStore = this.hal.getDiskStores();
        
        this.hooksUrl = "https://hooks.slack.com/";
        this.hooksMiddle = "services/TPZPZU71T";
        this.hooksEnd = "/BQ7LZQJHH/uSwP6o1KPO1hVDLeELi2DxBw";
        
        this.mensagem = new SlackMessage(
            hooksUrl + hooksMiddle + hooksEnd
        );
    }
    
    public String getProcessorInfo() {
        return this.hal.getProcessor().getProcessorIdentifier().getName().split(" CPU")[0];
    }   
    
    public Integer getCPU(){
       return Sistema.getCPU(this.hal.getProcessor());
    }
    
      public String getProcessorMaxFreq() {
        return FormatUtil.formatHertz(this.hal.getProcessor().getMaxFreq());
    }   
    
    public String getUsedCpu() {
        long[] prevTicks =  this.hal.getProcessor().getSystemCpuLoadTicks();
        return String.valueOf(this.hal.getProcessor().getSystemCpuLoadBetweenTicks(prevTicks) * 100);
    }
    
    public String getProcessQtd() {
        return String.valueOf(this.os.getProcessCount());
    } 
    
    public Integer getMemory(){
       return Sistema.getMemory(this.hal.getMemory());
    }
    
    public String getTotalMemory() {
        return FormatUtil.formatBytes(this.hal.getMemory().getTotal()).replace("i", "");
    } 
    
    public String getUsedMemory(){
        Long utilizada = this.hal.getMemory().getTotal() - this.hal.getMemory().getAvailable();
        return FormatUtil.formatBytes(utilizada).replace("i", "");
    }
    
    public String getAvailableMemory(){
        return FormatUtil.formatBytes(this.hal.getMemory().getAvailable()).replace("i", "");
    }
     
    public Integer getDisk(){
        Integer disk = 0;
        for (HWDiskStore atual : diskStore) {
            
            if(atual.getReads() > 0){
                long vRead = atual.getReadBytes() / atual.getReads();

                Integer readVelocity = Integer.valueOf(
                        FormatUtil.formatBytesDecimal(vRead)
                                .replace(" KB", "").split(",")[0]
                );

                disk = readVelocity;
            }
        }   
        
        return disk;
    }
    
    public String getDeskWriteSpeed(){
        String disk = "";
        for (HWDiskStore atual : diskStore) {
            
            if(atual.getReads() > 0){
               
                long vWrite = atual.getWriteBytes() / atual.getWrites();

                disk = FormatUtil.formatBytesDecimal(vWrite);                              ;
            }
        }   
        
        return disk;
    }
    
     public String getDiskModel(){
        String model = "";
        for (HWDiskStore atual : diskStore) {
            
            if(atual.getSize() > 0){
                model = atual.getModel();
            }
        }   
        
        return model;
    }
    
    public String getHardDiskSize() {   
        String hd = "";
        for (HWDiskStore atual : diskStore) {
            
            if(atual.getSize() > 0){
                hd = FormatUtil.formatBytesDecimal((atual.getSize()));
            }
        }   
        
        return hd;
    }
    
    public Color validateCPU(Integer cpu){
        if(cpu > 85){
            mensagem.sendMessage(
                    String.format("CPU do sistema %s está em %d%% ", sistema, cpu),
                    SlackEmoji.EMOJI_WARNING);
            return Color.red;
        } else {
            return Color.BLACK;
        }
    }
    
    public Color validateMemory(Integer memory){
        if(memory > 3){
            mensagem.sendMessage(
                    String.format("Memória do sistema %s está em %d%% ", sistema, memory),
                    SlackEmoji.EMOJI_ATTENTION);
            return Color.red;
        } else {
            return Color.BLACK;
        }
    }
    
    public Color validateDisk(Integer disk){
        if(disk > 85){
            mensagem.sendMessage(
                    String.format("Disco do sistema %s está em %d%% ", sistema, disk),
                    SlackEmoji.EMOJI_DOUBLE_ATTENTION);
            return Color.red;
        } else {
            return Color.BLACK;
        }
    }
    
    
    public static void main(String[] args) {
        Components c = new Components("Catraca");
        System.out.println(c.getProcessorMaxFreq());
        System.out.println(c.getTotalMemory());
        System.out.println(c.getHardDiskSize());
        
        System.out.println("CPU " + c.getProcessorInfo() +  " - " + 
                    c.getProcessorMaxFreq() + " - " +  "27");
    }
    
}
