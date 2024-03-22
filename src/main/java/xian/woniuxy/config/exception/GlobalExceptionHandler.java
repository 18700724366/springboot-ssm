package xian.woniuxy.config.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xian.woniuxy.utli.ResultVo;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultVo catchAll(Exception e) {
        e.printStackTrace();
        return ResultVo.failure(e.toString());
    }
}
