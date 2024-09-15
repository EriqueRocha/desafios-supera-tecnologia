package org.example.desafio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DesafioResistores {
    public static void main(String[] args) {
        System.out.println("Digite a quantidade de Ohms. Ex: 47 ohms");
        System.out.println("Digite *sair* para encerrar");
        Scanner scanner = new Scanner(System.in);
        String entrada;
        do {
            System.out.print("Ohms: ");
            entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            String qtdOhms = entrada.split(" ")[0];
            int decimalPlaces = qtdOhms.length();
            String gold = "dourado";

            if (qtdOhms.contains("k")) {
                if (decimalPlaces == 2) {
                    System.out.println(getResitor(qtdOhms, getColor(2), getColor(0), true));
                } else if (decimalPlaces == 3) {
                    System.out.println(getResitor(qtdOhms, getColor(3), null, true));
                }
            } else if (qtdOhms.contains("M")) {
                if (decimalPlaces == 2) {
                    System.out.println(getResitor(qtdOhms, getColor(5), getColor(0), true));
                } else if (decimalPlaces == 3) {
                    System.out.println(getResitor(qtdOhms, getColor(6), null, true));
                }
            } else {
                if (decimalPlaces == 1) {
                    System.out.println(getResitor(qtdOhms, gold, getColor(0), false));
                } else if (decimalPlaces == 2) {
                    System.out.println(getResitor(qtdOhms, getColor(0), null, false));
                } else if (decimalPlaces == 3) {
                    System.out.println(getResitor(qtdOhms, getColor(1), null, true));
                } else {
                    System.out.println("Revise o valor inserido");
                }
            }
        } while (!entrada.equalsIgnoreCase("sair"));

        System.out.println("Obrigado, até mais");
        scanner.close();
    }

    public static List<String> getResitor(String qtdOhms, String colorPlace, String baseColor, boolean removeOne) {
        String ohms;
        if (removeOne) {
            ohms = qtdOhms.substring(0, qtdOhms.length() - 1);
        } else {
            ohms = qtdOhms;
        }
        List<String> colors = new ArrayList<>();
        new ArrayList<>();

        for (int i = 0; i < ohms.length(); i++) {
            char character = ohms.charAt(i);
            int number = Character.getNumericValue(character);

            String color = getColor(number);
            colors.add(color);
        }
        if (baseColor != null) {
            colors.add(baseColor);
        }
        colors.add(colorPlace);
        colors.add("dourado");
        return colors;
    }

    public static String getColor(int valor) {
        String cor;
        switch (valor) {
            case 0:
                cor = "preto";
                break;
            case 1:
                cor = "marrom";
                break;
            case 2:
                cor = "vermelho";
                break;
            case 3:
                cor = "laranja";
                break;
            case 4:
                cor = "amarelo";
                break;
            case 5:
                cor = "verde";
                break;
            case 6:
                cor = "azul";
                break;
            case 7:
                cor = "violeta";
                break;
            case 8:
                cor = "cinza";
                break;
            case 9:
                cor = "branco";
                break;
            default:
                cor = "valor inválido";
                break;
        }
        return cor;
    }
}