package securit.telas;

import securit.oshi.Components;
import securit.graficos.Graph;
import securit.slack.SlackMessage;
import securit.database.Banco;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.jfree.chart.ChartPanel;
import oshi.SystemInfo;

public class Dashboard extends javax.swing.JFrame {
    
    Integer cpu, memory, disk, sistemaId, cpuId, memoryId,diskId;
    Timer timer = new Timer();
    Boolean isVisible[] = {false, false, false};
    
    Graph cpuGraph = new Graph("CPU");
    Graph memoryGraph = new Graph("Memory");
    Graph diskGraph = new Graph("Disk");
    
    ChartPanel cg = cpuGraph.getGraph(System.currentTimeMillis(), 0);
    ChartPanel mg = memoryGraph.getGraph(System.currentTimeMillis(), 0);
    ChartPanel dg = diskGraph.getGraph(System.currentTimeMillis(), 0);
    
    
    Components comp;
    Banco banco = new Banco();
    
    public Dashboard() {
        initComponents();
        insert();
    }
    
        
    public Dashboard(String nomeSistema, String idSistema) {
        initComponents();
  
        lbSistema.setText(nomeSistema);
        sistemaId = Integer.valueOf(idSistema);
        
        Boolean result = banco.consultarComponenteSistema(idSistema);
        
        comp = new Components(nomeSistema);
        if(result){
            setIdComponentes();
        } else {
            banco.insertComponent("HD " + comp.getDiskModel(), 
                    comp.getHardDiskSize(), idSistema);
            
            banco.insertComponent("RAM" , 
                    comp.getTotalMemory(), idSistema);
            
            banco.insertComponent("CPU " + comp.getProcessorInfo(), 
                    comp.getProcessorMaxFreq(), idSistema);
            
            banco.consultarComponenteSistema(idSistema);
            setIdComponentes();
        }
        insert();
    }
    
    public void setIdComponentes(){
        cpuId = Integer.valueOf(banco.getIdCpu());
        memoryId = Integer.valueOf(banco.getIdRam());
        diskId = Integer.valueOf(banco.getIdHD());
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }
    
