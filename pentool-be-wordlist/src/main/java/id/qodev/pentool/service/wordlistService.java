package id.qodev.pentool.service;

import id.qodev.pentool.common.*;
import id.qodev.pentool.dto.*;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(rollbackOn = Exception.class)
public class wordlistService {
    @Inject
    Logger log;

    public GenericResponseDTO<?> save(createOrUpdateRequest request){
        if (request.getMethode().equalsIgnoreCase("save")){
            return create(request);
        } else {
            return edit(request);
        }
    }

    private GenericResponseDTO<?> create(createOrUpdateRequest request){
        if (request.getName() == null || request.getName().isEmpty() &&
                request.getType() == null || request.getType().isEmpty()){
            log.infof("-+[ END CREATE %s ]+-", "Input is required");
            return new GenericResponseDTO<>().errorResponse(204,"Input is required");
        } else {
            String[] input = request.getName().split("\n");
            for (String word : input){
                System.out.println(word);
            }
            log.infof("-+[ END CREATE %s ]+-", "Process Successed");
            return new GenericResponseDTO<>().successResponse();
        }
    }

    private GenericResponseDTO<?> edit(createOrUpdateRequest request){
        if (request.getId() == null || request.getId().isEmpty()
                && request.getName() == null || request.getName().isEmpty()
                && request.getType() == null || request.getType().isEmpty()){
            log.infof("-+[ END UPDATE %s ]+-", "Input is required");
            return new GenericResponseDTO<>().errorResponse(204,"Input is required");
        } else {
            log.infof("-+[ END UPDATE %s ]+-", "Process Successed");
            return new GenericResponseDTO<>().successResponse();
        }
    }

    public GenericResponseDTO<?> delete(createOrUpdateRequest request){
        if (request.getMethode().equalsIgnoreCase("delete")){
            log.infof("-+[ END DELETE %s ]+-", "Process Successed");
            return new GenericResponseDTO<>().successResponse();
        }
        log.infof("-+[ END DELETE %s ]+-", "Input is required");
        return new GenericResponseDTO<>().errorResponse(204,"Methode not found");
    }

    public GenericResponseDTO<?> read(wordlistRequest request){
        if (request.getMethode() == null) {
            switch (request.getMethode().toLowerCase()) {
                case "getall":
                    return getAll(request);
                case "getkeyword":
                    return getByKeyword(request);
                default:
                    return getAll(request);
            }
        }
        log.infof("-+[ END READ %s ]+-", "Input is required");
        return new GenericResponseDTO<>().errorResponse(204,"Input is required");
    }

    private GenericResponseDTO<?> getAll(wordlistRequest request){
        log.infof("-+[ END GET ALL %s ]+-", "Process Successed");
        return new GenericResponseDTO<>().successResponse();
    }

    private GenericResponseDTO<?> getByKeyword(wordlistRequest request){
        log.infof("-+[ END GET BY KEYWORD %s ]+-", "Process Successed");
        return new GenericResponseDTO<>().successResponse();
    }
}
