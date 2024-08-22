package tests;

import models.Time;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 public class Principal {

     private static List<Time> times = new ArrayList<>();
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu" +
                    "\n0- Sair" +
                    "\n1- Cadastrar Times" +
                    "\n2- Listar Times" +
                    "\n3- Consultar por ..." +
                    "\n4- Alterar Times" +
                    "\n5- Excluir Times" +
                    "\nDigite a operação desejada: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha){
                case 0:
                    System.out.println("Saindo do programa");
                    break;
                case 1:
                    cadastrarTime(scanner);
                    break;
                case 2:
                    listarTimes();

            }
            }}
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

            Time novoTime = new Time(nome, titulos, torcida, anoDeFundacao, vitorias, derrotas, saldoDeGols);
            times.add(novoTime);
            System.out.println("Time cadastrado com sucesso!");
        }

     public static void listarTimes() {
         if (times.isEmpty()) {
             System.out.println("Nao foi encontrado nenhum time cadastrado, por favor cadastrar um");
         } else {
             System.out.println("Lista de times");
             for (int i = 0; i < times.size(); i++) {
                 Time time = times.get(i);
                 System.out.println((i+1) +"-----------------------"+
                         "\n. " + time.getNome() +
                         "\n Fundado em: " + time.getAnoDeFundacao() +
                         "\n Titulos: " + time.getTitulos() +
                         "\n Torcedores: " + time.getTorcida() +
                         "\n Vitorias: " + time.getVitorias() +
                         "\n Derrotas: " + time.getDerrotas() +
                         "\n Saldo de Gols: " + time.getSaldoDeGols()+
                         "\n-----------------------");
             }
         }
     }}