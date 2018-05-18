package br.uema.engcomp.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tarefa", schema = "agenda")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "Data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "Descricao", nullable = false, length = 30)
    private String descricao;
    @JoinColumn(name = "id_Usuario", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}
