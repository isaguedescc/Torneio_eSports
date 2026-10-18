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

                else if(times[i].getPontuacaoTotal()==times[i+1].getPontuacaoTotal()) {
                   if(times[i].getVitorias()<times[i+1].getVitorias()) {
                	    Time temp = times[i];
                        times[i] = times[i+1];
                        times[i+1] = temp;
                        trocou = true;
                	}
                   
            }
            }
            n--;
        }while(trocou);
           
        for(Time time : times) {
            System.out.println(time);
        }
        }
    
    public static void ordemAlfabetica(Time[] times) {
        for(int i = 0; i < times.length - 1; i++) {
            int menor = i;

            for(int j = i + 1; j < times.length; j++) {
                if(times[j].getNomeEquipe().compareToIgnoreCase(
                        times[menor].getNomeEquipe()) < 0) {
                    menor = j;
                }
            }

            Time temp = times[menor];
            times[menor] = times[i];
            times[i] = temp;
        }

    }

    public static String pesquisaBinaria(Time[] times, String nomeTime) {
        int inicio = 0;
        int fim = times.length - 1;

        while(inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if(times[meio].getNomeEquipe().compareToIgnoreCase(nomeTime) == 0) {
                return times[meio].toString(); 
            }
            
            if(times[meio].getNomeEquipe().compareToIgnoreCase(nomeTime) < 0) {
                inicio = meio + 1;
            } 
            else{
                fim = meio - 1;
            }
        }

        return "Time não encontrado";
    }
    
    public static void main(String [] args) {
    	Scanner leitor = new Scanner(System.in);
    	
    	Time times[] = new Time[20];
    	times[0] = new Time("Flamengo");
    	times[1] = new Time("Corinthians");
    	times[2] = new Time("Palmeiras");
    	times[3] = new Time("Vasco");
    	times[4] = new Time("Botafogo");
    	times[5] = new Time("Fluminense");
    	times[6] = new Time("Gremio");
    	times[7] = new Time("Sao Paulo");
    	times[8] = new Time("Atletico Mineiro");
    	times[9] = new Time("Bahia");
    	times[10] = new Time("Fortaleza");
    	times[11] = new Time("Vila Nova");
    	times[12] = new Time("Ponte Preta");
    	times[13] = new Time("Tourão");
    	times[14] = new Time("Atletico Goianense");
    	times[15] = new Time("Vitoria");
    	times[16] = new Time("Boca Juniors");
    	times[17] = new Time("Santos");
    	times[18] = new Time("Mirassol");
    	times[19] = new Time("Sport Clube");
    	
    	ordemAlfabetica(times);
    	
    	System.out.println("Buscar time:");
    	String nomeTime = leitor.nextLine();
    	
    	String resultado = pesquisaBinaria(times, nomeTime);
    	
    	System.out.println(resultado);

    }
        
}
