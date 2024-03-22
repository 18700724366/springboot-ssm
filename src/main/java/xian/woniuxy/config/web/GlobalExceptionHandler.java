package xian.woniuxy.config.web;


import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xian.woniuxy.utli.ResultVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)

    public ResultVo aa(ArithmeticException e) {
        e.printStackTrace();
        return ResultVo.failure("AAA:" + e.toString());
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)

    public ResultVo bb(ArrayIndexOutOfBoundsException e) {
        e.printStackTrace();
        return ResultVo.failure("BBB:" + e.toString());
    }

    @ExceptionHandler(NullPointerException.class)

    public ResultVo cc(NullPointerException e) {
        e.printStackTrace();
        return ResultVo.failure("CCC:" + e.toString());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultVo handleBindException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        Map<String, String> map = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResultVo.failure(map);
    }

    @ExceptionHandler(Exception.class)

    public ResultVo dd(Exception e) {
        e.printStackTrace();
        return ResultVo.failure("DDD:" + e.toString());
    }
}
