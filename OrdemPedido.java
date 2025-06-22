import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrdemPedido {
    
    static class Item {
        String categoria;
        String descricao;
        int quantidade;

        public Item(String categoria, String descricao, int quantidade) {
            this.categoria = categoria;
            this.descricao = descricao;
            this.quantidade = quantidade;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Item> itens = new ArrayList<>();

        
        String[] categorias = {"Alimento", "Eletrônico", "Outros"};

        while (true) {
            System.out.print("Informe a descrição do item (ou vazio para finalizar): ");
            String descricao = input.nextLine().trim();

            
            if (descricao.isEmpty()) {
                break;
            }

            System.out.print("Informe a quantidade do item: ");
            int quantidade;
            try {
                quantidade = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Quantidade inválida. Tente novamente.");
                continue;
            }

           
            System.out.println("Selecione a categoria:");
            for (int i = 0; i < categorias.length; i++) {
                System.out.println((i + 1) + ". " + categorias[i]);
            }

            int opcaoCategoria = 0;
            while (true) {
                System.out.print("Digite o número da categoria: ");
                try {
                    opcaoCategoria = Integer.parseInt(input.nextLine());
                    if (opcaoCategoria >= 1 && opcaoCategoria <= categorias.length) {
                        break;
                    } else {
                        System.out.println("Opção inválida. Escolha um número entre 1 e " + categorias.length);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite um número.");
                }
            }

            
            itens.add(new Item(categorias[opcaoCategoria - 1], descricao, quantidade));
        }

        
        System.out.println("\nLista de itens cadastrados:");
        for (Item item : itens) {
            System.out.println(item.categoria + " " + item.descricao + " " + item.quantidade);
        }

        input.close();
    }
}