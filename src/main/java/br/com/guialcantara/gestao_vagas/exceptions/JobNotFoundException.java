package br.com.guialcantara.gestao_vagas.exceptions;

public class JobNotFoundException extends  RuntimeException{
    public JobNotFoundException(){
        super("Job not Found");
    }
}