    class task extends TimerTask{
        public void run(){
            insert();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbSistema = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCPU = new javax.swing.JLabel();
        lblMemory = new javax.swing.JLabel();
        lblDisk = new javax.swing.JLabel();
        panCpu = new javax.swing.JPanel();
        panMemory = new javax.swing.JPanel();
        panDisk = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbMemTotal = new javax.swing.JLabel();
        lbCpuDetalhe = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        lbDisponivel = new javax.swing.JLabel();
        lbMemDisponivel = new javax.swing.JLabel();
        lbTotal1 = new javax.swing.JLabel();
        lbVleitura = new javax.swing.JLabel();
        lbDisponivel1 = new javax.swing.JLabel();
        lbDiscoTotal = new javax.swing.JLabel();
        lbTotal2 = new javax.swing.JLabel();
        lbQtdProcessos = new javax.swing.JLabel();
        lbUsada = new javax.swing.JLabel();
        lbCpuUsada = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        jPanel1.setBackground(java.awt.Color.orange);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("A SEGURANÇA QUE VOCÊ MERECE");
        jLabel5.setToolTipText("");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("securIT");
        jLabel6.setToolTipText("");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        lbSistema.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbSistema.setForeground(new java.awt.Color(254, 254, 254));
        lbSistema.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSistema.setText("SISTEMA");
        lbSistema.setToolTipText("");
        lbSistema.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbSistema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSistemaMouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("GERAR LOGS");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("PROCESSOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(lbSistema)
                .addGap(17, 17, 17))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(java.awt.Color.gray);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("CPU");
        jLabel2.setToolTipText("");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(java.awt.Color.gray);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("MEMÓRIA");
        jLabel3.setToolTipText("");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(java.awt.Color.gray);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("DISCO RÍGIDO");
        jLabel4.setToolTipText("");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblCPU.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblCPU.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCPU.setText("%");
        lblCPU.setToolTipText("");
        lblCPU.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblMemory.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblMemory.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMemory.setText("%");
        lblMemory.setToolTipText("");
        lblMemory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblDisk.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblDisk.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDisk.setText("%");
        lblDisk.setToolTipText("");
        lblDisk.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        panCpu.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153))));
        panCpu.setPreferredSize(new java.awt.Dimension(320, 240));

        javax.swing.GroupLayout panCpuLayout = new javax.swing.GroupLayout(panCpu);
        panCpu.setLayout(panCpuLayout);
        panCpuLayout.setHorizontalGroup(
            panCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        panCpuLayout.setVerticalGroup(
            panCpuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        panMemory.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153))));
        panMemory.setPreferredSize(new java.awt.Dimension(320, 240));

        javax.swing.GroupLayout panMemoryLayout = new javax.swing.GroupLayout(panMemory);
        panMemory.setLayout(panMemoryLayout);
        panMemoryLayout.setHorizontalGroup(
            panMemoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        panMemoryLayout.setVerticalGroup(
            panMemoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        panDisk.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153))));
        panDisk.setPreferredSize(new java.awt.Dimension(320, 240));

        javax.swing.GroupLayout panDiskLayout = new javax.swing.GroupLayout(panDisk);
        panDisk.setLayout(panDiskLayout);
        panDiskLayout.setHorizontalGroup(
            panDiskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        panDiskLayout.setVerticalGroup(
            panDiskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(177, 131, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Desempenho atual");
        jLabel7.setToolTipText("");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        lbMemTotal.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbMemTotal.setForeground(new java.awt.Color(62, 62, 62));
        lbMemTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbMemTotal.setText("666");
        lbMemTotal.setToolTipText("");
        lbMemTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbMemTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMemTotalMouseClicked(evt);
            }
        });

        lbCpuDetalhe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbCpuDetalhe.setForeground(java.awt.Color.gray);
        lbCpuDetalhe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCpuDetalhe.setText("...");
        lbCpuDetalhe.setToolTipText("");
        lbCpuDetalhe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbCpuDetalhe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCpuDetalheMouseClicked(evt);
            }
        });

        lbTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotal.setForeground(java.awt.Color.gray);
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTotal.setText("TOTAL");
        lbTotal.setToolTipText("");
        lbTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTotalMouseClicked(evt);
            }
        });

        lbDisponivel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDisponivel.setForeground(java.awt.Color.gray);
        lbDisponivel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDisponivel.setText("DISPONÍVEL");
        lbDisponivel.setToolTipText("");
        lbDisponivel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbDisponivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDisponivelMouseClicked(evt);
            }
        });

        lbMemDisponivel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbMemDisponivel.setForeground(new java.awt.Color(62, 62, 62));
        lbMemDisponivel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbMemDisponivel.setText("666");
        lbMemDisponivel.setToolTipText("");
        lbMemDisponivel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbMemDisponivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMemDisponivelMouseClicked(evt);
            }
        });

        lbTotal1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotal1.setForeground(java.awt.Color.gray);
        lbTotal1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTotal1.setText("VELOCIDADE DE LEITURA");
        lbTotal1.setToolTipText("");
        lbTotal1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbTotal1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTotal1MouseClicked(evt);
            }
        });

        lbVleitura.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbVleitura.setForeground(new java.awt.Color(62, 62, 62));
        lbVleitura.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbVleitura.setText("666");
        lbVleitura.setToolTipText("");
        lbVleitura.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbVleitura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbVleituraMouseClicked(evt);
            }
        });

        lbDisponivel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDisponivel1.setForeground(java.awt.Color.gray);
        lbDisponivel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDisponivel1.setText("ESPAÇO TOTAL");
        lbDisponivel1.setToolTipText("");
        lbDisponivel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbDisponivel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDisponivel1MouseClicked(evt);
            }
        });

        lbDiscoTotal.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbDiscoTotal.setForeground(new java.awt.Color(62, 62, 62));
        lbDiscoTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDiscoTotal.setText("666");
        lbDiscoTotal.setToolTipText("");
        lbDiscoTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbDiscoTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDiscoTotalMouseClicked(evt);
            }
        });

        lbTotal2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotal2.setForeground(java.awt.Color.gray);
        lbTotal2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTotal2.setText("QTD. PROCESSOS");
        lbTotal2.setToolTipText("");
        lbTotal2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbTotal2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTotal2MouseClicked(evt);
            }
        });

        lbQtdProcessos.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbQtdProcessos.setForeground(new java.awt.Color(62, 62, 62));
        lbQtdProcessos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbQtdProcessos.setText("666");
        lbQtdProcessos.setToolTipText("");
        lbQtdProcessos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbQtdProcessos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQtdProcessosMouseClicked(evt);
            }
        });

        lbUsada.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbUsada.setForeground(java.awt.Color.gray);
        lbUsada.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbUsada.setText("USADA");
        lbUsada.setToolTipText("");
        lbUsada.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbUsada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbUsadaMouseClicked(evt);
            }
        });

        lbCpuUsada.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbCpuUsada.setForeground(new java.awt.Color(62, 62, 62));
        lbCpuUsada.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCpuUsada.setText("666");
        lbCpuUsada.setToolTipText("");
        lbCpuUsada.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbCpuUsada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCpuUsadaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(950, 950, 950))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panCpu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCpuDetalhe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbQtdProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCpuUsada, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbUsada, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panMemory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMemory, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbMemTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbMemDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDisk, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbVleitura, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbTotal1))
                                    .addGap(29, 29, 29)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbDiscoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbDisponivel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(panDisk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel7)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMemory, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDisk, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panMemory, 239, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panDisk, 239, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panCpu, 239, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbTotal2)
                                    .addGap(12, 12, 12)
                                    .addComponent(lbQtdProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbUsada)
                                    .addGap(12, 12, 12)
                                    .addComponent(lbCpuUsada, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbTotal)
                                    .addGap(12, 12, 12)
                                    .addComponent(lbMemTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbDisponivel)
                                    .addGap(12, 12, 12)
                                    .addComponent(lbMemDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbTotal1)
                                    .addGap(12, 12, 12)
                                    .addComponent(lbVleitura, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbDisponivel1)
                                .addGap(12, 12, 12)
                                .addComponent(lbDiscoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lbCpuDetalhe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void lbSistemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSistemaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbSistemaMouseClicked

    private void lbMemTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMemTotalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbMemTotalMouseClicked

    private void lbCpuDetalheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCpuDetalheMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbCpuDetalheMouseClicked

    private void lbTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTotalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbTotalMouseClicked

    private void lbDisponivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDisponivelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbDisponivelMouseClicked

    private void lbMemDisponivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMemDisponivelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbMemDisponivelMouseClicked

    private void lbTotal1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTotal1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbTotal1MouseClicked

    private void lbVleituraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbVleituraMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbVleituraMouseClicked

    private void lbDisponivel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDisponivel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbDisponivel1MouseClicked

    private void lbDiscoTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDiscoTotalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbDiscoTotalMouseClicked

    private void lbTotal2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTotal2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbTotal2MouseClicked

    private void lbQtdProcessosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQtdProcessosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbQtdProcessosMouseClicked

    private void lbUsadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUsadaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbUsadaMouseClicked

    private void lbCpuUsadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCpuUsadaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbCpuUsadaMouseClicked

    private void insert(){
        getData();
        
        setText();
        
        setColor();
        
        getGraph();
        
        addGraph();
        
        insertLogs();
        
        timer.schedule(new task(), 1000);
    }
    
    private void getData(){
        cpu = comp.getCPU();
        memory = comp.getMemory();
        disk = comp.getDisk();
    }
    
    private void setText(){
       lblCPU.setText(cpu.toString()+"%");
       lblMemory.setText(memory.toString()+"%");
       lblDisk.setText(disk.toString()+"%");
       
       
       lbCpuDetalhe.setText(comp.getProcessorInfo());
       lbQtdProcessos.setText(comp.getProcessQtd());
       lbCpuUsada.setText(comp.getUsedCpu());
       
       lbDiscoTotal.setText(comp.getHardDiskSize());
       lbVleitura.setText(comp.getDeskWriteSpeed());
       
       lbMemTotal.setText(comp.getTotalMemory());
       lbMemDisponivel.setText(comp.getUsedMemory());
    }
    
    private void setColor(){
        lblCPU.setForeground(comp.validateCPU(cpu));
        lblMemory.setForeground(comp.validateMemory(memory));
        lblDisk.setForeground(comp.validateDisk(disk));
    }
    
    private void getGraph(){
        cg = cpuGraph.getGraph(System.currentTimeMillis(), cpu);
        mg = memoryGraph.getGraph(System.currentTimeMillis(), memory);
        dg = diskGraph.getGraph(System.currentTimeMillis(), disk);
    }
    
    private void addGraph(){
        panCpu.add(cg);
        panMemory.add(mg);
        panDisk.add(dg);
    }
    
    private void insertLogs(){
        banco.insertComponentLogs(sistemaId, disk, diskId);
        banco.insertComponentLogs(sistemaId, memory, memoryId);
        banco.insertComponentLogs(sistemaId, cpu, cpuId);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCpuDetalhe;
    private javax.swing.JLabel lbCpuUsada;
    private javax.swing.JLabel lbDiscoTotal;
    private javax.swing.JLabel lbDisponivel;
    private javax.swing.JLabel lbDisponivel1;
    private javax.swing.JLabel lbMemDisponivel;
    private javax.swing.JLabel lbMemTotal;
    private javax.swing.JLabel lbQtdProcessos;
    private javax.swing.JLabel lbSistema;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbTotal1;
    private javax.swing.JLabel lbTotal2;
    private javax.swing.JLabel lbUsada;
    private javax.swing.JLabel lbVleitura;
    private javax.swing.JLabel lblCPU;
    private javax.swing.JLabel lblDisk;
    private javax.swing.JLabel lblMemory;
    private javax.swing.JPanel panCpu;
    private javax.swing.JPanel panDisk;
    private javax.swing.JPanel panMemory;
    // End of variables declaration//GEN-END:variables
}
