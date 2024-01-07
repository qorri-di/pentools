package id.qodev.pentool.service;

import id.qodev.pentool.common.GenericResponseDTO;
import id.qodev.pentool.common.helpers.Generate;
import id.qodev.pentool.domain.*;
import id.qodev.pentool.dto.*;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@ApplicationScoped
@Transactional(rollbackOn = Exception.class)
public class typeService extends Generate {
    @Inject
    Logger log;
    public GenericResponseDTO<?> createType(typeRequest request){
        List<String> input = getList(request.getTypeName());
        AtomicReference<String> message = new AtomicReference<>("");
        System.out.println(input);
        if (!input.isEmpty()) {
            AtomicInteger i = new AtomicInteger();
            input.forEach(typeName -> {
                mstType data = mstType.find("typeName = ?1", typeName).firstResult();
                if (data != null) {
                    message.set("Data already exist");
                } else {
                    mstType type = new mstType();
                    type.setTypeId(typeId()+i.get());
                    type.setTypeName(typeName);
                    type.setStatus(1);
                    type.persist();
                    i.incrementAndGet();
                }
            });
        }
        log.infof("-+[ END CREATE TYPE %s ]+-", "Process Successed");
        return new GenericResponseDTO<>().successResponse(message.get().isEmpty() ? request.getTypeName() : message.get());
    }

    public GenericResponseDTO<?> getAll(){
        List<mstType> allType = mstType.find("status = ?1 order by typeName asc", 1).list();
        if (!allType.isEmpty()){
            List<typeRequest> type = new ArrayList<>();

            allType.forEach(data -> {
                typeRequest request = new typeRequest();
                request.setTypeId(data.getTypeId());
                request.setTypeName(data.getTypeName());
                type.add(request);
            });

            log.infof("-+[ END READ TYPE %s ]+-", "Process Successed");
            return new GenericResponseDTO<>().successResponse(type);
        } else {
            log.infof("-+[ END READ TYPE %s ]+-", "Data not found");
            return new GenericResponseDTO<>().errorResponse(204,"Data not found");
        }
    }

    public GenericResponseDTO<?> updateType(typeRequest request){
        mstType data = mstType.find("typeName = ?1", request.getTypeName()).firstResult();
        if (data != null){
            log.infof("-+[ END UPDATE TYPE %s ]+-", "Data already exist");
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
            log.infof("-+[ END UPDATE TYPE %s ]+-", "Process Successed");
            return new GenericResponseDTO<>().successResponse(request);
        }
    }

    public GenericResponseDTO<?> deleteType(typeRequest request){
        mstType data = mstType.find("typeId = ?1", request.getTypeId()).firstResult();
        if (data == null){
            log.infof("-+[ END DELETE TYPE %s ]+-", "Data not found");
            return new GenericResponseDTO<>().errorResponse(204,"Data not found");
        } else {
            data.setStatus(0);
            data.persist();
            log.infof("-+[ END DELETE TYPE %s ]+-", "Process Successed");
            return new GenericResponseDTO<>().successResponse();
        }
    }
}
