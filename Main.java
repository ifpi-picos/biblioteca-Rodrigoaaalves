import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        biblioteca.adicionarLivro(new Livro("A Revolução dos Bichos", "George Orwell", 1945));
        biblioteca.adicionarLivro(new Livro("Dom Casmurro", "Machado de Assis", 1899));

        while (true) {
            System.out.println("\nMenu da Biblioteca");
            System.out.println("1. Registrar Usuário");
            System.out.println("2. Alugar Livro");
            System.out.println("3. Devolver Livro");
            System.out.println("4. Sair");
            System.out.print("Escolha: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            if (escolha == 1) {
                System.out.print("Nome do usuário: ");
                String nome = scanner.nextLine();
                System.out.print("CPF do usuário: ");
                String cpf = scanner.nextLine();

                biblioteca.registrarUsuario(new Usuario(nome, cpf));

            } else if (escolha == 2) {
                System.out.print("Nome do usuário: ");
                String nomeUsuario = scanner.nextLine();
                Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);

                if (usuario != null) {
                    System.out.print("Título do livro: ");
                    String tituloLivro = scanner.nextLine();
                    Livro livro = biblioteca.buscarLivro(tituloLivro);

                    if (livro != null && livro.isDisponivel()) {
                        livro.alugar();
                        System.out.println("Livro alugado com sucesso!");
                    } else {
                        System.out.println("Livro não disponível ou não encontrado.");
                    }
                } else {
                    System.out.println("Usuário não encontrado.");
                }

            } else if (escolha == 3) {
                System.out.print("Título do livro: ");
                String tituloLivro = scanner.nextLine();
                Livro livro = biblioteca.buscarLivro(tituloLivro);

                if (livro != null && !livro.isDisponivel()) {
                    livro.devolver();
                    System.out.println("Livro devolvido com sucesso!");
                } else {
                    System.out.println("Livro não encontrado ou já disponível.");
                }

            } else if (escolha == 4) {
                System.out.println("Encerrando o programa...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
