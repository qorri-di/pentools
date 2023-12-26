package id.qodev.pentool.service;

import id.qodev.pentool.dto.GeneralResponse;
import id.qodev.pentool.dto.hello.HelloRequestDto;
import id.qodev.pentool.dto.hello.HelloResponseDto;

import javax.inject.Singleton;

@Singleton
public class HelloService {
    public GeneralResponse helloService(HelloRequestDto request) {
        GeneralResponse response=new GeneralResponse();
        HelloResponseDto dataResult=new HelloResponseDto();

        String gender=request.getGender();
        String name=request.getName();
        if (gender==null||gender.isEmpty()) {
            response.setStatus("failed");
            dataResult.setResult(false);
            response.setData(dataResult);
            return response;
        }

        if (name==null||name.isEmpty()) {
            response.setStatus("failed");
            dataResult.setResult(false);
            response.setData(dataResult);
            return response;
        }

        String title=gender.trim().equalsIgnoreCase("M")?"Mr.":"Ms.";
        String message="Hello "+title+name;
        dataResult.setResult(true);
        dataResult.setMessage(message);
        response.setData(dataResult);
        response.setStatus("success");
        return response;
    }
}
