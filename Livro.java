public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean estaDisponivel;

    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.estaDisponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return estaDisponivel;
    }

    public void alugar() {
        estaDisponivel = false;
    }

    public void devolver() {
        estaDisponivel = true;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + anoPublicacao + ")";
    }
}
