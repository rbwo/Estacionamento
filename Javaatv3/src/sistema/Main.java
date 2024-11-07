public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento(5);

        Veiculo veiculo1 = new Veiculo("ABC1234", "Fusca", "pequeno");
        Veiculo veiculo2 = new Veiculo("XYZ5678", "Civic", "médio");
        Veiculo veiculo3 = new Veiculo("LMN9012", "Picasso", "grande");

        estacionamento.registrarEntrada(veiculo1);
        estacionamento.registrarEntrada(veiculo2);
        estacionamento.registrarEntrada(veiculo3);

        try { Thread.sleep(2000); } catch (InterruptedException e) { }
        estacionamento.registrarSaida("ABC1234");

        estacionamento.gerarRelatorioVagasOcupadas();
        estacionamento.gerarHistoricoVeiculos();
    }
}
