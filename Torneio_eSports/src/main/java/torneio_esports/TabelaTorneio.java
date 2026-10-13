/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package torneio_esports;
/**
 *
 * @author root
 */
public class TabelaTorneio {
    private Time [] times;
    private int quantTimes;
   
    // método que verifica se há espaço no vetor p/ add times
    public boolean isTimes(Time time){      
        return quantTimes < times.length;
    }

    // para organizar os times em ordem decrescente baseando na pontuação
    /*public []int ordenarTimes(Time []times){
        int n = times.length;
        
        for (int i =0; i<n-1; i++){
            int max_idx = i;
            
            for(int j = i+1; j<n; j++){
                if(times[j].getPontuacaoTotal()>times[max_idx].getPontuacaoTotal()){
                    max_idx = j;
            }else if(times[j].getPontuacaoTotal() == times[max_idx].getPontuacaoTotal()){
                    if(times[j].getVitorias()>times[max_idx].getVitorias()){
                        max_idx = j;
                    }else{
                       j = max_idx; 
            }
            }
                Time temp = times[max_idx];
                times[max_idx]= times[i];
                times[i] = temp;
            }
            
        }
        
        return -1;
  }
*/    
    }

