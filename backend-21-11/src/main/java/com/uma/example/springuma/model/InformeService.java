package com.uma.example.springuma.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uma.example.springuma.utils.ImageUtils;

import java.util.Map;


@Service
public class InformeService {

    @Autowired
    private RepositoryInforme repositoryInforme;

    public List<Informe> getAllInformes() {
        return repositoryInforme.findAll();
    }

    public Informe getInforme(Long id) {
        return repositoryInforme.findById(id).orElse(null);
    }

    
    public Informe addInforme(Informe informe) {
        String neew_pred = getNewPrediccion(informe);
        System.out.println(neew_pred);
        informe.setPrediccion(neew_pred);

        return repositoryInforme.saveAndFlush(informe);
    }
    

    
    public void updateInforme(Informe informe) {
        // Puedes implementar la lógica de actualización según tus necesidades
        // Aquí se muestra un ejemplo básico:
        Informe existingInforme = repositoryInforme.findById(informe.getId()).orElse(null);
        if (existingInforme != null) {
            existingInforme.setPrediccion(getNewPrediccion(existingInforme));
            existingInforme.setContenido(informe.getContenido());
            repositoryInforme.save(existingInforme);
        }
    }
    

    public void removeInforme(Informe informe) {
        repositoryInforme.delete(informe);
    }

    public void removeInformeByID(Long id) {
        repositoryInforme.deleteById(id);
    }

    public List<Informe> getInformesImagen(Long id) {
        return repositoryInforme.findByImagenId(id);
    }

    
    public String getNewPrediccion(Informe informe){
        try{
        Map<String, Double> response = ImagenAPIPredictor.query(ImageUtils.decompressImage(informe.getImaagen().getFile_content()));
        //informe.setPrediccion((String)response.get("0"));
        System.out.println("resp");
        System.out.println( response);
        double score_0 = response.get("LABEL_0");
        double score_1 = response.get("LABEL_1");
        System.out.println("resp");
        System.out.println( response);
        String resulString;
        if (score_0 > score_1){
            resulString = "Not cancer (label 0),  score: " + score_0;
        }else{
            resulString = "Cancer (label 1), score: " + score_1;
        }
        return resulString;

    }catch(Exception e){
        return "Model is loading: ";
    }
        
        
    }
    
}
