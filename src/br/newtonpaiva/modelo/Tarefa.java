/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.newtonpaiva.modelo;

//Ctrl + Shift + i

import br.newtonpaiva.modelo.erros.NomeTarefaInvalidoException;
import br.newtonpaiva.modelo.erros.PrioridadeTarefaInvalidaException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Esta classe é responsável por mapear uma tarefa do sistema.
 * Essa tarefa pode ser gravada na base de dados, .......
 * 
 * @author Tarley Lana
 */

// POJO
// 

public class Tarefa implements Comparable<Tarefa>{
    /* Atributos */
    private Integer id; // 10
    private String nome;
    private Integer prioridade;
    private Calendar dataLimite;
    private String situacao;
    private Integer percentual;
    private String descricao;

    public Tarefa() {
    }

    /**
     * Construtor de tarefa basica.
     * @param nome Este é o nome da tarefa.
     * @param prioridade Esta é a prioridade da tarefa
     */
    public Tarefa(String nome, Integer prioridade) {
        this.nome = nome;
        this.prioridade = prioridade;
    }

    public Tarefa(Integer id, String nome, Integer prioridade, Calendar dataLimite, String situacao, Integer percentual, String descricao) throws NomeTarefaInvalidoException, PrioridadeTarefaInvalidaException {
        
        if(nome == null || nome.trim().isEmpty()) {
            throw new NomeTarefaInvalidoException();
        }
        
        if(prioridade == null) {
            throw new PrioridadeTarefaInvalidaException();
        }
        
        
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
        this.dataLimite = dataLimite;
        this.situacao = situacao;
        this.percentual = percentual;
        this.descricao = descricao;
    }

    
    
    /**
     * Esse método grava na base de dados na tabela chamada tb_tarefa
     * um registro de tarefa.
     * 
     * @throws IOException Erro caso o arquivo tarefa.csv não exista no disco.
     */
    public void salvar() throws IOException {
        Path arquivo = Paths.get("tarefa.csv");
       
        String conteudo = this.nome + ";" + this.prioridade +
                ";" + this.situacao + ";" + this.percentual + 
                ";" + this.descricao + "\n";
        
        Files.write(arquivo, conteudo.getBytes(),
                StandardOpenOption.APPEND);
    }
    
    public void excluir() {
        // excluir no banco de dados
        System.out.println("Executou o excluir");
    }
    
    public static List<Tarefa> listar() throws IOException, 
            NomeTarefaInvalidoException, PrioridadeTarefaInvalidaException {
        // Buscar do banco de dados as tarefas
        System.out.println("Executou o listar");
        
        Path arquivo = Paths.get("tarefa.csv");
        List<String> linhas = Files.readAllLines(arquivo);
        
        List<Tarefa> listaParaRetorno = new LinkedList<>();
        
        // Percorer as linhas retornadas
        for(String linha : linhas) {
            // Quebrar a string em ;
            String[] informacoes = linha.split(";");
            String nome = informacoes[0];
            Integer prioridade = Integer.parseInt(informacoes[1]);
            Calendar dataLimite = Calendar.getInstance();
            String situacao = informacoes[2];
            Integer percentual = Integer.parseInt(informacoes[3]);
            String descricao = informacoes[4];

            // Criar objeto e popular com as informações
            Tarefa t = new Tarefa(null, nome, prioridade, dataLimite, situacao, percentual, descricao);
            
            // Armazenar em uma lista de tarefas
            listaParaRetorno.add(t);
        }
//        Collections.sort(listaParaRetorno, new Comparator<Tarefa>() {
//            @Override
//            public int compare(Tarefa o1, Tarefa o2) {
//                return o1.getPrioridade().compareTo(o2.getPrioridade());
//            }
//        });
        
        Collections.sort(listaParaRetorno);
        return listaParaRetorno;
    }
    
    public static List<Tarefa> listar(String filtro) throws IOException, 
            NomeTarefaInvalidoException, PrioridadeTarefaInvalidaException {
        
        List<Tarefa> listaParaRetorno = listar();
        
        Iterator<Tarefa> i = listaParaRetorno.iterator();
        
        while(i.hasNext()) {
            Tarefa t = i.next();
            
            if(!t.getNome().toUpperCase().contains(filtro.toUpperCase()))
                i.remove();
        }
        
        return listaParaRetorno;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the prioridade
     */
    public Integer getPrioridade() {
        return prioridade;
    }

    /**
     * @param prioridade the prioridade to set
     */
    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    /**
     * @return the dataLimite
     */
    public Calendar getDataLimite() {
        return dataLimite;
    }

    /**
     * @param dataLimite the dataLimite to set
     */
    public void setDataLimite(Calendar dataLimite) {
        this.dataLimite = dataLimite;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the percentual
     */
    public Integer getPercentual() {
        return percentual;
    }

    /**
     * @param percentual the percentual to set
     */
    public void setPercentual(Integer percentual) {
        this.percentual = percentual;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "id=" + id + ", nome=" + nome + ", prioridade=" + prioridade + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarefa other = (Tarefa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
 
        return true;
    }

    @Override
    public int compareTo(Tarefa o) {
//        Integer minhaPrioridade = getPrioridade();
//        Integer outraPrioridade = o.getPrioridade();
//        
//        return minhaPrioridade.compareTo(outraPrioridade);

          String meuNome = getNome();
          String outroNome = o.getNome();
          
          return meuNome.toUpperCase().compareTo(outroNome.toUpperCase()) * -1;
    }
}
