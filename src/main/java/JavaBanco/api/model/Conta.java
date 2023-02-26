package JavaBanco.api.model;

import JavaBanco.api.model.enums.TipoConta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "conta")
public class Conta {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer agencia;

    private String numConta;

    private Double saldoAtual;

    private TipoConta tipoConta;

    private LocalDateTime dataCriacao;

    @ElementCollection
    @CollectionTable(name = "extrato")
    private List<String> extratoBancario = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "conta")
    private List<Cartao> cartao;
}

