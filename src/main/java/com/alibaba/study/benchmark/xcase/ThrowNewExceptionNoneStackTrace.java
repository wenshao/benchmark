package com.alibaba.study.benchmark.xcase;

public class ThrowNewExceptionNoneStackTrace extends BenchmarkCaseAdapter {
	private Exception exception;

	public ThrowNewExceptionNoneStackTrace() {
		super("Exception.new-throw-catch (not fillInStackTrace)");
	}

	public void execute() {
		try {
			f();
		} catch (Exception ex) {
			exception = ex;
		}
	}

	public void f() throws Exception {
		throw new NoneStackTraceException();
	}


	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	public static class NoneStackTraceException extends Exception {
		private static final long serialVersionUID = 1L;

		public Throwable fillInStackTrace() {
			return this;
		}
	}

}
