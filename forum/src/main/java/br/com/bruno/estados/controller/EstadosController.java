package br.com.bruno.estados.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.estados.model.Estado;
import br.com.bruno.estados.model.StatusRegiao;
import br.com.bruno.estados.repository.EstadoRepository;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;



@RestController
@RequestMapping("api/states") //Caminho Http
public class EstadosController {

    @GetMapping
    public List<Estado> listar(StatusRegiao regiao){
        
        if(regiao == null){
            List<Estado> estados = estadoRepository.findAll(); // Retorna todos os estados
            return estados;
        }else{
            List<Estado> estados = estadoRepository.findByregiao(regiao); // Retorna somente os estados de acordo com o parametro regiao
            return estados;
        }      
          
    }

    @Autowired
    private EstadoRepository estadoRepository;
    @GetMapping("/populacaoOrdenada") 
    public List<Estado> ordernarPopulacao(){
        Sort sort = Sort.by("populacao").descending();//Retorna todos os estados cadastrados com a populacao em ordem decrescente
        return this.estadoRepository.findAll(sort);
    }
    @GetMapping("/areaOrdenada")
    public List<Estado> ordernarArea(){
        Sort sort = Sort.by("area").descending(); //Retorna todos os estados cadastrados com a area em ordem decrescente
        return this.estadoRepository.findAll(sort);
    }

        
    @GetMapping("/{id}")
    public Estado listarPorId(@PathVariable Long id) {
       return estadoRepository.findById(id).get();
}
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estado adicionar(@RequestBody Estado estado){
        return estadoRepository.save(estado);
    }
    @DeleteMapping("/{id}") 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
    estadoRepository.deleteById(id); // deleta item de acordo com o id
    }
    @PutMapping("/{id}")
    public Estado atualizar(@PathVariable Long id,@RequestBody Estado estado){
        Estado estadoAtual = estadoRepository.findById(id).get();
        BeanUtils.copyProperties(estado, estadoAtual,"id"); // atualiza item de acordo com id
        return estadoRepository.save(estadoAtual);
    }
}

