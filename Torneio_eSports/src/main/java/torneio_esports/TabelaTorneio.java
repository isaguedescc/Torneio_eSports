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
public static void ordenarTimes(Time [] times){
        int n = times.length;
        boolean trocou;
        
        do{
            trocou = false;
            for(int i = 0; i< n-1; i++){
                if(times[i].getPontuacaoTotal()<times[i+1].getPontuacaoTotal()){
                  Time temp = times[i];
                  times[i] = times[i+1];
                  times[i+1] = temp;
                   trocou = true;
                }
            }
            n--;
        }while(trocou);
           
        for (Time time : times) {
            System.out.println(time);
        }
    }
public static String pesquisaBinaria(Time[] times, String nomeTime) {
        int inicio = 0;
        int fim = times.length - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if (times[meio].getNomeEquipe().compareToIgnoreCase(nomeTime) == 0) {
                return times[meio].toString(); 
            }
            
            if (times[meio].getNomeEquipe().compareToIgnoreCase(nomeTime) < 0) {
                inicio = meio + 1;
            } 
            else {
                fim = meio - 1;
            }
        }

        return "Time não encontrado";
    }
    
    
    public static void ordemAlfabetica(Time[] times) {
        for (int i = 0; i < times.length - 1; i++) {
            int menor = i;

            for (int j = i + 1; j < times.length; j++) {
                if (times[j].getNomeEquipe().compareToIgnoreCase(
                        times[menor].getNomeEquipe()) < 0) {
                    menor = j;
                }
            }

            Time temp = times[menor];
            times[menor] = times[i];
            times[i] = temp;
        }

    }
    
    public static void main(String [] args) {
    	Scanner leitor = new Scanner(System.in);
    	
    	Time times[] = new Time[20];
    	times[0] = new Time("Flamengo", 1, 1);
    	times[1] = new Time("Corinthians", 1, 1);
    	times[2] = new Time("Palmeiras", 1, 1);
    	times[3] = new Time("Vasco", 1, 1);
    	times[4] = new Time("Botafogo", 1, 1);
    	times[5] = new Time("Fluminense",1, 1);
    	times[6] = new Time("Gremio", 1, 1);
    	times[7] = new Time("Sao Paulo", 1, 1);
    	times[8] = new Time("Atletico Mineiro", 1, 1);
    	times[9] = new Time("Bahia", 1, 1);
    	times[10] = new Time("Fortaleza", 1, 1);
    	times[11] = new Time("Vila Nova", 1, 1);
    	times[12] = new Time("Ponte Preta", 1, 1);
    	times[13] = new Time("Tourão", 1, 1);
    	times[14] = new Time("Atletico Goianense", 1, 1);
    	times[15] = new Time("Vitoria", 1, 1);
    	times[16] = new Time("Boca Juniors",1, 1);
    	times[17] = new Time("Santos", 1, 1);
    	times[18] = new Time("Mirassol", 1, 1);
    	times[19] = new Time("Sport Clube", 1, 1);
    	
    	ordemAlfabetica(times);
    	
    	System.out.println("Buscar time:");
    	String nomeTime = leitor.next();
    	
    	String resultado = pesquisaBinaria(times, nomeTime);
    	
    	System.out.println(resultado);

    }
        
}
