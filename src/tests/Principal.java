package tests;

import enumns.TipoTimeEnum;
import models.Time;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

     public static List<Time> times = new ArrayList<>();
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

        boolean executando = true;

        while (executando) {
            System.out.println("Menu" +
                    "\n0- Sair" +
                    "\n1- Cadastrar Times" +
                    "\n2- Listar Times" +
                    "\n3- Consultar por ..." +
                    "\n4- Alterar Times" +
                    "\n5- Excluir Times" +
                    "\n6- Consultar por Nacionalidade"+
                    "\n7- Consultar por Time Mais Titulos"+
                    "\nDigite a operação desejada: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha){
                case 0:
                    System.out.println("Saindo do programa");
                    executando = false;
                    break;
                case 1:
                    cadastrarTime(scanner);
                    break;
                case 2:
                    listarTimes();
                    break;
                case 3:
                    consultarTimes(scanner);
                    break;
                case 4:
                    alterarTimes(scanner);
                    break;
                case 5:
                    excluirTime(scanner);
                    break;
                case 6:
                    System.out.println("Digite a nacionalidade(BRASILEIRO,PORTUGUES,INGLES,FRANCES,ARGENTINO,ESPANHOL")
                    ;TipoTimeEnum nacionalidade = TipoTimeEnum.valueOf(scanner.nextLine().toUpperCase());
                    buscarTimeNacionalidade(nacionalidade);
                    break;
                case 7:
                    System.out.println("Digite o número mínimo de títulos:");
                    int minTitulos = scanner.nextInt();
                    List<Time> timesComMaisTitulos = buscarTimeComMaisTitulos(minTitulos);
                    timesComMaisTitulos.forEach(Principal::exibirDetalhesTime);
                    break;
                case 8:
                    System.out.println("Digite o número minimo da torcida: ");
                    int minTorcida = scanner.nextInt();
                    List<Time> timesComMaisTorcidas = buscarTimeComMaisTorcida(minTorcida);
                    timesComMaisTorcidas.forEach(Principal::exibirDetalhesTime);


                default:
                    System.out.println("Opção inválida");

            }
            }
        }


     //Metodo para cadastrar o time
     public static void cadastrarTime(Scanner scanner) {
         System.out.println("Informe o NOME do time: ");
         String nome = scanner.nextLine();
         System.out.println("Informe a quantidade de TITULOS do seu time: ");
         int titulos = scanner.nextInt();
         System.out.println("Informe a quantidade de TORCEDORES tem o seu time: ");
         int torcida = scanner.nextInt();
         System.out.println("Informe o ANO em que seu time foi criado: ");
         int anoDeFundacao = scanner.nextInt();
         System.out.println("Informe a quantidade de VITÓRIAS que tem o seu time: ");
         int vitorias = scanner.nextInt();
         System.out.println("Informe a quantidade de DERROTAS que tem o seu time: ");
         int derrotas = scanner.nextInt();
         System.out.println("Informe a quantidade de GOLS que tem o seu time: ");
         int saldoDeGols = scanner.nextInt();

         System.out.println("Selecione o tipo do time: " +
                 "  \n1-BRASILEIRO," +
                 "  \n2-PORTUGUES," +
                 "  \n3-INGLES," +
                 "  \n4-FRANCES," +
                 "  \n5-ARGENTINO," +
                 "  \n6-ESPANHOL,");
         int opcaoNacionalidade = scanner.nextInt();
         scanner.nextLine();

         TipoTimeEnum nacionalidade ;
         switch (opcaoNacionalidade) {
             case 1:
                 nacionalidade = TipoTimeEnum.BRASILEIRO;
                 break;
             case 2:
                 nacionalidade = TipoTimeEnum.PORTUGUES;
                 break;
             case 3:
                 nacionalidade = TipoTimeEnum.INGLES;
                 break;
             case 4:
                 nacionalidade = TipoTimeEnum.FRANCES;
                 break;
             case 5:
                 nacionalidade = TipoTimeEnum.ARGENTINO;
                 break;
             case 6:
                 nacionalidade = TipoTimeEnum.ESPANHOL;
                 break;
             default:
                 System.out.println("Opção inválida. Definido como BRASILEIRO por padrão.");
                 nacionalidade = TipoTimeEnum.BRASILEIRO;
                 break;
         }
         Time novoTime = new Time(nome, titulos, torcida, anoDeFundacao, vitorias, derrotas, saldoDeGols,nacionalidade);
         times.add(novoTime);
         System.out.println("Time cadastrado com sucesso!");

     }


     //Metodo para listar o time, utilizando for para criar o id/indice, ao criar sera numerado ao lado do time o seu id.Ordem sequencial
     public static void listarTimes() {
         if (times.isEmpty()) {
             System.out.println("Nao foi encontrado nenhum time cadastrado, por favor cadastrar um");
         } else {
             System.out.println("Lista de times");
             System.out.println("-----------------------");
             for (int i = 0; i < times.size(); i++) {
                 Time time = times.get(i);
                 System.out.println((i+1) +
                         ". " + time.getNome() +
                         "\n Fundado em: " + time.getAnoDeFundacao() +
                         "\n Nacionalidade: "+ time.getTipotime()+
                         "\n Titulos: " + time.getTitulos() +
                         "\n Torcedores: " + time.getTorcida() +
                         "\n Vitorias: " + time.getVitorias() +
                         "\n Derrotas: " + time.getDerrotas() +
                         "\n Saldo de Gols: " + time.getSaldoDeGols()+
                         "\n-----------------------");
             }
         }
     }


     // Metodo para criar um submenu, onde o usuario pode pesquisar pelo NOME ou por ID do time.
     public static void consultarTimes(Scanner scanner){
         System.out.println("Submenu de Consulta"+
                 "\n1-Consultar por ID"+
                 "\n2-Consultar por Nome"
         );
         int opcao = scanner.nextInt();
         scanner.nextLine();

         switch(opcao){
             case 1:
                 consultarPorID(scanner);
                 break;
             case 2:
                 consultarPorNome(scanner);
                 break;
             default:
                 System.out.println("Opção inválida");

         }
     }


        //Metodo consulta por id através do tamanho dele, que foi criado no listarTimes.
        public static void consultarPorID(Scanner scanner) {
            System.out.println("Digite o ID do time: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            if (id > 0 && id <= times.size()) {
                Time timeId = times.get(id - 1);
                System.out.println("Time encontrado:");
                exibirDetalhesTime(timeId);
            } else {
                System.out.println("ID inválido");
            }
        }


        //Metodo consultar por nome utilizando for para percorrer pela lista e o equalsIgnoreCase para fazer uma busca que nao diferencia, minusculas de maiusculas
        public static void consultarPorNome(Scanner scanner) {
            System.out.println("Digite o nome do time: ");
            String nome = scanner.nextLine();

            for (Time timeNome : times) {
                if (timeNome.getNome().equalsIgnoreCase(nome)) {
                    System.out.println("Time encontrado:");
                    exibirDetalhesTime(timeNome);
                    return;
                }
            }
            System.out.println("Nome do time não encontrado!");
        }


     public static void alterarTimes(Scanner scanner){
         System.out.println("Digite o nome do time que deseja alterar: ");
         String nomeTime = scanner.nextLine();

         for (Time time : times){
             if (time.getNome().equalsIgnoreCase(nomeTime)){
                 System.out.println("Time encontrado. O que deseja alterar?");
                 System.out.println("1- Nome");
                 System.out.println("2- Títulos");
                 System.out.println("3- Torcida");
                 System.out.println("4- Ano de fundação");
                 System.out.println("5- Vitórias");
                 System.out.println("6- Derrotas");
                 System.out.println("7- Saldo de Gols");
                 System.out.println("8- Nacionalidade");

             }else{
                 System.out.println("Time não encontrado, Por favor digite o nome corretamente.");
             }
             int opcao = scanner.nextInt();
             scanner.nextLine();

             switch (opcao) {
                 case 1:
                     System.out.println("Digite o novo nome: ");
                     time.setNome(scanner.nextLine());
                     break;
                 case 2:
                     System.out.println("Digite a nova quantidade de títulos: ");
                     time.setTitulos(scanner.nextInt());
                     break;
                 case 3:
                     System.out.println("Digite a nova quantidade de torcedores: ");
                     time.setTorcida(scanner.nextInt());
                     break;
                 case 4:
                     System.out.println("Digite o novo ano de fundação: ");
                     time.setAnoDeFundacao(scanner.nextInt());
                     break;
                 case 5:
                     System.out.println("Digite a nova quantidade de vitórias: ");
                     time.setVitorias(scanner.nextInt());
                     break;
                 case 6:
                     System.out.println("Digite a nova quantidade de derrotas: ");
                     time.setDerrotas(scanner.nextInt());
                     break;
                 case 7:
                     System.out.println("Digite o novo saldo de gols: ");
                     time.setSaldoDeGols(scanner.nextInt());
                     break;
                 case 8:
                     System.out.println("Selecione a nova nacionalidade: ");
                     System.out.println("1-BRASILEIRO, 2-PORTUGUES, 3-INGLES, 4-FRANCES, 5-ARGENTINO, 6-ESPANHOL");
                     int novaOpcaoNacionalidade = scanner.nextInt();
                     TipoTimeEnum novaNacionalidade = TipoTimeEnum.BRASILEIRO; // Valor padrão
                     switch (novaOpcaoNacionalidade) {
                         case 1: novaNacionalidade = TipoTimeEnum.BRASILEIRO; break;
                         case 2: novaNacionalidade = TipoTimeEnum.PORTUGUES; break;
                         case 3: novaNacionalidade = TipoTimeEnum.INGLES; break;
                         case 4: novaNacionalidade = TipoTimeEnum.FRANCES; break;
                         case 5: novaNacionalidade = TipoTimeEnum.ARGENTINO; break;
                         case 6: novaNacionalidade = TipoTimeEnum.ESPANHOL; break;
                     }
                     time.setTipotime(novaNacionalidade);
                     break;
                 default:
                     System.out.println("Opção inválida!");
                     return;
             }
             System.out.println("Time alterado com sucesso!");
             return;
         }
     }


    // exibir detalhe de um unico time, por exemplo quando ele for chamado por ID ou NOME
     public static void exibirDetalhesTime(Time time) {
         System.out.println("\n-----------------------"+
                         "\nNome: " + time.getNome() +
                         "\nFundado em: " + time.getAnoDeFundacao() +
                         "\nNacionalidade: " + time.getTipotime() +
                         "\nTitulos: " + time.getTitulos() +
                         "\nTorcedores: " + time.getTorcida() +
                         "\nVitorias: " + time.getVitorias() +
                         "\nDerrotas: " + time.getDerrotas() +
                         "\nSaldo de Gols: " + time.getSaldoDeGols() +
                         "\n-----------------------"
         );
     }

     // Metodo para excluirTime, utilizando .remove para remover o time informado pelo usuario
     public static void excluirTime(Scanner scanner){
         System.out.println("Digite o nome do time que deseja excluir: ");
         String nomeTime = scanner.nextLine();

         for (int i = 0; i < times.size(); i++) {
             System.out.println("Tem certeza que deseja excluir o seu time?");
             String confirmacao = scanner.nextLine();
             if(confirmacao.equalsIgnoreCase("S")) {
                 if (times.get(i).getNome().equalsIgnoreCase(nomeTime)) {
                     Time timeRemovido = times.remove(i);
                     System.out.println("Time " + timeRemovido.getNome() + " foi removido com sucesso!");

            }else{
                     System.out.println("Operação de exclusão cancelada.");
             }
         }return;
         }
         System.out.println("Time não encontrado!");
     }
    public static void buscarTimeNacionalidade(TipoTimeEnum nacionalidade) {
        System.out.println("Times " + nacionalidade + ":");
        times.stream()
                .filter(time -> time.getTipotime() == nacionalidade)
                .sorted(Comparator.comparing(Time::getNome))
                .forEach(time -> System.out.println(time.getCodigo() + "-" + time.getNome()));

    }
    public static List<Time> buscarTimeComMaisTitulos(int numeroTitulos){
          return times.stream()
                  .filter(time -> time.getTitulos() > numeroTitulos)
                  .sorted(Comparator.comparingInt(Time::getTitulos)
                  .reversed())
                  .collect(Collectors.toList());

    }
    public static List<Time> buscarTimeComMaisTorcida(int numeroTorcida){
            return times.stream()
                    .filter(time -> time.getTorcida() > numeroTorcida)
                    .sorted(Comparator.comparing(Time::getTorcida)
                    .reversed())
                    .collect(Collectors.toList());



    }


 }