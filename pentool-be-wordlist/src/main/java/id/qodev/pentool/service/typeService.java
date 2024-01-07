package id.qodev.pentool.service;

import id.qodev.pentool.common.GenericResponseDTO;
import id.qodev.pentool.common.helpers.Generate;
import id.qodev.pentool.domain.*;
import id.qodev.pentool.dto.*;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.*;

@ApplicationScoped
@Transactional(rollbackOn = Exception.class)
public class typeService extends Generate {
    public GenericResponseDTO<?> createType(typeRequest request){
        mstType data = mstType.find("typeName = ?1", request.getTypeName()).firstResult();
        if (data != null){
            return new GenericResponseDTO<>().errorResponse(204,"Data already exist");
        } else {
            mstType type = new mstType();
            type.setTypeId(typeId());
            type.setTypeName(request.getTypeName());
            type.setStatus(1);
            type.persist();
            return new GenericResponseDTO<>().successResponse(request);
        }
    }

    public GenericResponseDTO<?> getAll(){
        List<mstType> allType = mstType.find("status = ?1 order by typeName asc", 1).list();
        return new GenericResponseDTO<>().successResponse(allType);
    }

    public GenericResponseDTO<?> updateType(typeRequest request){
        mstType data = mstType.find("typeName = ?1", request.getTypeName()).firstResult();
        if (data != null){
            return new GenericResponseDTO<>().errorResponse(204,"Data already exist");
        } else {
            if (request.getTypeId() == null){
                data.setTypeId(data.getTypeId());
            } else {
                data.setTypeId(request.getTypeId());
            }

            if (request.getTypeName() == null){
                data.setTypeName(data.getTypeName());
            } else {
                data.setTypeName(request.getTypeName());
            }
            data.setStatus(1);
            data.persist();
            return new GenericResponseDTO<>().successResponse(request);
        }
    }

    public GenericResponseDTO<?> deleteType(typeRequest request){
        mstType data = mstType.find("typeId = ?1", request.getTypeId()).firstResult();
        if (data == null){
            return new GenericResponseDTO<>().errorResponse(204,"Data not found");
        } else {
            data.setStatus(0);
            data.persist();
            return new GenericResponseDTO<>().successResponse();
        }
    }
}
