package com.weddingplanner.advices;

import com.weddingplanner.dtos.ErrorResponseDto;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionsAdvices {
    public ErrorResponseDto handleRuntimeException(RuntimeException e){
        ErrorResponseDto dto=new ErrorResponseDto();
        dto.setStatus("Error");
        dto.setMessage(e.getMessage());
        return dto;

    }
    @ExceptionHandler(RuntimeException.class)
    public String handleException(){
        return "something went wrong in controller";
    }
}
