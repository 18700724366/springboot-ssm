package xian.woniuxy.utli;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo {
    private Integer code;
    private String msg;
    private Object data;

    public static ResultVo success(String msg) {
        ResultVo success = new ResultVo();
        success.setCode(HttpStatus.OK.value());
        success.setMsg(msg);
        return success;
    }

    public static ResultVo success(Object data) {
        ResultVo success = new ResultVo();
        success.setCode(HttpStatus.OK.value());
        success.setMsg("success");
        success.setData(data);
        return success;
    }

    public static ResultVo success() {
        ResultVo success = new ResultVo();
        success.setCode(HttpStatus.OK.value());
        success.setMsg("success");
        return success;
    }

    public static ResultVo success(String msg, Object data) {
        ResultVo success = new ResultVo();
        success.setCode(HttpStatus.OK.value());
        success.setMsg(msg);
        success.setData(data);
        return success;
    }

    public static ResultVo failure() {
        ResultVo failure = new ResultVo();
        failure.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        failure.setMsg("failure");
        return failure;
    }

    public static ResultVo failure(String msg) {
        ResultVo failure = new ResultVo();
        failure.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        failure.setMsg(msg);
        return failure;
    }

    public static ResultVo failure(Object data) {
        ResultVo failure = new ResultVo();
        failure.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        failure.setMsg("failure");
        failure.setData(data);
        return failure;
    }

    public static ResultVo failure(String msg, Object data) {
        ResultVo failure = new ResultVo();
        failure.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        failure.setMsg(msg);
        failure.setData(data);
        return failure;
    }
}