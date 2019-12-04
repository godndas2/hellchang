package org.hellchang.service;

import org.hellchang.model.common.CommonResult;
import org.hellchang.model.common.ResultModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {


    public enum CommonResponse {
        SUCCESS(0, "성공하였습니다."),
        FAILED(-1, "실패하였습니다.");

        int code;
        String message;

        CommonResponse(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    public <T>ResultModel<T> getResultModel(T data, List<T> list) {
        ResultModel<T> result = new ResultModel<>();
        result.setData(data);
        result.setList(list);
        setSuccessResult(result);
        return result;
    }

    // 성공 결과만 처리해주는 method
    public CommonResult getSuccessResult() {
        CommonResult result = new CommonResult();
        setSuccessResult(result);
        return result;
    }

    // 실패 결과만 처리해주는 method
    public CommonResult getFailedResult(int code, String message) {
        CommonResult result = new CommonResult();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    // 결과 모델에 API 요청 성공 data 를 setting 해주는 method
    public void setSuccessResult(CommonResult result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMessage(CommonResponse.SUCCESS.getMessage());
    }

    // 결과 모델에 API 요청 실패 data 를 setting 해주는 method
    // TODO 이 메소드가 필요할까?
    public void setFailedResult(CommonResult result) {
        result.setSuccess(false);
        result.setCode(CommonResponse.FAILED.getCode());
        result.setMessage(CommonResponse.FAILED.getMessage());
    }
}
