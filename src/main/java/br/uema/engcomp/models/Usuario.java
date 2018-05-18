package br.uema.engcomp.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "usuario", schema = "agenda")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "Nome", nullable = false, length = 10)
    private String nome;
    @Basic(optional = false)
    @Column(name = "Senha", nullable = false, length = 6)
    private String senha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Tarefa> tarefaCollection;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Collection<Tarefa> getTarefaCollection() {
        return tarefaCollection;
    }

    public void setTarefaCollection(Collection<Tarefa> tarefaCollection) {
        this.tarefaCollection = tarefaCollection;
    }
}
