package com.my.ssm.core.exception;

/**
 * 自定义业务异常信息
 * 
 * @ClassName  BizException        
 * 
 * @author WJ
 * @date   2019年4月17日 下午12:19:49   
 *
 */
public class BizException extends RuntimeException {
    
	private static final long serialVersionUID = 1564616119872069352L;
	
	private String err;
    private Object arg0;
    private Object[] args;

    /**
     * 抛出业务异常
     * 
     * @param arg0 异常代码
     * @param arg1 异常信息
     * @param arg2 其他信息
     */
    public BizException(String arg0, String arg1) {
        super(arg1);
        this.err = arg0;
    }

    /**
     * 抛出业务异常
     * 
     * @param arg0 异常代码
     * @param arg1 异常信息
     * @param arg2 其他信息
     */
    public BizException(String arg0, String arg1, Object arg2) {
        super(arg1);
        this.err = arg0;
        this.arg0 = arg2;
    }

    /**
     * 抛出业务异常
     * 
     * @param arg0 异常代码
     * @param arg1 异常信息
     * @param arg2 其他信息
     */
    public BizException(String arg0, String arg1, Object... arg2) {
        super(arg0);
        this.err = arg1;
        this.args = arg2;
    }

    public String getErrCode() {
        return err;
    }

    public Object getArg0() {
        return arg0;
    }

    public Object[] getArg1() {
        return args;
    }

}
