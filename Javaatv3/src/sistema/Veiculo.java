import java.time.LocalDateTime;

public class Veiculo {
    private String placa;
    private String modelo;
    private String tamanho;  // pequeno, médio, grande
    private LocalDateTime entrada;
    private LocalDateTime saida;

    public Veiculo(String placa, String modelo, String tamanho) {
        this.placa = placa;
        this.modelo = modelo;
        this.tamanho = tamanho;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTamanho() {
        return tamanho;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void registrarEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void registrarSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public long calcularDuracaoHoras() {
        if (entrada != null && saida != null) {
            return java.time.Duration.between(entrada, saida).toHours();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Veículo " + placa + " (" + modelo + ", " + tamanho + ")";
    }
}
