package org.example.desafio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DesafioSnail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("qual o tamanho da matriz? (N): ");
        int N = scanner.nextInt();

        int[][] matriz = new int[N][N];

        System.out.println("Como vc quer preencher a matriz?:");
        System.out.println("digite 1 - Preenchimento sequencial automático");
        System.out.println("digite 2 - Inserir manualmente os elementos");
        int choice = scanner.nextInt();

        if (choice == 1) {
            fillSequentialMatriz(matriz, N);
        } else if (choice == 2) {
            fillMatrizManual(scanner, matriz, N);
        } else {
            System.out.println("Opção inválida.");
            scanner.close();
            return;
        }

        System.out.println("Matriz:");
        printMatriz(matriz, N);

        System.out.println("Lista resultante do padrão caracol:");
        List<Integer> list = createArrayListMatriz(matriz, N);
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        scanner.close();
    }

    private static void printMatriz(int[][] matriz, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void fillSequentialMatriz(int[][] matriz, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matriz[i][j] = i * N + j + 1;
            }
        }
    }

    private static void fillMatrizManual(Scanner scanner, int[][] matriz, int N) {
        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("Elemento [%d][%d]: ", i, j);
                matriz[i][j] = scanner.nextInt();
            }
        }
    }

    private static List<Integer> createArrayListMatriz(int[][] matriz, int N) {
        List<Integer> lista = new ArrayList<>();
        int top = 0, bottom = N - 1, left = 0, right = N - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                lista.add(matriz[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                lista.add(matriz[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    lista.add(matriz[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    lista.add(matriz[i][left]);
                }
                left++;
            }
        }
        return lista;
    }
}
