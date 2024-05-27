package com.exam.portal.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import lombok.Data;


public class ApiResponse<T> {

		private boolean success;
	    @JsonInclude(NON_NULL)
	    private String message;
		@JsonInclude(NON_NULL)
	    private T data;
		
	    public ApiResponse(boolean success, String message, T data) {
			super();
			this.success = success;
			this.message = message;
			this.data = data;
		}
	    
	    public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public ApiResponse(boolean success, String message) {
	    	this.success = success;
	    	this.message = message;
	    }    
	    
	    public static <T> ApiResponse<T> success(String message, T data) {
	    	return new ApiResponse<>(true, message, data);
		}
	    
	    public static <T> ApiResponse<T> duplicate(String message){
	    	return new ApiResponse<>(false, message, null);
	    }
	    
	    public static <T> ApiResponse<T> error(String message){
	    	return new ApiResponse<>(false, message, null);
	    }
	    
	
}
