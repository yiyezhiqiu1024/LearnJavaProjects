package com.sl.common.enhance;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

public class MpLambdaQueryWrapper<T> extends LambdaQueryWrapper<T> {
    @SafeVarargs
    public final MpLambdaQueryWrapper<T> like(Object val, SFunction<T, ?>... funcs) {
        if (val == null) return this;
        String str = val.toString();
        if (0 == str.length()) return this;
        return (MpLambdaQueryWrapper<T>) nested((w) -> {
            for (SFunction<T, ?> func : funcs)  w.like(func, str).or(); // 使用nested方法，查询语句会忽略最后一个 OR
        });
    }
}
