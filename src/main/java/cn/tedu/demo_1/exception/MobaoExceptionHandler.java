package cn.tedu.demo_1.exception;

import cn.tedu.demo_1.vo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MobaoExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public Result<Void> MobaoException(){
        return new Result<Void>(0,"运行异常！");
    }
}
