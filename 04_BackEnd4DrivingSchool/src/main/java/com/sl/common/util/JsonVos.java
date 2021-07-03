package com.sl.common.util;

import com.sl.common.exception.CommonException;
import com.sl.pojo.result.CodeMsg;
import com.sl.pojo.vo.DataJsonVo;
import com.sl.pojo.vo.JsonVo;
import com.sl.pojo.vo.PageJsonVo;
import com.sl.pojo.vo.PageVo;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

public class JsonVos {
    public static JsonVo ok() {
        return new JsonVo();
    }

    public static JsonVo ok(CodeMsg msg) {
        return new JsonVo(msg);
    }

    public static JsonVo ok(String msg) {
        return new JsonVo(true, msg);
    }

    public static <T> DataJsonVo<T> ok(T data) {
        return new DataJsonVo<>(data);
    }

    public static <T> PageJsonVo<T> ok(PageVo<T> pageVo) {
        PageJsonVo<T> pageJsonVo = new PageJsonVo<>();
        pageJsonVo.setCount(pageVo.getTotal());
        pageJsonVo.setPages(pageVo.getPages());
        pageJsonVo.setData(pageVo.getRecords());
        return pageJsonVo;
    }

    public static JsonVo error(String msg) {
        return new JsonVo(false, msg);
    }

    public static JsonVo error(Throwable t) {
        if (t instanceof CommonException) {
            CommonException ce = (CommonException) t;
            return new JsonVo(ce.getCode(), ce.getMessage());
        } else if (t instanceof BindException) {
            BindException be = (BindException) t;
//            List<ObjectError> errors = be.getBindingResult().getAllErrors();
//            List<String> defaultMsgs = new ArrayList<>(errors.size());
//            for (ObjectError error : errors) {
//               defaultMsgs.add(error.getDefaultMessage());
//            }
            // 函数式编程的方式：stream
            List<String> msgs = be.getBindingResult()
                    .getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList());
            String msg = StringUtils.collectionToDelimitedString(msgs, ", ");
            return error(msg);
        } else if (t instanceof ConstraintViolationException) {
            ConstraintViolationException ce = (ConstraintViolationException) t;
            List<String> msgs = ce.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            String msg = StringUtils.collectionToDelimitedString(msgs, ", ");
            return error(msg);
        } else {
            return error(t.getMessage());
        }
    }

    public static JsonVo raise(String msg) throws CommonException {
        throw new CommonException(msg);
    }

    public static JsonVo raise(CodeMsg codeMsg) throws CommonException {
        throw new CommonException(codeMsg);
    }

}
