package id.qodev.pentool.service;

import id.qodev.pentool.common.GenericResponseDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(rollbackOn = Exception.class)
public class wordlistService {

    public GenericResponseDTO<?> save(String metode){
        if (metode.equalsIgnoreCase("save")){
            return create();
        } else {
            return edit();
        }
    }

    private GenericResponseDTO<?> create(){
        return new GenericResponseDTO<>().successResponse();
    }

    private GenericResponseDTO<?> edit(){
        return new GenericResponseDTO<>().successResponse();
    }

    public GenericResponseDTO<?> delete(){
        return new GenericResponseDTO<>().successResponse();
    }

    public GenericResponseDTO<?> read(){
        return new GenericResponseDTO<>().successResponse();
    }
}
