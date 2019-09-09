package ordenacao;

import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Gnomo
 */
public class GeradorDeGrafico {
    public GeradorDeGrafico(){}
    
    public JPanel gerarGrafico(ArrayList<String> dados, int id){       
        //Criando o conjunto dos dados
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        int tempoSelection, tempoInsertion, tempoBubble, tempoShake, tempoComb, tempoShell;
        
        //Pegando os valores
        if(!dados.get(0).equals("X")){
            tempoSelection = Integer.parseInt(dados.get(0));
            dataset.addValue(tempoSelection, "SELECTION", "MÉTODO");
        }
        if(!dados.get(1).equals("X")){
            tempoInsertion = Integer.parseInt(dados.get(1));
            dataset.addValue(tempoInsertion, "INSERTION", "MÉTODO");
        }
        if(!dados.get(2).equals("X")){
            tempoBubble = Integer.parseInt(dados.get(2));
            dataset.addValue(tempoBubble, "BUBBLE", "MÉTODO");
        }
        if(!dados.get(3).equals("X")){
            tempoShake = Integer.parseInt(dados.get(3));
            dataset.addValue(tempoShake, "SHAKE", "MÉTODO");
        }
        if(!dados.get(4).equals("X")){
            tempoComb = Integer.parseInt(dados.get(4));
            dataset.addValue(tempoComb, "COMB", "MÉTODO");
        }
        if(!dados.get(5).equals("X")){
            tempoShell = Integer.parseInt(dados.get(5));
            dataset.addValue(tempoShell, "SHELL", "MÉTODO");
        }
        //Criando o gráfico
        
        String titulo = "";
        String eixoY = "";
        String txtLegenda = "";
        
        if(id == 0){
            titulo = "Gráfico de Tempo";
            eixoY = "Tempo em MS";
            txtLegenda = "Legenda: ";
        }
        if(id == 1){
            titulo = "Gráfico de Comparações";
            eixoY = "Número de Comparações";
            txtLegenda = "Legenda: "; 
        }
        if(id == 2){
            titulo = "Gráfico de Trocas";
            eixoY = "Número de Trocas";
            txtLegenda = "Legenda: "; 
        }
        JFreeChart grafico = ChartFactory.createBarChart(titulo, txtLegenda, eixoY, dataset, PlotOrientation.VERTICAL, true, true, true);
        ChartPanel panelGrafico = new ChartPanel(grafico, true);
        panelGrafico.setSize(640,500);
        panelGrafico.setVisible(true);
        return panelGrafico;
    }
    
}
