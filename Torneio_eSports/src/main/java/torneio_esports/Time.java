/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package torneio_esports;

public class Time {
    private String nomeEquipe;
    private int vitorias;
    private int derrotas;
    private int pontuacaoTotal;
 
   public Time(String nomeEquipe, int vitorias, int derrotas){
        this.nomeEquipe = nomeEquipe;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
    }
    
    public String getNomeEquipe(){
        return nomeEquipe;
    }
    
    public int getVitorias(){
        return vitorias;
    }
    
    public int getDerrotas(){
        return derrotas;
    }
    
    public void setPontuacaoTotal(int valor){
        if(valor == 3){
            pontuacaoTotal +=3;
        }else{
            pontuacaoTotal +=0;
        }
    }
    public int getPontuacaoTotal(){
        return pontuacaoTotal;
    }
    
    public void atualizaVitorias(){
        vitorias ++;
    }
    
    public void atualizaDerrotas(){
        derrotas ++;
    }

    @Override
    public String toString() {
        return "Time:" +  nomeEquipe + "\n" + "Pontuação: " + pontuacaoTotal;
    }
    
}
 
