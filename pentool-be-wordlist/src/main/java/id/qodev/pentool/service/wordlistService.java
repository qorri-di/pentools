package id.qodev.pentool.service;

import id.qodev.pentool.common.GenericResponseDTO;
import id.qodev.pentool.dto.createOrUpdateRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(rollbackOn = Exception.class)
public class wordlistService {

    public GenericResponseDTO<?> save(createOrUpdateRequest request){
        if (request.getMethode().equalsIgnoreCase("save")){
            return create(request);
        } else {
            return edit(request);
        }
    }

    private GenericResponseDTO<?> create(createOrUpdateRequest request){
        if (request.getName() == null || request.getName().isEmpty()){
            return new GenericResponseDTO<>().errorResponse(204,"Name is required");
        } else {
            return new GenericResponseDTO<>().successResponse();
        }
    }

    private GenericResponseDTO<?> edit(createOrUpdateRequest request){
        return new GenericResponseDTO<>().successResponse();
    }

    public GenericResponseDTO<?> delete(){
        return new GenericResponseDTO<>().successResponse();
    }

    public GenericResponseDTO<?> read(){
        return new GenericResponseDTO<>().successResponse();
    }
}