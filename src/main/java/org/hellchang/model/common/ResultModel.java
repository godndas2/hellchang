package org.hellchang.model.common;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
* @author halfdev
* @since 2019-12-04
    결과 API 를 담는 모델
    Generic Interface<T> 로 지정하여 모든 형태의 값을 넣을 수 있도록 구현
*/
@Getter
@Setter
public class ResultModel<T> extends CommonResult {

    private T data; // Single Row
    private List<T> list;
}
