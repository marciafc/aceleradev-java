package challenge;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Estacionamento {

    private static final int NUMERO_MAXIMO_CARROS_ESTACIONADOS = 10;

    private static final int IDADE_SENIOR = 56;

    private static final int MAIOR_IDADE = 18;

    private static final int NUMERO_PONTOS_CARTEIRA_SUSPENSA = 21;

    private Queue<Carro> carrosEstacionadosFila;

    public Estacionamento() {
        this.carrosEstacionadosFila = new LinkedList();
    }

    public void estacionar(Carro carro) {

        validarMotorista(carro);

        estacionarQuandoTemVaga(carro);

        estacionarQuandoNaoTemVaga(carro);

    }

    public int carrosEstacionados() {
        return carrosEstacionadosFila.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carrosEstacionadosFila.contains(carro);
    }


    /** Quando o estacionamento ainda NÃO está lotado, incrementar o contador de
     * carros e adicionar na fila.
     *
     * @param carro
     */
    private void estacionarQuandoTemVaga(Carro carro) {
        if(carrosEstacionadosFila.size() < NUMERO_MAXIMO_CARROS_ESTACIONADOS) {
            carrosEstacionadosFila.add(carro);
        }
    }

    /**
     * Quando o estacionamento ESTÁ lotado, não é necessário incrementar o contador de
     * carros. E uma vaga deverá ser liberada, conforme as regras:
     *
     • Caso o estacionamento esteja lotado:

     *    - Chegue mais um novo carro, o primeiro que estacionou deverá sair.
     *
     *    - Caso o motorista do primeiro carro estacionado tenha uma idade superior a 55 anos,
     *          será escolhido o próximo motorista abaixo dos 55 (inclusive) anos.
     *
     *    - Caso todos os motoristas, dentro do estacionamento, tenham mais de 55 anos e chegue um motorista,
     *          ele não conseguirá estacionar e será lançada uma exceção (EstacionamentoException).
     *
     *
     * @param carro
     */
    private void estacionarQuandoNaoTemVaga(Carro carro) {
        if(carrosEstacionadosFila.size() == NUMERO_MAXIMO_CARROS_ESTACIONADOS) {

            if(verificarSePrimeiroCarroEstacionadoEhMotoristaSenior()){
                if(liberarVagaParaMotoristaSenior()) {
                    carrosEstacionadosFila.add(carro);
                } else {
                    throw new EstacionamentoException("Não é possível estacionar, todos os carros estacionados pertencem a motoristas sênior (> 55 anos)");
                }
            } else {
                removerCarroEstacionado(Optional.empty());
                carrosEstacionadosFila.add(carro);
            }

        }
    }

    /**
     * Busca o primeiro motorista que não seja sênior (< 56 anos) para sair do estacionamento,
     * liberando assim uma vaga.
     *
     * @return true se conseguir liberar vaga (tem algum motorista que não é sênior) ou false, caso contrário.
     */
    private boolean liberarVagaParaMotoristaSenior() {
        Optional<Carro> carroMotoristaNaoSenior = buscarPrimeiroCarroCujoMotoristaNaoSejaSenior();
        if(carroMotoristaNaoSenior.isPresent()) {
            removerCarroEstacionado(carroMotoristaNaoSenior);
            return true;
        }

        return false;
    }

    private void validarMotorista(Carro carro) {

        if(carro.getMotorista() == null) {
            throw new EstacionamentoException("Para entrar no estacionamento, é necessário que exista um motorista. Não é permitido carro autônomo.");
        }

        if(carro.getMotorista().getIdade() < MAIOR_IDADE) {
            throw new EstacionamentoException("O motorista precisa ter idade suficiente para dirigir e possuir uma habilitação (idade >= 18).");
        }

        if(carro.getMotorista().getPontos() >= NUMERO_PONTOS_CARTEIRA_SUSPENSA) {
            throw new EstacionamentoException("A habilitação não deverá está suspensa, ou seja, a pontuação da carteira de motorista não deverá ser superior a vinte pontos.");
        }
    }

    private boolean verificarSePrimeiroCarroEstacionadoEhMotoristaSenior() {
        Carro primeiroCarroEstacionado =  carrosEstacionadosFila.peek();
        return primeiroCarroEstacionado != null && primeiroCarroEstacionado.getMotorista().getIdade() >= IDADE_SENIOR;
    }

    private Optional<Carro> buscarPrimeiroCarroCujoMotoristaNaoSejaSenior() {
        return carrosEstacionadosFila.stream().filter(c -> c.getMotorista().getIdade() < IDADE_SENIOR).findFirst();
    }

    private void removerCarroEstacionado(Optional<Carro> carro) {
        if(carro.isPresent()) {
            boolean removeu = carrosEstacionadosFila.remove(carro.get());
            System.out.println(removeu);
        } else {
            carrosEstacionadosFila.remove();
        }
    }
}
