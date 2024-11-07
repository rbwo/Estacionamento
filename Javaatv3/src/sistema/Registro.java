public class Registro {
    private Veiculo veiculo;
    private Vaga vaga;
    private long duracaoHoras;
    private double valor;

    public Registro(Veiculo veiculo, Vaga vaga) {
        this.veiculo = veiculo;
        this.vaga = vaga;
    }

    public void registrarSaida(Veiculo veiculo) {
        this.duracaoHoras = veiculo.calcularDuracaoHoras();
        this.valor = calcularValor(duracaoHoras);
    }

    public double calcularValor(long duracaoHoras) {
        if (duracaoHoras <= 1) {
            return 5.0;
        } else if (duracaoHoras <= 3) {
            return 10.0;
        } else {
            return 15.0;
        }
    }

    @Override
    public String toString() {
        return "Veículo: " + veiculo.getPlaca() + " | Vaga: " + vaga.getNumero() + 
                " | Tempo: " + duracaoHoras + " horas | Valor: R$ " + valor;
    }
}
