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
 
        // 20 times iniciais
        String[] nomes = {
            "Corinthians", "Flamengo", "Sao Paulo", "Vasco", "Fluminense",
            "Boca Juniors", "Mirassol", "Palmeiras", "Estudiantes", "Real Madrid",
            "Barcelona", "Remo", "Gremio", "Internacional", "Liverpool",
            "Tottenham", "Santos", "Riachao", "Tocantinopolis", "Hamilton"
        };
        Time[] times = new Time[nomes.length];
        for (int i = 0; i < nomes.length; i++) {
            times[i] = new Time(nomes[i]);
        }
 
        // dados das partidas 
        String[] nomeA = new String[100];
        String[] nomeB = new String[100];
        int[] placarA = new int[100];
        int[] placarB = new int[100];
        int quantJogos = 0;
 
        // partidas iniciais: {indice time A, placar A, indice time B, placar B}
        int[][] jogos = {
            {0, 2, 1, 0}, {2, 2, 3, 1}, {4, 2, 5, 0}, {6, 2, 7, 1}, {8, 0, 9, 2},
            {10, 2, 11, 0}, {12, 1, 13, 2}, {14, 0, 15, 2}, {16, 2, 17, 1}, {18, 2, 19, 0},
            {0, 2, 2, 1}, {4, 2, 6, 1}, {9, 2, 10, 0}, {3, 2, 1, 0}, {5, 2, 7, 0}
        };
        for (int i = 0; i < jogos.length; i++) {
            nomeA[quantJogos] = nomes[jogos[i][0]];
            placarA[quantJogos] = jogos[i][1];
            nomeB[quantJogos] = nomes[jogos[i][2]];
            placarB[quantJogos] = jogos[i][3];
            quantJogos++;
        }
 
        boolean precisaAtualizar = true;
        int op;
 
        do {
            // Zera os times e refaz todas as partidas
            if (precisaAtualizar) {
                for (int i = 0; i < times.length; i++) {
                    times[i] = new Time(times[i].getNomeEquipe());
                }
                for (int j = 0; j < quantJogos; j++) {
                    Time a = null;
                    Time b = null;
                    for (int i = 0; i < times.length; i++) {
                        if (times[i].getNomeEquipe().equalsIgnoreCase(nomeA[j])) a = times[i];
                        if (times[i].getNomeEquipe().equalsIgnoreCase(nomeB[j])) b = times[i];
                    }
                    Partida p = new Partida(a, b, placarA[j], placarB[j]);
                    p.pontuaTimes();
                    p.addPontuacao();
                }
                precisaAtualizar = false;
            }
 
            System.out.println("\n TORNEIO DE E-SPORTS");
            System.out.println("1 - Inserir time");
            System.out.println("2 - Editar nome de um time");
            System.out.println("3 - Remover time");
            System.out.println("4 - Registrar partida");
            System.out.println("5 - Editar placar de uma partida");
            System.out.println("6 - Remover partida");
            System.out.println("7 - Listar partidas");
            System.out.println("8 - Mostrar tabela de classificação");
            System.out.println("9 - Buscar time por nome (busca binária)");
            System.out.println("10 - Buscar partidas de um time (busca linear)");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            op = leitor.nextInt();
            leitor.nextLine();
 
            switch (op) {
 
                case 1: { // inserir o time novo
                    System.out.print("Nome do novo time: ");
                    String nome = leitor.nextLine();
                    boolean existe = false;
                    for (int i = 0; i < times.length; i++) {
                        if (times[i].getNomeEquipe().equalsIgnoreCase(nome)) existe = true;
                    }
                    if (nome.equals("") || existe) {
                        System.out.println("Nome inválido ou já existe.");
                    } else {
                        Time[] novo = new Time[times.length + 1];
                        for (int i = 0; i < times.length; i++) {
                            novo[i] = times[i];
                        }
                        novo[times.length] = new Time(nome);
                        times = novo;
                        System.out.println("Time inserido.");
                    }
                    break;
                }
 
                case 2: { // editar o nome do time
                    System.out.print("Nome do time a editar: ");
                    String nome = leitor.nextLine();
                    int pos = -1;
                    for (int i = 0; i < times.length; i++) {
                        if (times[i].getNomeEquipe().equalsIgnoreCase(nome)) pos = i;
                    }
                    if (pos == -1) {
                        System.out.println("Time não encontrado.");
                    } else {
                        System.out.print("Novo nome: ");
                        String novoNome = leitor.nextLine();
                        boolean existe = false;
                        for (int i = 0; i < times.length; i++) {
                            if (times[i].getNomeEquipe().equalsIgnoreCase(novoNome)) existe = true;
                        }
                        if (novoNome.equals("") || existe) {
                            System.out.println("Nome inválido ou já existe.");
                        } else {
                            String antigo = times[pos].getNomeEquipe();
                            for (int j = 0; j < quantJogos; j++) {
                                if (nomeA[j].equalsIgnoreCase(antigo)) nomeA[j] = novoNome;
                                if (nomeB[j].equalsIgnoreCase(antigo)) nomeB[j] = novoNome;
                            }
                            times[pos] = new Time(novoNome);
                            precisaAtualizar = true;
                            System.out.println("Time atualizado.");
                        }
                    }
                    break;
                }
 
                case 3: { // remover time
                    System.out.print("Nome do time a remover: ");
                    String nome = leitor.nextLine();
                    int pos = -1;
                    for (int i = 0; i < times.length; i++) {
                        if (times[i].getNomeEquipe().equalsIgnoreCase(nome)) pos = i;
                    }
                    if (pos == -1) {
                        System.out.println("Time não encontrado.");
                    } else {
                        String removido = times[pos].getNomeEquipe();
 
                        // remover as partidas desse time
                        int j = 0;
                        while (j < quantJogos) {
                            if (nomeA[j].equalsIgnoreCase(removido) || nomeB[j].equalsIgnoreCase(removido)) {
                                for (int k = j; k < quantJogos - 1; k++) {
                                    nomeA[k] = nomeA[k + 1];
                                    nomeB[k] = nomeB[k + 1];
                                    placarA[k] = placarA[k + 1];
                                    placarB[k] = placarB[k + 1];
                                }
                                quantJogos--;
                            } else {
                                j++;
                            }
                        }
 
                        // criar um vetor menor sem o time
                        Time[] novo = new Time[times.length - 1];
                        int k = 0;
                        for (int i = 0; i < times.length; i++) {
                            if (i != pos) {
                                novo[k] = times[i];
                                k++;
                            }
                        }
                        times = novo;
                        precisaAtualizar = true;
                        System.out.println("Time removido (e as partidas dele também).");
                    }
                    break;
                }
 
                case 4: { // registrar partida
                    if (quantJogos == 100) {
                        System.out.println("Histórico cheio.");
                        break;
                    }
                    System.out.print("Time A: ");
                    String nA = leitor.nextLine();
                    System.out.print("Time B: ");
                    String nB = leitor.nextLine();
                    int posA = -1;
                    int posB = -1;
                    for (int i = 0; i < times.length; i++) {
                        if (times[i].getNomeEquipe().equalsIgnoreCase(nA)) posA = i;
                        if (times[i].getNomeEquipe().equalsIgnoreCase(nB)) posB = i;
                    }
                    if (posA == -1 || posB == -1) {
                        System.out.println("Time não encontrado.");
                    } else if (posA == posB) {
                        System.out.println("Um time não pode jogar contra ele mesmo.");
                    } else {
                        System.out.print("Placar do time A: ");
                        int pa = leitor.nextInt();
                        System.out.print("Placar do time B: ");
                        int pb = leitor.nextInt();
                        leitor.nextLine();
                        if (pa == pb) {
                            System.out.println("Empate não é permitido.");
                        } else {
                            nomeA[quantJogos] = times[posA].getNomeEquipe();
                            nomeB[quantJogos] = times[posB].getNomeEquipe();
                            placarA[quantJogos] = pa;
                            placarB[quantJogos] = pb;
                            quantJogos++;
                            precisaAtualizar = true;
                            System.out.println("Partida registrada.");
                        }
                    }
                    break;
                }
 
                case 5: { // editar placar
                    if (quantJogos == 0) {
                        System.out.println("Nenhuma partida registrada.");
                        break;
                    }
                    for (int j = 0; j < quantJogos; j++) {
                        System.out.println("[" + j + "] " + nomeA[j] + " " + placarA[j] + " x " + placarB[j] + " " + nomeB[j]);
                    }
                    System.out.print("Número da partida: ");
                    int j = leitor.nextInt();
                    leitor.nextLine();
                    if (j < 0 || j >= quantJogos) {
                        System.out.println("Número inválido.");
                    } else {
                        System.out.print("Novo placar de " + nomeA[j] + ": ");
                        int pa = leitor.nextInt();
                        System.out.print("Novo placar de " + nomeB[j] + ": ");
                        int pb = leitor.nextInt();
                        leitor.nextLine();
                        if (pa == pb) {
                            System.out.println("Empate não é permitido.");
                        } else {
                            placarA[j] = pa;
                            placarB[j] = pb;
                            precisaAtualizar = true;
                            System.out.println("Partida atualizada.");
                        }
                    }
                    break;
                }
 
                case 6: { // remover partida
                    if (quantJogos == 0) {
                        System.out.println("Nenhuma partida registrada.");
                        break;
                    }
                    for (int j = 0; j < quantJogos; j++) {
                        System.out.println("[" + j + "] " + nomeA[j] + " " + placarA[j] + " x " + placarB[j] + " " + nomeB[j]);
                    }
                    System.out.print("Número da partida: ");
                    int j = leitor.nextInt();
                    leitor.nextLine();
                    if (j < 0 || j >= quantJogos) {
                        System.out.println("Número inválido.");
                    } else {
                        for (int k = j; k < quantJogos - 1; k++) {
                            nomeA[k] = nomeA[k + 1];
                            nomeB[k] = nomeB[k + 1];
                            placarA[k] = placarA[k + 1];
                            placarB[k] = placarB[k + 1];
                        }
                        quantJogos--;
                        precisaAtualizar = true;
                        System.out.println("Partida removida.");
                    }
                    break;
                }
 
                case 7: { // listar partidas
                    if (quantJogos == 0) {
                        System.out.println("Nenhuma partida registrada.");
                    }
                    for (int j = 0; j < quantJogos; j++) {
                        System.out.println("[" + j + "] " + nomeA[j] + " " + placarA[j] + " x " + placarB[j] + " " + nomeB[j]);
                    }
                    break;
                }
 
                case 8: { // tabela (ordenarTimes ordena e imprime)
                    System.out.println("\nTABELA DE CLASSIFICAÇÃO");
                    TabelaTorneio.ordenarTimes(times);
                    break;
                }
 
                case 9: { // busca binária
                    System.out.print("Nome do time: ");
                    String nome = leitor.nextLine();
                    TabelaTorneio.ordemAlfabetica(times);
                    System.out.println(TabelaTorneio.pesquisaBinaria(times, nome));
                    break;
                }
 
                case 10: { // busca linear das partidas de um time
                    System.out.print("Nome do time: ");
                    String nome = leitor.nextLine();
 
                    int quant = 0;
                    for (int j = 0; j < quantJogos; j++) {
                        if (nomeA[j].equalsIgnoreCase(nome) || nomeB[j].equalsIgnoreCase(nome)) {
                            quant++;
                        }
                    }
                    int[] achadas = new int[quant]; // novo vetor só com as partidas do time
                    int k = 0;
                    for (int j = 0; j < quantJogos; j++) {
                        if (nomeA[j].equalsIgnoreCase(nome) || nomeB[j].equalsIgnoreCase(nome)) {
                            achadas[k] = j;
                            k++;
                        }
                    }
 
                    if (quant == 0) {
                        System.out.println("Nenhuma partida encontrada para esse time.");
                    }
                    for (int i = 0; i < achadas.length; i++) {
                        int j = achadas[i];
                        System.out.println("[" + j + "] " + nomeA[j] + " " + placarA[j] + " x " + placarB[j] + " " + nomeB[j]);
                    }
                    break;
                }
 
                case 0:
                    System.out.println("Encerrando");
                    break;
 
                default:
                    System.out.println("Opção invalida");
            }
        } while (op != 0);
    }

    }
}
       
