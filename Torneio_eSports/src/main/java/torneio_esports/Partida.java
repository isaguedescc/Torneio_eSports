/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package torneio_esports;

/**
 *
 * @author root
 */
public class Partida {
    private Time timeA;
    private Time timeB;
    private int placarA;
    private int placarB;
    
    public Partida(Time timeA, int placarA, Time timeB, int placarB){
        this.timeA = timeA;
        this.timeB = timeB;
        this.placarA = placarA;
        this.placarB = placarB;
    }
  
    // método para atualizar a quantidade de vitórias os derrotas e pontuar os times
    public void pontuaTimes(){
	        if(placarA > placarB){
	            timeA.atualizaVitorias();
	            timeB.atualizaDerrotas();
	        }else if(placarB>placarA){
	            timeB.atualizaVitorias();
	            timeA.atualizaDerrotas();
	        }
	        else {
	        	
            }	        
	    }
    // método que contabiliza a pontuação total 
    public void addPontos(){
	    	if(placarA> placarB){
	            timeA.setPontuacaoTotal(timeA.getPontuacaoTotal()+3);
	            timeB.setPontuacaoTotal(timeB.getPontuacaoTotal()+0);
	            
	        }
	        else if(placarB> placarA) {
	        	timeB.setPontuacaoTotal(timeB.getPontuacaoTotal()+3);
	            timeA.setPontuacaoTotal(timeA.getPontuacaoTotal()+0);
	            
	        }
	        else {
	        	timeA.setPontuacaoTotal(timeA.getPontuacaoTotal()+1);
	        	timeB.setPontuacaoTotal(timeB.getPontuacaoTotal()+1);
	        }
	    }
    
}
