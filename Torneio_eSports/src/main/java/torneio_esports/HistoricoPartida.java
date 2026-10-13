/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package torneio_esports;

/**
 *
 * @author root
 */
public class HistoricoPartida {
    private Partida [] partidas;
    private int quantJogos;
    
    // fazer os métodos
    
    // método para o nome de um time
    public static int acharPartidas(Partida []partidas, Time time){
                for(int i = 0;i<partidas.length;i++){
            if(partidas[i].equals(time)){
                return i;
            }
        }
        return -1;
    }
    
}
