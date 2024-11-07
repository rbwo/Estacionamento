import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Vaga> vagas;
    private List<Veiculo> veiculos;
    private List<Registro> registros;

    public Estacionamento(int numeroDeVagas) {
        vagas = new ArrayList<>();
        veiculos = new ArrayList<>();
        registros = new ArrayList<>();

        for (int i = 1; i <= numeroDeVagas; i++) {
            String tamanho = (i % 3 == 0) ? "grande" : (i % 2 == 0) ? "médio" : "pequeno";
            vagas.add(new Vaga(i, tamanho));
        }
    }

    public boolean registrarEntrada(Veiculo veiculo) {
        // Busca por uma vaga compatível com o tamanho do veículo
        for (Vaga vaga : vagas) {
            if (vaga.isDisponivel() && vaga.getTamanho().equals(veiculo.getTamanho())) {
                vaga.ocupar();
                veiculo.registrarEntrada(LocalDateTime.now());
                veiculos.add(veiculo);
                registros.add(new Registro(veiculo, vaga));
                System.out.println("Entrada registrada: " + veiculo);
                return true;
            }
        }
        System.out.println("Nenhuma vaga disponível para o veículo " + veiculo.getPlaca());
        return false;
    }

    public void registrarSaida(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                
                for (Registro registro : registros) {
                    if (registro.veiculo == veiculo) {
                        veiculo.registrarSaida(LocalDateTime.now());
                        registro.registrarSaida(veiculo);
                        
                        for (Vaga vaga : vagas) {
                            if (vaga.getNumero() == registro.vaga.getNumero()) {
                                vaga.liberar();
                            }
                        }
                        System.out.println("Saída registrada: " + registro);
                        return;
                    }
                }
            }
        }
        System.out.println("Veículo com placa " + placa + " não encontrado.");
    }

    public void gerarRelatorioVagasOcupadas() {
        System.out.println("\nRelatório de Vagas Ocupadas:");
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel()) {
                System.out.println(vaga);
            }
        }
    }

    public void gerarHistoricoVeiculos() {
        System.out.println("\nHistórico de Veículos:");
        for (Registro registro : registros) {
            System.out.println(registro);
        }
    }
}
