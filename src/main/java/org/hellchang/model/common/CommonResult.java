package org.hellchang.model.common;

import lombok.Getter;
import lombok.Setter;

/**
* @author halfdev
* @since 2019-12-04
* API 실행 결과를 담는 공통 모델
*/
@Setter
@Getter
public class CommonResult {

     private boolean success;

     private int code;

     private String message;
}
